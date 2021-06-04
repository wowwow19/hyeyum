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
                                    <li class="breadcrumb-item"><a href="index.html">correctionlist</a>
                                    </li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
            	<div class="row">
                    <div class="col-12">
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 성적이의신청 조회</p>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                        <thead>
                                            <tr>
                                                <th>고유번호</th>
                                                <th>강의번호</th>
                                                <th>이유</th>
                                                <th>학번</th>
                                                <th>요청완료여부</th>
                                                <th>이의신청날짜</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="correction">
                                            <tr>
                                                <td class="text-center">${correction.corrno}</td>
                                                <td class="text-center"><a href="correction?corrno=${correction.corrno}&studno=${correction.studno}&coursno=${correction.coursno}">${correction.coursno}</a></td>
                                                <td>${correction.reason}</td>
                                                <td class="text-center">${correction.studno}</td>
                                                <c:if test="${correction.corrStatus eq 0}">
                                                <td class="text-center">처리중</td>
                                                </c:if>
                                                <c:if test="${correction.corrStatus eq 1}">
                                                <td class="text-center">승인됨</td>
                                                </c:if>
                                                <c:if test="${correction.corrStatus eq 2}">
                                                <td class="text-center">처리 거부됨</td>
                                                </c:if>
                                                <td><fmt:formatDate value="${correction.regDate}"/> </td>
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
            
<jsp:include page="../includes/footer.jsp" />