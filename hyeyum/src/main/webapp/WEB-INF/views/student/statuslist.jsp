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
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">학적변동이력조회</h4>
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
                <!-- 카테고리 -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                        	<div class="card-body">
                        		<form class="status-search">
	                		        <p class="card-title mb-3"><i class="fas fa-chevron-right"></i> 검색조건 </p>
	                        		<div class="row mb-1">
										<div class="input-group col-md-2">
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
										<div class="input-group col-md-2">
	                                        <div class="input-group-prepend">
	                                            <label class="input-group-text" for="inputGroupSelect01">신청사항</label>
	                                        </div>
	                                        <select class="custom-select" id="inputGroupSelect01" name="change">
	                                            <option selected value="">선택</option>
	                                            <option value="0">휴학</option>
	                                            <option value="1">복학</option>
	                                        </select>
                                    	</div>
										<div class="input-group col-md-2">
	                                        <div class="input-group-prepend">
	                                            <label class="input-group-text" for="inputGroupSelect01">처리상태</label>
	                                        </div>
	                                        <select class="custom-select" id="inputGroupSelect01" name="status">
	                                            <option selected value="">선택</option>
	                                            <option value="0">처리중</option>
	                                            <option value="1">처리완료</option>
	                                        </select>
                                    	</div>
                                    	<div class="ml-auto mr-3">
	                        				<button class="btn btn-primary">검색</button>
	                        				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	                        			</div>                       			
	                        		</div>
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
	                                            	</c:if>
	                                            	<c:if test="${vo.reStatus}">
	                                            	<td class="text-center">처리완료</td>
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
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
		</div>
<jsp:include page="../includes/footer.jsp" />