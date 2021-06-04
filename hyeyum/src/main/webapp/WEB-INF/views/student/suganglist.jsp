<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
		<!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper course-list-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">수강신청내역조회</h4>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html" class="text-muted">수강/성적</a></li>
                                    <li class="breadcrumb-item text-muted active" aria-current="page">수강</li>
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
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- basic table -->
                <div class="row">
                    <div class="col-12">
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                                <div class="table-responsive col-md-12">
                                	<div class="row mb-3">
		                            	<p class="card-title"><i class="fas fa-list"></i> 수강신청내역</p>
                                	</div>
                                    <div class="row table-container">
	                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
	                                        <thead>
	                                            <tr class="text-center">
	                                                <th>과목코드</th>
	                                                <th>과목명</th>
	                                                <th>담당학과</th>
	                                                <th>담당교수</th>
	                                                <th>학점</th>
	                                                <th>강의실</th>
	                                                <th>수업시간</th>
	                                                <th>수강정원</th>
	                                                <th>수강인원</th>
	                                                <th>강의계획서</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${list}" var="course">
		                                            <tr>
		                                                <td class="text-center">${course.coursno}</td>
		                                                <td>${course.name}</td>
		                                                <td>${course.dname}</td>
		                                                <td class="text-center">${course.pname}</td>
		                                                <td class="text-center">${course.credit}</td>
		                                                <td class="text-center">${course.locno}</td>
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
		                                                <td class="text-center">${course.maxnum}</td>
		                                                <td class="text-center">${course.sugangNum}</td>
		                                                <td class="text-center">
		                                                	<c:if test="${not empty course.attachList[0]}">
		                                                	<a href="${pageContext.request.contextPath}/download?fileName=${course.attachList[0].downloadPath}" type="button" class="btn btn-secondary btn-sm">보기</a>
		                                                	</c:if>
		                                                	<c:if test="${empty course.attachList[0]}">
		                                                	<button type="button" class="btn btn-secondary btn-sm" disabled>보기</button>
		                                                	</c:if>
	                                                	</td>
		                                            </tr>
	                                        	</c:forEach>
	                                        </tbody>
	                                    </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
		</div>
<jsp:include page="../includes/footer.jsp" />