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
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">Admin</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html">Student List</a>
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
                            	<p class="card-title mb-3"><i class="fas fa-list"></i> ????????????</p>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                        <thead>
                                            <tr class="text-center">
                                                <th>??????</th>
                                                <th>??????</th>
                                                <th>????????????</th>
                                                <th>??????</th>
                                                <th>??????</th>
                                                <th>????????????</th>
                                                <th>????????????</th>
                                                <th>????????????</th>
                                                <th>????????????</th>
                                                <th>????????????</th>
                                                <th>?????????</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="student">
                                            <tr>
                                                <td>${student.studno}</td>
                                                <td><a href="getstudent?studno=${student.studno}">${student.name}</a></td>
                                                <td><fmt:formatDate value="${student.birthDate}"/></td>
                                                <td>${student.grade} ??????</td>
                                                <td>
                                                <c:choose>
                                                <c:when test="${student.gender eq 'M'}">???</c:when>
                                                <c:when test="${student.gender eq 'F'}">???</c:when>
                                                </c:choose>
                                                </td>
                                                <td>
                                                <c:choose>
                                                <c:when test="${student.status eq false}">??????</c:when>
                                                <c:when test="${student.status eq true}">??????</c:when>
                                                </c:choose>
                                                </td>
                                                <td>${student.deptno}</td>
                                                <td>${student.deptname}</td>
                                                <td>${student.profno}</td>
                                                <td>${student.profname}</td>
                                                <td>${student.email}</td>
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
            
            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show getstu-delete-success" role="alert">
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        <span aria-hidden="true">??</span>
			    </button>
			    <strong>?????? - </strong> ?????? ?????? ????????? ??????????????????.
			</div>
			<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show getstu-delete-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">??</span>
                </button>
                <strong>?????? - </strong> ?????? ?????? ????????? ??????????????????.
            </div>
            
            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show registerstu-success" role="alert">
	    		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	       			 <span aria-hidden="true">??</span>
	    		</button>
	    		<strong>?????? - </strong> ?????? ????????? ?????????????????????.
		  	</div>
		  	<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show registerstu-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">??</span>
                </button>
                <strong>?????? - </strong> ?????? ????????? ?????????????????????.
           </div>
           
           <script>
				var result = "${result}";
				
				if(result == "success") {
					$(".getstu-delete-success").show();
					setTimeout(function() {
					$(".getstu-delete-success").hide();
					}, 3000);
				} else if(result == "fail") {
					$(".getstu-delete-fail").show();
					setTimeout(function() {
					$(".getstu-delete-fail").hide();
					}, 3000);
				};
			</script>
				
			<script>
				var msg = "${msg}";
				
				if(msg == "success") {
					$(".registerstu-success").show();
					setTimeout(function() {
					$(".registerstu-success").hide();
					}, 3000);
				}else if(msg == "fail") {
					$(".registerstu-fail").show();
					setTimeout(function() {
					$(".registerstu-fail").hide();
					}, 3000);
				}
			</script>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />