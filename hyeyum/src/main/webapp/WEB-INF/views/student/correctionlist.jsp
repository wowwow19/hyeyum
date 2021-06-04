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
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">이의신청 내역 조회</h4>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html" class="text-muted">수강/성적</a></li>
                                    <li class="breadcrumb-item text-muted active" aria-current="page">성적</li>
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
                   	<div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
	                                <div class="table-responsive col-md-12">
	                                	<div class="row">
		                            		<p class="card-title mb-3"><i class="fas fa-list"></i> 신청내역</p>
	                                	</div>
	                                    <div class="row table-container">
		                                    <table id="zero_config" class="table table-striped table-bordered no-wrap course-list">
		                                        <thead>
		                                            <tr class="text-center">
		                                                <th>번호</th>
		                                                <th>강의명</th>
		                                                <th>신청사유</th>
		                                                <th>신청일</th>
		                                                <th>처리상태</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <c:forEach items="${list}" var="correction" varStatus="status">
		                                                <td class="text-center">${status.count}</td>
		                                                <td class="text-center">${correction.coursname}</td>
		                                                <td class="text-center">${correction.reason}</td>
		                                                <fmt:formatDate var="regDate" pattern="yyyy/MM/dd" value="${correction.regDate}"/>
		                                                <td class="text-center">${regDate}</td>
		                                                <c:if test="${correction.corrStatus == 0}">
		                                                <td class="text-center">처리중</td>
		                                                </c:if>
		                                                 <c:if test="${correction.corrStatus == 1}">
		                                                <td class="text-center">승인</td>
		                                                </c:if>
		                                                 <c:if test="${correction.corrStatus == 2}">
		                                               <td class="text-center">반려</td>
		                                                </c:if>
		                                                <tr>
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
                <!-- *************************************************************** -->
                <!-- End First Cards -->
                <!-- *************************************************************** -->
                <!-- *************************************************************** -->
                <!-- Start Top Leader Table -->
                <!-- *************************************************************** -->
                
                <!-- *************************************************************** -->
                <!-- End Top Leader Table -->
                <!-- *************************************************************** -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />