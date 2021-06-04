<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/assets/images/favicon.png">
    <title>hyeyum-Login</title>
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/css/student-style.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <div class="main-wrapper">
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Login box.scss -->
        <!-- ============================================================== -->
        <div class="auth-wrapper d-flex no-block justify-content-center align-items-center position-relative"
            style="background:url(${pageContext.request.contextPath}/resources/assets/images/big/auth-bg.jpg) no-repeat center center;">
            <div class="auth-box row" style="margin-bottom: 180px;">
                <div class="col-lg-6 col-md-6 bg-white" style="margin-left: 180px;">
                    <div class="p-3">
                        <div class="mt-3 text-center"><img src="${pageContext.request.contextPath}/resources/assets/images/big/logo2.png" height="100" width="200" style=""></div>
                        <form class="mt-2" method="post" action="${pageContext.request.contextPath}/login">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <input class="form-control" id="username" name="username" type="text"
                                            placeholder="학번 / 교번">
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <input class="form-control" id="password" name="password" type="password"
                                            placeholder="비밀번호">
                                    </div>
                                </div>
                                <div class="col-lg-12 text-center">
                                    <button type="submit" class="btn btn-block btn-dark">Login</button>
                                </div>
                                <div class="col-lg-12 text-center mt-2">
                                     <a href="#" class="text-danger" id="findPasswordBtn">비밀번호 찾기</a>
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Find Password Modal-->
		<div class="modal fade" id="findPasswordModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="myModalLabel">비밀번호찾기</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<form method="post" class="modify-password-form" action="${pageContext.request.contextPath}/updateAccount">
						<div class="modal-body">
                       	    <div class="form-group mb-3">
								<fieldset class="form-group col-md-12">
										<div class="form-check form-check-inline">
		                                    <div class="custom-control custom-radio">
		                                        <input type="radio" class="custom-control-input" id="student" name="user" value="student" checked>
		                                        <label class="custom-control-label" for="student">학생</label>
		                                    </div>
	                                 	</div>
									 	<div class="form-check form-check-inline">
		                                    <div class="custom-control custom-radio">
		                                        <input type="radio" class="custom-control-input" id="professor" name="user" value="professor">
		                                        <label class="custom-control-label" for="professor">교직원</label>
		                                    </div>
	                                	</div>
								</fieldset>	
                          	    <div class="form-group mb-3 student-input">
									<input type="text" class="form-control" id="studno" name="userid" placeholder="학번" required>
							    </div>
                          	    <div class="form-group mb-3 professor-input">
									<input type="text" class="form-control" id="profno" name="userid" placeholder="교번" disabled>
							    </div>
                          	    <div class="input-group mb-3 email-input">
									<input type="email" class="form-control" id="email" name="email" placeholder="이메일주소" required>
									<div class="input-group-append">
                                        <button class="btn btn-outline-secondary text-center" type="button" id="sendBtn">
                                        	<span class="send-text">인증</span>
                                        	<div class="spinner-border spinner-border-sm send-loading" role="status">
                                        	</div>
                                        </button>
                                    </div>
							    </div>
                          	    <div class="input-group mb-3 verify-input d-none">
									<input type="text" class="form-control" id="verifyNo" name="verifyNo" placeholder="인증번호">
									<div class="input-group-append">
                                        <button class="btn btn-outline-secondary" type="button" id="verifyBtn">
                                        	<span>확인</span>
                                        </button>
                                    </div>
							    </div>
                          	    <div class="form-group mb-3 password-input d-none">
									<input autocomplete="new-password" type="password" class="form-control" id="password" name="userpw" placeholder="비밀번호" required>
									<input autocomplete="new-password" type="password" class="form-control" id="passwordCk" name="userpwCk" placeholder="비밀번호 확인" required>
							    </div>
						    </div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary btn-sm submit-schedule-btn" type="submit" id="modifyBtn" disabled>변경</button>
							<button class="btn btn-outline-secondary btn-sm" type="button"
								data-dismiss="modal">닫기</button>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						</div>
                  	</form>
				</div>
			</div>
		</div>
        <!-- ============================================================== -->
        <!-- Login box.scss -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- All Required js -->
    <!-- ============================================================== -->
    <script src="${pageContext.request.contextPath}/resources/assets/libs/jquery/dist/jquery.min.js "></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/assets/libs/popper.js/dist/umd/popper.min.js "></script>
    <script src="${pageContext.request.contextPath}/resources/assets/libs/bootstrap/dist/js/bootstrap.min.js "></script>
    <!-- ============================================================== -->
    <!-- This page plugin js -->
    <!-- ============================================================== -->
    <script>
    	var error = "${error}";
    	var modifyMsg = "${modifyMsg}";
    	var verificationNumber = "";
    	var regex = /[^0-9]/g;
    	
    	if(error != "") {
    		alert("아이디와 비밀번호를 확인하세요.");
    	}
    	
    	if(modifyMsg == "success") {
    		alert("비밀번호 변경을 성공했습니다.");
    	} else if(modifyMsg == "fail") {
    		alert("비밀번호 변경을 실패했습니다.");
    	}
    	
        $(".preloader ").fadeOut();
   		$(".professor-input").hide();
        
        $("#findPasswordBtn").click(function() {
        	$("#findPasswordModal").modal("show");
        });
        
      	$("#student").click(function() {
      		$(".student-input input").prop("required", true);
      		$(".student-input input").prop("disabled", false);
      		$(".student-input").show();
      		$(".professor-input input").prop("required", false);
      		$(".professor-input input").prop("disabled", true);
      		$(".professor-input").hide();
      	});
      	
      	$("#professor").click(function() {
      		$(".student-input input").prop("required", false);
      		$(".student-input input").prop("disabled", true);
      		$(".student-input").hide();
      		$(".professor-input input").prop("required", true);
      		$(".professor-input input").prop("disabled", false);
      		$(".professor-input").show();
      	});
      	
      	$("#sendBtn").off().click(function() {
      		getVerificationNumber();
      		setTimeout(function() {
      			console.log(verificationNumber);
      		}, 6000);
      	});
      	
      	$("#verifyBtn").off().click(function() {
      		var value = $("input[name='verifyNo']").val();
      		if(value == "") {
      			alert("인증번호를 입력해주세요.");
      			return;
      		} else if(value != verificationNumber) {
      			alert("인증번호가 일치하지 않습니다.");
      			return;
      		}
      		alert("인증번호가 일치합니다. 새 비밀번호를 입력해주세요.");
      		$(".password-input").removeClass("d-none");
      		$("#modifyBtn").prop("disabled", false);
      	});
      	
      	$(".modify-password-form").on("submit", function() {
      		var userpw = $("input[name='userpw']").val();
      		var userpwCk = $("input[name='userpwCk']").val();
      		
      		if(userpw == "" || userpwCk == "") {
      			alert("변경할 비밀번호를 입력해주세요.");
      			event.preventDefault();
      		}
      		
      		if(userpw != userpwCk) {
      			alert("입력한 비밀번호와 일치하지 않습니다.");
      			event.preventDefault();
      		}
      	});
      	
      	function getVerificationNumber() {
      		var user = "";
      		var userid = "";
      		$("input[name='user']").each(function() {
      			if($(this).prop("checked")) {
      				user = $(this).val();
      			}
      		});
      		$("input[name='userid']").each(function() {
      			if($(this).prop("required")) {
      				if(regex.test($(this).val())) {
      					alert("학번 및 교번은 숫자로만 입력하세요.");
      					return;
      				}
      				userid = $(this).val();
      			}
      		});
			var email = $("input[name='email']").val();
			
			console.log(user);
			console.log(userid);
			console.log(email);
			
			$(".send-loading").show();
			$(".send-text").hide();
			// 인증번호 발송 로직
			setTimeout(function() {
				$.ajax({
					type: "get",
					url: "${pageContext.request.contextPath}/verify/" + user + "/" + userid + "/" + email,
					success: function(data) {
						if(data == "" || data == null) {
							alert("찾을 수 없습니다.");
							$(".send-loading").hide();
							$(".send-text").show();
						} else {
							alert("인증번호를 발송했습니다.");
							verificationNumber = data;
							$(".send-loading").hide();
							$(".send-text").show();
							$(".verify-input").removeClass("d-none");
						}
					}
				});
			}, 100);
		}
    </script>
</body>

</html>