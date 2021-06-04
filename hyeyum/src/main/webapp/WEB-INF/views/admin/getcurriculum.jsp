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
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">강의조회</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="#">Get managementcourse</a>
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
                <div class="card-group">
                    <div class="card border-right">
                        <div class="card-body">
                            <form method="post" action="">
								 <div class="form-row">
									 <div class="form-group col-md-3">
									    <label for="coursno">과목코드</label>
									    <input type="text" class="form-control" name="coursno" id="coursno" readonly value="${curriculum.coursno}" placeholder="과목코드 입력란">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="category">이수구분</label>
									    <input type="text" class="form-control" name="category" id="category" value="${curriculum.category}">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="name">과목명</label>
									    <input type="text" class="form-control" name="name" id="name" readonly value="${curriculum.name}">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="dname">개설학과</label>
									    <input type="text" class="form-control" name="dname" id="dname" readonly value="${curriculum.dname}" placeholder="담당학과 입력란">						 	
									 </div> 
								 </div>
							    <div class="form-row">
									 <div class="form-group col-md-2">
									    <label for="credit">학점</label>
									    <input type="text" class="form-control" name="credit" id="credit" readonly value="${curriculum.credit}" placeholder="학점">
								 	 </div>
									 <div class="form-group col-md-2">
									    <label for="semester">학기</label>
									    <input type="text" class="form-control" name="semester" id="semester" readonly value="${curriculum.semester}" placeholder="수업시간">
								 	 </div>
								 </div>
								 <div class="row">
								 	<div class="col-md-6">
								    	<button data-oper="deletecurriculum" class="btn btn-warning btn-block" formaction="deletecurriculum">교육과정삭제</button>								 	
								 	</div>
								 	<div class="col-md-6">
								    	<button type="submit" id="updatecurriculum" class="btn btn-info btn-block" formaction="updatecurriculum">교육과정수정</button>								 	
								 	</div>
								 </div>
								 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							</form>
                        </div>
                    </div>
                </div>
                <!-- *************************************************************** -->
                <!-- End First Cards -->
                <!-- *************************************************************** -->
            </div>
            
            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show curr-update-success" role="alert">
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        <span aria-hidden="true">×</span>
			    </button>
			    <strong>성공 - </strong> 교육과정 수정을 완료했습니다
			</div>
			<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show curr-update-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>실패 - </strong> 교육과정 수정을 실패했습니다
            </div>
            
            <script>
				var msg = "${msg}";
				
				if(msg == "success") {
					$(".curr-update-success").show();
					setTimeout(function() {
					$(".curr-update-success").hide();
					}, 3000);
				} else if(msg == "fail") {
					$(".curr-update-fail").show();
					setTimeout(function() {
					$(".curr-update-fail").hide();
					}, 3000);
				};
			</script>

            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />