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
                                    <li class="breadcrumb-item"><a href="index.html">registergrade</a>
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
                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 강의목록</p>
                                <div class="table-responsive">
                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                        <thead>
                                            <tr>
                                                <th>강의고유번호</th>
                                                <th>강의명</th>
                                                <th>이수학점</th>
                                                <th>요일</th>
                                                <th>강의시작시간</th>
                                                <th>강의종료시간</th>
                                                <th>강의실</th>
                                                <th>신청승인여부</th>
                                                <th>정원</th>
                                                <th>담당학과</th>
                                                <th>담당교수</th>
                                                <th>학기</th>
                                                <th>개강날짜</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${list}" var="course">
                                            <tr>
                                                <td>${course.coursno}</td>
                                                 <td><a href="registergradelist?coursno=${course.coursno}">${course.name}</a></td>
                                                <td>${course.credit}</td>
                                                <td>${course.day}</td>
                                                <td>${course.startTime}</td>
                                                <td>${course.endTime}</td>
                                                <td>${course.locno}</td>
                                                <td>${course.enable}</td>
                                                <td>${course.maxnum}</td>
                                                <td>${course.deptno}</td>
                                                <td>${course.profno}</td>
                                                <td>${course.semester}</td>
                                                <td><fmt:formatDate value="${course.regDate}"/> </td>
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