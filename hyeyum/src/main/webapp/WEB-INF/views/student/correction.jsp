<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper correction-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">성적 이의신청</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html">성적</a>
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
                <!-- *************************************************************** -->
                <!-- Start First Cards -->
                <!-- *************************************************************** -->
                <div class="row">
                     <div class="col-12">
                        <div class="card">
                            <div class="card-body">
	                            <div class="table-responsive col-md-12">
		                            <div class="row">
			                         	<p class="card-title mb-3"><i class="fas fa-list"></i> 성적목록</p>
		                            </div>
	                                <div class="row table-container">
	                                 <table id="zero_config" class="table table-striped table-bordered no-wrap course-list">
	                                     <thead>
	                                         <tr class="text-center">
	                                             <th>학기</th>
	                                             <th>강의명</th>
	                                             <th>학과명</th>
	                                             <th>교수명</th>
	                                             <th>이수구분</th>
	                                             <th>학점</th>
	                                             <th>등급</th>
	                                             <th>이의신청</th>
	                                         </tr>
	                                     </thead>
	                                     <tbody>
                                        	 <c:forEach items="${list}" var="course">
	                                         <tr>
	                                             <fmt:parseNumber value="${course.semester / 2 + 1}" integerOnly="true" var ="grade"/>
	                                           	 <td class="text-center">${grade}</td>
	                                             <td class="text-center">${course.name}</td>
	                                             <td class="text-center">${course.dname}</td>
	                                             <td class="text-center">${course.pname}</td>
	                                             <c:if test = "${empty course.category}">
	                                             <td class="text-center">일반</td>
	                                             </c:if>
	                                             <c:if test = "${not empty course.category}">
	                                             <td class="text-center">${course.category}</td>
	                                             </c:if>
	                                             <td class="text-center">${course.credit}</td>
	                                             <td class="text-center">${course.result}</td>
	                                             <td class="text-center"><button class="btn btn-info request-btn" data-coursno="${course.coursno}" data-pname = "${course.pname}" data-profno="${course.profno}"  data-name = "${course.name}">신청</button></td>
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
                <!-- *************************************************************** -->
                <!-- End First Cards -->
                <!-- *************************************************************** -->
                <div class="card-group">
                    <div class="card border-right">
                        <div class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/student/correction/request">
								 <div class="form-row">
									 <div class="form-group col-md-3">
									    <label for="studno">과목</label>
									    <input type="text" class="form-control" name="cname" id="cname" readonly>
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="name">담당교수</label>
									    <input type="text" class="form-control" name="pname" id="pname" readonly>
								 	 </div>
							 	 </div>
							 	 <div class="form-row">
									 <div class="form-group col-md-12">
									    <label for="name">신청사유</label>
									    <input type="text" class="form-control" name="reason" id="reason">
								 	 </div>
						 	 	</div>
						 	 	<div class="form-row">
									 <div class="form-group ml-auto mr-1">
									 	 <button type="submit" class="btn btn-info">신청</button>
									 	 <input type="hidden" name="coursno" id="coursno">
									 	 <input type="hidden" name="profno" id="profno">
									 	 <input type="hidden" name="studno" id="studno" value="${student.studno}">
									 	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						 	 		 </div>
						 	 	</div>
							</form>
						</div>
					</div>
                </div>
                <!-- *************************************************************** -->
                <!-- Start Top Leader Table -->
                <!-- *************************************************************** -->
                <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show request-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 신청을 완료했습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show request-fail" role="alert">
	                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	                    <span aria-hidden="true">×</span>
	                </button>
	                <strong>실패 - </strong> 신청을 실패했습니다
	            </div>
                <!-- *************************************************************** -->
                <!-- End Top Leader Table -->
                <!-- *************************************************************** -->
            </div>
         </div>
         <script>
         var msg = "${msg}";
         
         if(msg == "success") {
        	 $(".request-success").show();
			 setTimeout(function() {
			 	$(".request-success").hide();
			 }, 3000);
         } else if(msg == "fail") {
        	 $(".request-fail").show();
			 setTimeout(function() {
			 	$(".request-fail").hide();
			 }, 3000);
         }
         $(".request-btn").click(function() {
         var coursno = $(this).data("coursno")
         var name = $(this).data("name")
         var pname = $(this).data("pname")
         var profno = $(this).data("profno")
         
         $("#cname").val(name);
         $("#pname").val(pname);
         $("#coursno").val(coursno);
         $("#profno").val(profno);
         });
         </script>
         <!-- ============================================================== -->
         <!-- End Container fluid  -->
         <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />