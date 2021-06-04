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
                                    <li class="breadcrumb-item"><a href="index.html">correction</a>
                                    </li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
           <div class="container-fluid">
                <!-- *************************************************************** -->
                <!-- Start First Cards -->
                <!-- *************************************************************** -->
                <div class="card-group">
                    <div class="card border-right">
                        <div class="card-body">
                            <form method="post" action="">
                            	<input type="hidden" name="corrStatus" id="corrStatus" value="${correction.corrStatus}">
                            	<input type="hidden" name="corrno" id="corrno" value="${correction.corrno}">
								 <div class="form-row">
								 	<div class="form-group col-md-3">
									    <label for="studno">학번</label>
									    <input type="text" class="form-control" name="studno" id="studno" readonly value="${correction.studno}" placeholder="학번 입력란">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="name">이름</label>
									    <input type="text" class="form-control" name="name" id="name" readonly value="${correction.studname}" placeholder="이름 입력란">
								 	 </div>
								 	 <div class="form-group col-md-3">
									    <label for="name">과목명</label>
									    <input type="text" class="form-control" name="name" id="name" readonly value="${correction.coursname}" placeholder="과목명 입력란">
								 	 </div>
								 	 <div class="form-group col-md-3">
									    <label for="name">성적</label>
									    <input type="hidden" name="coursno" id="coursno" value="${sugang.coursno}">
									    <input type="hidden" name="studno" id="studno" value="${sugang.studno}">
									    <input type="text" class="form-control" name="result" id="result" value="${sugang.result}" placeholder="성적 입력란">
								 	 </div>
								 	 <div class="form-group col-md-12">
									    <label for="name">이의신청사유</label>
									    <textarea rows="5"  class="form-control" id="reason" name="reason" readonly  placeholder="이의신청사유입력란">${correction.reason}</textarea>
								 	 </div>
								 </div>
								 <div class="row">
								 	<div class="col-md-6">
									    <button class="btn btn-info btn-block" formaction="correction">승인</button>							 	
								 	</div>
								 	<div class="col-md-6">
								 		<button class="btn btn-secondary btn-block" formaction="deny">거부</button>
								 	</div>
								 </div>
								 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							</form>
                        </div>
                    </div>
                </div>
                <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show correction-update-success" role="alert">
			   	 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        <span aria-hidden="true">×</span>
			  	  </button>
			    	<strong>성공 - </strong> 성적변경을 완료하였습니다.
				</div>
            </div>
            <script>
            var msg = "${msg}";
			
			if(msg == "success") {
				$(".correction-update-success").show();
				setTimeout(function() {
				$(".correction-update-success").hide();
				}, 3000);
			}
			</script>
            
<jsp:include page="../includes/footer.jsp" />