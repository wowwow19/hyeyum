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
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">교육과정 조회</h4>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html" class="text-muted">교육과정</a></li>
                                    <li class="breadcrumb-item text-muted active" aria-current="page"></li>
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
                <div class="card-group">
                    <div class="card border-right">
                        <div class="card-body">
                        	<p class="card-title mb-3"><i class="fas fa-align-left"></i> 교육과정등록 </p>
                            <form method="post" action="">
								 <div class="form-row">
									 <div class="form-group col-md-3">
									    <label for="coursno">과목코드</label>
									    <input type="text" class="form-control" name="coursno" id="coursno"   placeholder="과목코드 입력란">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="deptno">학과코드</label>
									    <input type="text" class="form-control" name="deptno" id="deptno" placeholder="학과코드 입력란">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="category">이수구분</label>
									    <input type="text" class="form-control" name="category" id="category" placeholder="이수구분 입력란">
								 	 </div>
								 	<div class="form-group col-md-3">
								 		<label for="category" class="invisible">교육과정등록</label>
								    	<button data-oper="registercurriculum" class="form-control btn btn-warning btn-block" formaction="registercurriculum">교육과정등록</button>								 	
								 	</div>
								 </div>
								 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							</form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                        	<div class="card-body">
                        		<form class="course-search">
	                		        <p class="card-title mb-3"><i class="fas fa-chevron-right"></i> 검색조건 </p>
	                        		<div class="row mb-1">
										<div class="input-group col-md-3">
	                                        <div class="input-group-prepend">
	                                            <label class="input-group-text" for="inputGroupSelect01">년도</label>
	                                        </div>
	                                        <select class="custom-select" id="inputGroupSelect01" name="year">
	                                            <option selected value="">선택</option>
	                                            <c:forEach begin="2013" end="2021" step="1" var="i">
	                                            <option value="${i}">${i}</option>
	                                            </c:forEach>
	                                        </select>
                                    	</div>	                        			
										<div class="input-group col-md-3">
	                                        <div class="input-group-prepend">
	                                            <label class="input-group-text" for="inputGroupSelect01">학기</label>
	                                        </div>
	                                        <select class="custom-select" id="inputGroupSelect01" name="semester">
	                                            <option selected value="">선택</option>
	                                            <option value="1">1학기</option>
	                                            <option value="0">2학기</option>
	                                        </select>
                                    	</div>	                        			
	                        		</div>
	                        		<div class="row">
	                        			<div class="input-group col-md-3">
	                                        <div class="input-group-prepend">
	                                            <label class="input-group-text" for="inputGroupSelect01">구분</label>
	                                        </div>
	                                        <select class="custom-select" id="searchType">
	                                            <option selected value="coursno">과목코드</option>
	                                            <option value="cname">과목명</option>
	                                            <option value="pname">교수명</option>
	                                            <option value="">학과별</option>
	                                        </select>
                                    	</div>
	                        			<div class="input-group col-md-7" id="searchByDept">
	                                        <select class="custom-select" id="college">
	                                            <option selected value="">대학</option>
	                                            <option value="100">공과대학</option>
	                                            <option value="200">인문대학</option>
	                                            <option value="300">경상대학</option>
	                                        </select>
	                                        <select class="custom-select" id="department">
	                                            <option selected value="">학부</option>
	                                            <option value="110">컴퓨터공학부</option>
	                                            <option value="120">전기전자제어공학부</option>
	                                            <option value="210">외국어학부</option>
	                                            <option value="310">경영학부</option>
	                                            <option value="320">경제학부</option>
	                                        </select>
	                                        <select class="custom-select" id="subdivision" name="deptno">
	                                            <option selected value="">학과</option>
	                                            <option value="111">컴퓨터공학과</option>
	                                            <option value="112">소프트웨어공학과</option>
	                                            <option value="113">정보통신공학과</option>
	                                            <option value="121">전기전자공학과</option>
	                                            <option value="122">제어계측공학과</option>
	                                            <option value="123">나노정보공학과</option>
	                                            <option value="211">영어영문학과</option>
	                                            <option value="212">중어중문학과</option>
	                                            <option value="213">독어독문학과</option>
	                                            <option value="311">경영학과</option>
	                                            <option value="312">회계학과</option>
	                                            <option value="313">산업경영학과</option>
	                                            <option value="321">회계학과</option>
	                                            <option value="322">국제통상학과</option>
	                                            <option value="323">무역학과</option>
	                                        </select>
                                    	</div>
	                        			<div class="input-group col-md-5" id="searchByKeyword">
	                        				<input type="text" class="form-control" placeholder="과목코드" name="coursno">
                                    	</div>
	                        			<div class="col-md-2">
	                        				<button class="btn btn-primary">검색</button>
	                        			</div>
	                        		</div>
	                        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        		</form>
                        	</div>
                        </div>
                    </div>
                </div>
                <!-- basic table -->
                <div class="row">
                    <div class="col-12">
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                                <div class="table-responsive col-md-12">
	                            	<p class="card-title mb-4"><i class="fas fa-list"></i> 교육과정목록</p>
	                            	
                                    <div class="row table-container">
	                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
	                                        <thead>
	                                            <tr class="text-center">
	                                                <th>과목코드</th>
	                                                <th>이수구분</th>
	                                                <th>과목명</th>
	                                                <th>개설학과</th>
	                                                <th>학점</th>
	                                                <th>학기</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach items="${list}" var="curriculum">
		                                            <tr>
		                                                <td class="text-center">${curriculum.coursno}</td>
		                                                <td>${curriculum.category}</td>
		                                                <td><a href="getcurriculum?coursno=${curriculum.coursno}">${curriculum.name}</a></td>
		                                                <td class="text-center">${curriculum.dname}</td>
		                                                <td class="text-center">${curriculum.credit}</td>
		                                                <td class="text-center">${curriculum.semester}</td>
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
            
            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show curr-success" role="alert">
	    		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	        		<span aria-hidden="true">×</span>
	    		</button>
	    		<strong>성공 - </strong> 교육과정 등록을 완료하였습니다.
		  	</div>
		 	 <div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show curr-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>실패 - </strong> 교육과정 등록에 실패하였습니다.
           </div>
           
           <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show curr-delete-success" role="alert">
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        <span aria-hidden="true">×</span>
			    </button>
			    <strong>성공 - </strong> 교육과정 삭제을 완료했습니다.
			</div>
			<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show curr-delete-fail" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>실패 - </strong> 교육과정 삭제을 실패했습니다.
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
		</div>
		
		<script>
			var msg = "${msg}";
				
			if(msg == "success") {
				$(".curr-success").show();
				setTimeout(function() {
				$(".curr-success").hide();
				}, 3000);
			}else if(msg == "fail") {
				$(".curr-fail").show();
				setTimeout(function() {
				$(".curr-fail").hide();
				}, 3000);
			}
		</script>
		
		<script>
				var result = "${result}";
				
				if(result == "success") {
					$(".curr-delete-success").show();
					setTimeout(function() {
					$(".curr-delete-success").hide();
					}, 3000);
				} else if(result == "fail") {
					$(".curr-delete-fail").show();
					setTimeout(function() {
					$(".curr-delete-fail").hide();
					}, 3000);
				};
			</script>
			
		<script>
		   	init();
		   	           	
		   	// 검색 유형 선택시의 입력폼 변경 로직
		   	$("#searchByDept").hide();
		   	$("#searchType").change(function() {
		   		$("#searchByKeyword").children().val("");
		   		if($(this).children().last().prop("selected")) {
		   			$("#searchByDept").show();
		   			$("#searchByDept select:last").prop("required", true);
		   			$("#searchByKeyword").hide();
		   		} else {
		   			$("#searchByDept").hide();
		   			$("#searchByDept select:last").prop("required", false);
		   			$("#searchByKeyword").show().children().off("keyup").attr("placeholder", $("#searchType option:selected").text());
		   			$("#searchByKeyword").show().children().attr("name", $("#searchType option:selected").val());
		   		}
		   		init();
		   	});
		   	
		   	// 학부/학과 카테고리 선택시의 선택지 변경 로직
		   	$("#department option").not(":first").hide();
		   	$("#subdivision option").not(":first").hide();
		   	
			$("#college").change(function() {
				var collegeNo = parseInt($(this).val() / 100);
				console.log(collegeNo);
				
				$("#department option:first").prop("selected", true);
				$("#subdivision option:first").prop("selected", true);
				
					$("#department option").each(function() {
						var deptNo = parseInt($(this).val() / 100);
						console.log(deptNo);
						
						if(deptNo == collegeNo) {
							$(this).show();
						} else if (deptNo == 0){
							$(this).show();
						} else {
							$(this).hide();
						}
					});
					
					init();
				});
			
			$("#department").change(function() {
				var deptNo = parseInt($(this).val() / 10);
				console.log(deptNo);
				
				$("#subdivision option:first").prop("selected", true);
				
					$("#subdivision option").each(function() {
						var subNo = parseInt($(this).val() / 10);
						console.log(subNo);
						
						if(subNo == deptNo) {
							$(this).show();
						} else if (subNo == 0){
							$(this).show();
						} else {
							$(this).hide();
						}
					});
					
					init();
				});
			
			   	function init() {
			   		// 과목코드로 검색시 숫자만 입력가능하도록 이벤트 부여
			       	$("input[name='coursno']").on("keyup", function() {
			   			$(this)[0].value = $(this)[0].value.replace(/[^\d]+/g, '');
			       	});
			   	}
		   	</script>
<jsp:include page="../includes/footer.jsp" />