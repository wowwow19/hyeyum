<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
		<!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper sugang-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">수강신청</h4>
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
                        <div class="card">
                            <div class="card-body">
                            	<div class="row mb-3">
	                        		<form class="course-search col-md-12">
	                            		<p class="card-title mb-3"><i class="fas fa-chevron-right"></i> 검색조건 </p>
		                        		<div class="row mb-1">
											<div class="input-group col-md-3">
		                                        <div class="input-group-prepend">
		                                            <label class="input-group-text" for="inputGroupSelect01">년도</label>
		                                        </div>
		                                        <select class="custom-select" name="year">
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
		                                        <select class="custom-select" name="semester">
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
		                        				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		                        			</div>
		                        		</div>
	                        		</form>
                        		</div>
                        		<hr>
                        		<div class="course-list-wrapper">
	                                <div class="table-responsive col-md-12">
	                                	<div class="row">
		                            		<p class="card-title mb-3"><i class="fas fa-list"></i> 개설강좌목록</p>
	                                	</div>
	                                    <div class="row table-container">
		                                    <table id="zero_config" class="table table-striped table-bordered no-wrap course-list">
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
		                                                <th>장바구니</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                        	<c:forEach items="${list}" var="course">
		                                            <tr data-coursno="${course.coursno}" data-name="${course.name}" data-pname="${course.pname}"
		                                            	data-dname="${course.dname}" data-credit="${course.credit}" data-locno="${course.locno}"
		                                            	data-day="${course.day}" data-startTime="${course.startTime}" data-endTime="${course.endTime}"
		                                            	data-maxnum="${course.maxnum}" data-sugangNum="${course.sugangNum}">
		                                                <td class="text-center" data-coursno="${course.coursno}">${course.coursno}</td>
		                                                <td class="course-name" data-name="${course.name}">${course.name}</td>
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
		                                                <td class="text-center maxnum">${course.maxnum}</td>
		                                                <td class="text-center sugangNum">${course.sugangNum}</td>
		                                                <td class="text-center">
		                                                	<button type="button" class="btn btn-success btn-sm sugang-add-btn"><i class="fas fa-plus"></i> 담기</button>
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
                </div>
                <!-- 장바구니 -->
                <div class="row">
                	<div class="col-xl-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row mb-2">
                                	<div class="col-md-3">
		                                <p class="card-title mb-3"><i class="fas fa-pencil-alt"></i> 수강신청</p>
                                	</div>
                               		<div class="ml-auto mr-3">
                                		<form method="post" action="${pageContext.request.contextPath}/student/sugang/complete" class="sugang-complete-form">	                                	
   	                         				<button type="button" class="btn btn-outline btn-sm" data-toggle="tooltip" data-placement="top" title="" data-original-title="장바구니 목록을 확정합니다"><i class="fas fa-question-circle"></i></button>
   	                         				<button type="submit" class="btn btn-primary btn-sm"><i class="fas fa-check"></i> 완료</button>
   	                         				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
   	                         			</form>
                               		</div>
                               	</div>
                               	<!-- 탭 메뉴 -->
                                <ul class="nav nav-tabs mb-3">
                                    <li class="nav-item">
                                        <a href="#home" data-toggle="tab" aria-expanded="false" class="nav-link active">
                                            <i class="mdi mdi-home-variant d-lg-none d-block mr-1"></i>
                                            <span class="d-none d-lg-block">장바구니</span>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#profile" data-toggle="tab" aria-expanded="true" class="nav-link">
                                            <i class="mdi mdi-account-circle d-lg-none d-block mr-1"></i>
                                            <span class="d-none d-lg-block">시간표</span>
                                        </a>
                                    </li>
                                </ul>

                                <div class="tab-content">
                                	<!-- 수강신청탭 -->
                                    <div class="tab-pane active" id="home">
                                        <div class="table-responsive col-md-12">
		                                	<div class="row table-container">
			                                    <table id="zero_config" class="table table-striped table-bordered no-wrap sugang-list">
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
			                                                <th>장바구니</th>
			                                            </tr>
			                                        </thead>
			                                        <tbody class="sugang-list-body">
			                                        	<c:forEach items="${sugangList}" var="course">
			                                            <tr data-coursno="${course.coursno}" data-name="${course.name}" data-pname="${course.pname}"
			                                            	data-dname="${course.dname}" data-credit="${course.credit}" data-locno="${course.locno}"
			                                            	data-day="${course.day}" data-startTime="${course.startTime}" data-endTime="${course.endTime}"
			                                            	data-maxnum="${course.maxnum}" data-sugangNum="${course.sugangNum}">
			                                                <td class="text-center">${course.coursno}</td>
			                                                <td class="course-name">${course.name}</td>
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
			                                                <td class="text-center maxnum">${course.maxnum}</td>
			                                                <td class="text-center sugangNum">${course.sugangNum}</td>
			                                                <td class="text-center">
			                                                	<button type="submit" class="btn btn-danger btn-sm sugang-delete-btn">
			                                                		<i class="ti-trash"></i> 제외
			                                                	</button>
			                                                </td>
			                                            </tr>
			                                        	</c:forEach>
			                                        </tbody>
			                                    </table>
	                                    	</div>
	                                	</div>
                                    </div>
                                    <!-- 시간표탭 -->
                                    <div class="tab-pane show" id="profile">
										<div class="table-responsive col-md-12">
		                                	<div class="row table-container" id="timeTable">
			                                    <table id="zero_config" class="table table-striped table-bordered">
			                                        <thead>
			                                            <tr class="text-center">
			                                                <th> </th>
			                                                <th>월</th>
			                                                <th>화</th>
			                                                <th>수</th>
			                                                <th>목</th>
			                                                <th>금</th>
			                                            </tr>
			                                        </thead>
			                                        <tbody>
			                                        	<c:forEach begin="0" end="7" var="j">
			                                        	<tr>
			                                        		<td class="text-center">${j+1}</td>
			                                        		<c:forEach begin="0" end="4" var="i">
			                                        		<c:if test="${timeTable[i][j].name ne null}">
		                                        			<td>${timeTable[i][j].name}<br>(${timeTable[i][0].locno}, ${timeTable[i][j].pname})</td>
			                                        		</c:if>
			                                        		<c:if test="${timeTable[i][j].name eq null}">
		                                        			<td></td>
			                                        		</c:if>
			                                        		</c:forEach>
			                                        	</tr>
			                                        	</c:forEach>
			                                        </tbody>
			                                    </table>
	                                    	</div>
	                                	</div>
                                    </div>
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
				<div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show add-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 강의를 장바구니에 담았습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show add-fail" role="alert">
	                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	                    <span aria-hidden="true">×</span>
	                </button>
	                <strong>실패 - </strong> 신청내역과 시간표가 겹치는지 확인하세요
	            </div>
				<div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show delete-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 장바구니에서 강의를 제외했습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show delete-fail" role="alert">
	                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	                    <span aria-hidden="true">×</span>
	                </button>
	                <strong>실패 - </strong> 장바구니에서 강의를 제외하는 데 실패했습니다
	            </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
		</div>
		<script>
			var studno = '<sec:authentication property="principal.username" htmlEscape="false"/>';
			var sugangListLength = "${fn:length(sugangList)}";
			var csrf = "${_csrf.headerName}";
			var csrfToken = "${_csrf.token}";
			var status = "${student.status}";
			
			// 휴학 중인 상태에서는 수강신청을 막음 
			if(status == "false") {
				alert("휴학 중에는 수강신청을 할 수 없습니다.");
				$(location).attr('href', '${pageContext.request.contextPath}/student/index');
			}
			
			$(document).ajaxSend(function(e, xhr) {
				xhr.setRequestHeader(csrf, csrfToken);
			});
			
		   	init();
		   	
		   	function preventAdd(tr) {
		   		var maxnum = tr.find(".maxnum").text();
		   		var sugangNum = tr.find(".sugangNum").text();
		   		
		   		if(maxnum === sugangNum) {
		   			tr.find(".sugang-add-btn").prop("disabled", true);
		   		}
		   	}
		   	           	
			function showSugangList(result) {
				var str = "";
				
				str += '<tr data-coursno="' + result.coursno + '" data-name="' + result.name + '" data-pname="' + result.pname +'"';
                str += '	data-dname="' + result.dname + '" data-credit="' + result.credit + '" data-locno="' + result.locno + '"';
                str += '	data-day="' + result.day + '" data-startTime="' + result.startTime + '" data-endTime="' + result.endTime + '"';
                str += '	data-maxnum="' + result.maxnum +'" data-sugangNum="' + result.sugangNum + '">';
                str += '	<td class="text-center">' + result.coursno + '</td>';
                str += '	<td class="course-name" data-coursno="' + result.coursno + '">' + result.name + '</td>';
                str += '	<td>' + result.dname + '</td>';
                str += '	<td class="text-center">' + result.pname + '</td>';
                str += '	<td class="text-center">' + result.credit + '</td>';
                str += '	<td class="text-center">' + result.locno + '</td>';
                str += '	<td>';
                if(result.day == 1) {
                	str += '월 ';
                } else if(result.day == 2) {
                	str += '화 ';
                } else if(result.day == 3) {
                	str += '수 ';
                } else if(result.day == 4) {
                	str += '목 ';
                } else {
                	str += '금 ';
                }
                for(var i = result.startTime; i <= result.endTime; i++) {
                	str += i + ' ';
                }
                str += '	</td>';
                str += '	<td class="text-center">' + result.maxnum + '</td>';
                str += '	<td class="text-center">' + (result.sugangNum+1) + '</td>';
                str += '	<td class="text-center"><button type="button" class="btn btn-danger btn-sm sugang-delete-btn" data-coursno="' + result.coursno + '"><i class="ti-trash"></i> 제외</button></td>';
            	str += '</tr>';

				$(".sugang-list-body").append(str);
			}
			
			function addTimeTable(sugang) {
				var day = sugang.day;
				var startTime = sugang.startTime;
				var endTime = sugang.endTime;
				var str = "";
				var text = "";
				
				for(var i = startTime; i < endTime+1; i++) {
					str = "#timeTable tbody tr:nth-child(" + i + ")";
					td = $(str).children().eq(day);
					text = sugang.name + "<br>(" + sugang.locno + ", " + sugang.pname + ")";
					td.html(text);
				}
			}
			
			function removeTimeTable(sugang) {
				var day = sugang.day;
				var startTime = sugang.startTime;
				var endTime = sugang.endTime;
				var str = "";
				console.log(sugang);
				
				for(var i = startTime; i < endTime+1; i++) {
					str = "#timeTable tbody tr:nth-child(" + i + ")";
					td = $(str).children().eq(day);
					td.html("");
				}
			}
			
			function increaseSugangNum(tr) {
				var text = tr.find(".sugangNum").text() * 1 + 1;
				console.log(text);
				tr.find(".sugangNum").text(text);
				tr.data("sugangnum", text);
			}
			
			function decreaseSugangNum(tr) {
				var text = tr.find(".sugangNum").text() * 1 - 1;
				console.log(text);
				tr.find(".sugangNum").text(text);
				tr.data("sugangnum", text);
			}
						
		   	function init() {
		   		// 과목코드로 검색시 숫자만 입력가능하도록 이벤트 부여
		       	$("input[name='coursno']").on("keyup", function() {
		   			$(this)[0].value = $(this)[0].value.replace(/[^\d]+/g, '');
		       	});
		   		
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
				});
				
				$("#department").change(function() {
					var deptNo = parseInt($(this).val() / 10);
					
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
				});
				
				$(".sugang-list tr").each(function() {
					var sugang = $(this);
					console.log(sugang + "sugang");
					$(".course-list tr").each(function() {
						if(sugang.data("coursno") == $(this).data("coursno")) {
							$(this).find(".sugang-add-btn").prop("disabled", true);
						}
						preventAdd($(this));
					});
				});
				
				// 장바구니에 담기 클릭시의 로직
				$(".sugang-add-btn").off().click(function() {
					var tr = $(this).closest("tr");
					var btn = $(this);
					var sugang = {
						studno: studno,
						coursno: tr.data("coursno"),
						name: tr.data("name"),
						pname: tr.data("pname"),
						dname: tr.data("dname"),
						credit: tr.data("credit"),
						locno: tr.data("locno"),
						day: tr.data("day"),
						startTime: tr.data("starttime"),
						endTime: tr.data("endtime"),
						maxnum: tr.data("maxnum"),
						sugangNum: tr.data("sugangnum")
					}
					
					$.ajax({
						type: "post",
						url: "${pageContext.request.contextPath}/student/sugang/add",
						data: JSON.stringify(sugang),
						contentType: "application/json; charset=utf-8",
						success: function(result) {
							if(result != "") {
								btn.prop("disabled", true);
								$(".add-success").show();
								setTimeout(function() {
									$(".add-success").hide();
								}, 3000);
								showSugangList(sugang);
								addTimeTable(sugang);
								increaseSugangNum(tr);
								sugangListLength++;
							} else {
								$(".add-fail").show();
								setTimeout(function() {
									$(".add-fail").hide();
								}, 3000);
							}
							init();
						}
					});
					
				});
				
				// 장바구니에서 제외 클릭시의 로직
				$(".sugang-delete-btn").off().click(function() {
					var tr = $(this).closest("tr");
					var btn = $(this);
					var sugang = {
						studno: studno,
						coursno: tr.data("coursno"),
						name: tr.data("name"),
						pname: tr.data("pname"),
						dname: tr.data("dname"),
						credit: tr.data("credit"),
						locno: tr.data("locno"),
						day: tr.data("day"),
						startTime: tr.data("starttime"),
						endTime: tr.data("endtime"),
						maxnum: tr.data("maxnum"),
						sugangNum: tr.data("sugangnum"),
						status: false
					}
					
					$.ajax({
						type: "post",
						url: "${pageContext.request.contextPath}/student/sugang/delete",
						data: JSON.stringify(sugang),
						contentType: "application/json; charset=utf-8",
						success: function(result) {
							if(result != "") {
								$(".delete-success").show();
								setTimeout(function() {
									$(".delete-success").hide();
								}, 3000);
								$(".course-list tr").each(function() {
									if($(this).data("coursno") == tr.data("coursno")) {
										$(this).find(".sugang-add-btn").prop("disabled", false);
										decreaseSugangNum($(this));
									}
								});
								removeTimeTable(sugang);
								sugangListLength--;
								tr.remove();
							} else {
								$(".delete-fail").show();
								setTimeout(function() {
									$(".delete-fail").hide();
								}, 3000);
							}
							init();
						}
					});
				});
				
				$(".sugang-complete-form").on("submit", function() {
					if(sugangListLength != 0) {
						alert("수강신청이 완료되었습니다.");
					} else {
						event.preventDefault();
						alert("장바구니 목록이 비어있습니다.");
					}
				});
		   	}
		</script>
<jsp:include page="../includes/footer.jsp" />