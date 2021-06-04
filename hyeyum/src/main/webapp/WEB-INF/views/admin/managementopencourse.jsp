<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">강의개설관리</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html" class = "text-muted">courselist</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- *************************************************************** -->
                <!-- Start First Cards -->
                <!-- *************************************************************** -->
                <!-- *************************************************************** -->
                <!-- End First Cards -->
                <!-- *************************************************************** -->
                <!-- *************************************************************** -->
                <!-- Start Top Leader Table -->
                <!-- *************************************************************** -->
                <div class="row">
                    <div class="col-12">
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 미승인강좌목록</p>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                        <thead>
                                            <tr>
                                                <th>과목코드</th>
                                                <th>과목명</th>
                                                <th>담당학과</th>
                                                <th>담당교수</th>
                                                <th>학점</th>
                                                <th>강의실</th>
                                                <th>수업시간</th>
                                                <th>수강정원</th>
                                                <th>강의계획서</th>
                                                <th>승인처리</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="course">
                                            <tr>
                                                <td>${course.coursno}</td>
                                                <td>${course.name}</td>
                                                <td>${course.dname}</td>
                                                <td>${course.pname}</td>
                                                <td>${course.credit}</td>
                                                <td>${course.locno}</td>
                                                <td>
                                                <c:choose>
                                                <c:when test="${course.day eq 1}">월</c:when>
                                                <c:when test="${course.day eq 2}">화</c:when>
                                                <c:when test="${course.day eq 3}">수</c:when>
                                                <c:when test="${course.day eq 4}">목</c:when>
                                                <c:when test="${course.day eq 5}">금</c:when>
                                                </c:choose>
                                                <c:forEach begin="${course.startTime}" end="${course.endTime}" step="1" var="i">
                                                ${i} 
                                                </c:forEach>
                                                </td>
                                                <td>${course.maxnum}</td>
                                                <td class="text-center">
	                                               	<c:if test="${not empty course.attachList[0]}">
	                                               	<a href="${pageContext.request.contextPath}/download?fileName=${course.attachList[0].downloadPath}" type="button" class="btn btn-secondary btn-sm">보기</a>
	                                               	</c:if>
	                                               	<c:if test="${empty course.attachList[0]}">
	                                               	<button type="button" class="btn btn-secondary btn-sm" disabled>보기</button>
	                                               	</c:if>
                                               	</td>
                                                <td class="text-center"><form method="post" action="${pageContext.request.contextPath}/admin/managementopencourse"><input type="hidden" name="coursno" value="${course.coursno}"><input type="hidden" name="enable" value="${course.enable}"><button type="submit" class="btn btn-secondary btn-sm" formaction="">승인</button><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form></td>
                                            </tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- *************************************************************** -->
                <!-- End Top Leader Table -->
                <!-- *************************************************************** -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
			<div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show course-success" role="alert">
	    		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        		<span aria-hidden="true">×</span>
	    		</button>
	    		<strong>성공 - </strong> 강의 승인을 완료하였습니다.
		  	</div>
		 	 <div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show course-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>실패 - </strong> 강의 승인 실패하였습니다.
          	 </div>
           
           <script>
				var msg = "${msg}";
				
				if(msg == "success") {
					$(".course-success").show();
					setTimeout(function() {
					$(".course-success").hide();
					}, 3000);
				}else if(msg == "fail") {
					$(".course-fail").show();
					setTimeout(function() {
					$(".course-fail").hide();
					}, 3000);
				}
			</script>

<jsp:include page="../includes/footer.jsp" />