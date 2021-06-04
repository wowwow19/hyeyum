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
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">Professor</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html">courselist</a>
                                    </li>
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
            	<div class="row">
                    <div class="col-12">
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 상담내역 조회</p>
                            	  <div class="ml-auto mr-3">
                					<a href="${pageContext.request.contextPath}/professor/counsel" class="btn btn-primary btn-sm">상담작성</a>
             					   </div>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                        <thead>
                                            <tr>
                                                <th>상담번호</th>
                                                <th>상담내용</th>
                                                <th>상담일자</th>
                                                <th>상담작성일</th>
                                                <th>교수번호</th>
                                                <th>학생번호</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="counsel">
                                            <tr>
                                                <td>${counsel.counno}</td>
                                                <td>${counsel.content}</td>
                                                <td><fmt:formatDate value="${counsel.coundate}"/></td>
                                                <td><fmt:formatDate value="${counsel.regdate}"/></td>
                                                <td>${counsel.profno}</td>
                                                <td>${counsel.studno}</td>
                                            </tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
               <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show counsellist-update-success" role="alert">
			   	 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        <span aria-hidden="true">×</span>
			  	  </button>
			    	<strong>성공 - </strong> 상담내용 작성이 완료되었습니다.
				</div>
            </div>
            <script>
            var msg = "${msg}";
			
			if(msg == "success") {
				$(".counsellist-update-success").show();
				setTimeout(function() {
				$(".counsellist-update-success").hide();
				}, 3000);
			}
			</script>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />