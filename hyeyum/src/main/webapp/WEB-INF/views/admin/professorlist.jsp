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
                                    <li class="breadcrumb-item"><a href="index.html">professor List</a>
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
                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 학생목록</p>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                        <thead>
                                            <tr class="text-center">
                                                <th>교번</th>
                                                <th>이름</th>
                                                <th>생년월일</th>
                                                <th>성별</th>
                                                <th>입사일</th>
                                                <th>직급</th>
                                                <th>학과번호</th>
                                                <th>학과이름</th>
                                                <th>이메일</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="professor">
                                            <tr>
                                                <td>${professor.profno}</td>
                                                <td><a href="getprofessor?profno=${professor.profno}">${professor.name}</a></td>
                                                <td><fmt:formatDate value="${professor.birthdate}"/></td>
                                                <td>
                                                <c:choose>
                                                <c:when test="${professor.gender eq 'M'}">남</c:when>
                                                <c:when test="${professor.gender eq 'F'}">여</c:when>
                                                </c:choose>
                                                </td>
                                                
                                                <td><fmt:formatDate value="${professor.hiredate}"/></td>
                                                <td>${professor.position}</td>
                                                <td>${professor.deptno}</td>
                                                <td>${professor.dname}</td>
                                                <td>${professor.email}</td>
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
            
            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show getpro-delete-success" role="alert">
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        <span aria-hidden="true">×</span>
			    </button>
			    <strong>성공 - </strong> 교직원 정보 삭제을 완료했습니다.
			</div>
			<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show getpro-delete-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>실패 - </strong> 교직원 정보 삭제을 실패했습니다.
            </div>
            
            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show registerpro-success" role="alert">
	    		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        		<span aria-hidden="true">×</span>
	    		</button>
	    		<strong>성공 - </strong> 교직원 등록을 완료하였습니다.
		  	</div>
		 	 <div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show registerpro-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>실패 - </strong> 교직원 등록에 실패하였습니다.
           </div>
            
            <script>
				var result = "${result}";
				
				if(result == "success") {
					$(".getpro-delete-success").show();
					setTimeout(function() {
					$(".getpro-delete-success").hide();
					}, 3000);
				} else if(result == "fail") {
					$(".getpro-delete-fail").show();
					setTimeout(function() {
					$(".getpro-delete-fail").hide();
					}, 3000);
				};
			</script>
				
			<script>
				var msg = "${msg}";
				
				if(msg == "success") {
					$(".registerpro-success").show();
					setTimeout(function() {
					$(".registerpro-success").hide();
					}, 3000);
				}else if(msg == "fail") {
					$(".registerpro-fail").show();
					setTimeout(function() {
					$(".registerpro-fail").hide();
					}, 3000);
				}
			</script>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />