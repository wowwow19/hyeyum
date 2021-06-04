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
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">학생등록</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="#">Register Student</a>
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
									    <label for="studno">학번</label>
									    <input type="text" class="form-control" name="studno" id="studno" placeholder="학번 입력란" required>
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="name">이름</label>
									    <input type="text" class="form-control" name="name" id="name" placeholder="이름 입력란" required>
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="birthDate">생년월일</label>
									    <input type="text" class="form-control" name="birthDate" id="birthDate" required pattern="[0-9]{6}" placeholder="생년월일 입력란(yymmdd)" required>								 	
									 </div> 
									 <div class="form-group col-md-3">
									    <label for="tel">전화번호</label>
									    <input type="text" class="form-control" name="tel" id="tel" placeholder="전화번호 입력란" required>								 	
									 </div>
								 </div>
								 <label for="address" >주소</label> 
                                 <div class="row">
							    	<div class="col-md-10">
							    		<div class="form-group">
										    <input type="text" class="form-control" name="address" id="address" placeholder="주소" required>								 	
							    		</div>
							    	</div>
							    	<div class="col-md-2">
							    		<div class="form-group">
										    <input type="button" class="btn btn-outline-info" onclick="daumPostcode()" value="주소찾기">								 	
							    		</div>
							    	</div>
							    </div>
							    <div class="form-row">
									 <div class="form-group col-md-3">
									    <label for="deptno">학과코드</label>
									    <input type="text" class="form-control" name="deptno" id="deptno" placeholder="학과코드" required>
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="profno">교수코드</label>
									    <input type="text" class="form-control" name="profno" id="profno" placeholder="교수코드" required>								 	
									 </div>
									 <div class="form-group col-md-3">
									    <label for="grade">학년</label>
									    <input type="text" class="form-control" name="grade" id="grade" placeholder="학년" required>
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="status">학적상태</label>
									    <input type="text" class="form-control" name="status" id="status" placeholder="학적 상태" required>								 	
									 </div>
								 </div>
								 <div class="row">
								 	 <div class="col-md-4">
									 	<label for="email">이메일</label>
									    <input type="email" class="form-control" name="email" id="email" placeholder="이메일" required>
									 </div>
									 <fieldset class="form-group col-md-4">
									 	 <legend class="col-form-label col-md-12 px-0">병역구분</legend>
										 <div class="form-check form-check-inline">
		                                    <div class="custom-control custom-radio">
		                                        <input type="radio" class="custom-control-input" id="feature1" name="feature" value="0" required>
		                                        <label class="custom-control-label" for="feature1">병역미필</label>
		                                    </div>
		                                </div>
										 <div class="form-check form-check-inline">
		                                    <div class="custom-control custom-radio">
		                                        <input type="radio" class="custom-control-input" id="feature2" name="feature" value="1" required>
		                                        <label class="custom-control-label" for="feature2">병역필</label>
		                                    </div>
		                                </div> 
									 </fieldset>
									 <fieldset class="form-group col-md-4">
									 	 <legend class="col-form-label col-md-2 px-0">성별</legend>
										 <div class="form-check form-check-inline">
		                                    <div class="custom-control custom-radio">
		                                        <input type="radio" class="custom-control-input" id="gender1" name="gender" value="M" required>
		                                        <label class="custom-control-label" for="gender1">남</label>
		                                    </div>
		                                 </div>
										 <div class="form-check form-check-inline">
		                                    <div class="custom-control custom-radio">
		                                        <input type="radio" class="custom-control-input" id="gender2" name="gender" value="F" required>
		                                        <label class="custom-control-label" for="gender2">여</label>
		                                    </div>
		                                </div>
									 </fieldset>
								 </div>
								 <div class="row">
								 	<div class="col-md-12">
								    	<button type="submit" class="btn btn-info btn-block">등록하기</button>								 	
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
            
            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show registerstu-update-success" role="alert">
	    	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        <span aria-hidden="true">×</span>
	    	</button>
	    	<strong>성공 - </strong> 학생 등록을 완료하였습니다.
		  </div>
		  <div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show registerstu-update-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>실패 - </strong> 학생 등록에 실패하였습니다.
           </div>
           
  		</div>
        <script>
	    function daumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    //document.getElementById("extraAddress").value = extraAddr;
	                
	                } else {
	                    document.getElementById("extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                //document.getElementById('postcode').value = data.zonecode;
	                //document.getElementById("address").value = addr;
	                document.getElementById("address").value = data.zonecode+ " " + addr + extraAddr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("address").focus();
	            }
	        }).open();
	    }
		</script>
		<script>
			var msg = "${msg}";
			
			if(msg == "success") {
				$(".registerstu-update-success").show();
				setTimeout(function() {
				$(".registerstu-update-success").hide();
				}, 3000);
			}else if(msg == "fail") {
				$(".registerstu-update-fail").show();
				setTimeout(function() {
				$(".registerstu-update-fail").hide();
				}, 3000);
			}
			</script>
			
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />