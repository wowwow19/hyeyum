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
                                    <li class="breadcrumb-item"><a href="index.html">studentlist</a>
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
            	<div class="row">
                    <div class="col-12">
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 학생목록</p>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                        <thead>
                                            <tr>
                                                <th>학번</th>
                                                <th>이름</th>
                                                <th>생년월일</th>
                                                <th>학년</th>
                                                <th>성별</th>
                                                <th>학적상태</th>
                                                <th>학과코드</th>
                                                <th>소속학과</th>
                                                <th>교수코드</th>
                                                <th>담당교수</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="student">
                                            <tr>
                                                <td>${student.studno}</td>
                                                <td><a href="counsellist?studno=${student.studno}">${student.name}</a></td>
                                                <td><fmt:formatDate value="${student.birthDate}"/></td>
                                                <td>${student.grade} 학년</td>
                                                <td>
                                                <c:choose>
                                                <c:when test="${student.gender eq 'M'}">남</c:when>
                                                <c:when test="${student.gender eq 'F'}">여</c:when>
                                                </c:choose>
                                                </td>
                                                <td>
                                                <c:choose>
                                                <c:when test="${student.status eq false}">휴학</c:when>
                                                <c:when test="${student.status eq true}">재학</c:when>
                                                </c:choose>
                                                </td>
                                                <td>${student.deptno}</td>
                                                <td>${student.deptname}</td>
                                                <td>${student.profno}</td>
                                                <td>${student.profname}</td>
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
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />