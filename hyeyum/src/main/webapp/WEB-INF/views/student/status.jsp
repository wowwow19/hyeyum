<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
		<!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper status-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">휴복학 신청</h4>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item text-muted active" aria-current="page">학적관리</li>
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
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                                <div class="table-responsive col-md-12">
                                	<div class="row mb-3">
		                            	<p class="card-title"><i class="fas fa-list"></i> 학적변동내역</p>
                                	</div>
                                    <div class="row table-container">
	                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
	                                        <thead>
	                                            <tr class="text-center">
	                                                <th>연번</th>
	                                                <th>학생명</th>
	                                                <th>신청사항</th>
	                                                <th>사유</th>
	                                                <th>신청일자</th>
	                                                <th>처리상태</th>
	                                                <th>신청취소</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
                                        		<c:forEach items="${list}" var="vo" varStatus="status">
	                                            <tr>
	                                            	<td class="text-center">${status.count}</td>
	                                            	<td class="text-center">${vo.name}</td>
	                                            	<c:if test="${!vo.change}">
	                                            	<td class="text-center">휴학</td>
	                                            	</c:if>
	                                            	<c:if test="${vo.change}">
	                                            	<td class="text-center">복학</td>
	                                            	</c:if>
	                                            	<td>${vo.reason}</td>
	                                            	<fmt:formatDate var="regDate" pattern="yyyy/MM/dd" value="${vo.regDate}"/>
	                                            	<td class="text-center">${regDate}</td>
	                                            	<c:if test="${!vo.reStatus}">
	                                            	<td class="text-center">처리중</td>
	                                            	<td class="text-center">
	                                            		<form class="status-cancel-form" method="post" action="${pageContext.request.contextPath}/student/status/cancel">
		                                            		<button class="btn btn-danger btn-sm status-cancel-btn"><i class="ti-trash"></i> 취소</button>
		                                            		<input type="hidden" name="statusno" value="${vo.statusno}">
		                                            		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                                            		</form>
                                            		</td>
	                                            	</c:if>
	                                            	<c:if test="${vo.reStatus}">
	                                            	<td class="text-center">처리완료</td>
	                                            	<td class="text-center"></td>
	                                            	</c:if>
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
                <!-- 카테고리 -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                        	<div class="card-body">
                		        <p class="card-title mb-3"><i class="fas fa-pencil-alt"></i> 신청</p>
                        		<div class="row mb-3">
									<div class="col-md-2">
                                        <label for="name">학생명</label>
								    	<input type="text" class="form-control" name="name" id="name" readonly value="${user.name}">
                                   	</div>                     			
									<div class="col-md-2">
                                        <label for="dname">학과</label>
								    	<input type="text" class="form-control" name="deptname" id="deptname" readonly value="${user.deptname}">
                                   	</div>                     			
									<div class="col-md-2">
                                        <label for="currentStatus">학적상태</label>
                                        <c:if test="${user.status}">
								    	<input type="text" class="form-control" name="currentStatus" id="currentStatus" readonly value="재학">
                                        </c:if>
                                        <c:if test="${!user.status}">
								    	<input type="text" class="form-control" name="currentStatus" id="currentStatus" readonly value="휴학">
                                        </c:if>
                                   	</div>                     			
                        		</div>
                       			<form method="post" action="${pageContext.request.contextPath}/student/status/request" class="status-req-form row">
									<div class="input-group col-md-2">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text" for="inputGroupSelect01">신청사항</label>
                                        </div>
                                        <select class="custom-select" id="inputGroupSelect01" name="change" required>
                                            <option selected value="">선택</option>
                                            <c:if test="${user.status}">
                                            <option value="0">휴학</option>
                                            </c:if>
                                            <c:if test="${!user.status}">
                                            <option value="1">복학</option>
                                            </c:if>
                                        </select>
                                   	</div>
									<div class="input-group col-md-9">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text" for="reason">신청사유</label>
                                        </div>
                                        <input class="form-control" type="text" name="reason" id="reason" placeholder="간단히 입력" required>
                                   	</div>
                                   	<div class="ml-auto mr-3">
                        				<button class="btn btn-primary">신청</button>
                        				<input type="hidden" name="studno" id="studno" value="${user.studno}">
                        				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        			</div>                       			
                       			</form>
                        	</div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
	            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show request-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 학적변동 신청을 완료했습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show request-fail" role="alert">
	                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	                    <span aria-hidden="true">×</span>
	                </button>
	                <strong>실패 - </strong> 이미 처리중인 내역이 있거나 현재와 같은 상태로 신청할 수 없습니다
	            </div>
				<div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show cancel-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 학적변동 신청을 취소했습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show cancel-fail" role="alert">
	                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	                    <span aria-hidden="true">×</span>
	                </button>
	                <strong>실패 - </strong> 학적변동 신청취소를 실패했습니다
	            </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
		</div>
		<script>
			var reqErrMsg = "${reqErrMsg}";
			var canErrMsg = "${canErrMsg}";
			console.log(reqErrMsg);
			console.log(canErrMsg);
			
			if(reqErrMsg == "success") {
				$(".request-success").show();
				setTimeout(function() {
				$(".request-success").hide();
				}, 3000);
			} else if(reqErrMsg == "fail") {
				$(".request-fail").show();
				setTimeout(function() {
				$(".request-fail").hide();
				}, 3000);
			}
			
			if(canErrMsg == "success") {
				$(".cancel-success").show();
				setTimeout(function() {
				$(".cancel-success").hide();
				}, 3000);
			} else if(canErrMsg == "fail") {
				$(".cancel-fail").show();
				setTimeout(function() {
				$(".cancel-fail").hide();
				}, 3000);
			}
			
			$(".status-cancel-form").on("submit", function() {
				if(!confirm("정말 취소하시겠습니까?")) {
					event.preventDefault();
				}
			});
			
			$(".status-req-form").on("submit", function() {
				if(!confirm("정말 신청하시겠습니까?")) {
					event.preventDefault();
				}
			});
		</script>
<jsp:include page="../includes/footer.jsp" />