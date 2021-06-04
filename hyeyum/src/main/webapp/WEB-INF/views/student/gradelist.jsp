<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper grade-list-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">성적조회</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html">성적</a>
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
                <div class="row">
               	    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
	                                <div class="table-responsive col-md-12">
	                                	<div class="row">
			                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 성적내역</p>
	                                	</div>
	                                    <div class="row table-container">
		                                    <table id="zero_config" class="table table-striped table-bordered no-wrap course-list">
		                                        <thead>
		                                            <tr class="text-center">
		                                                <th>학년</th>
		                                                <th>학기</th>
		                                                <th>강의명</th>
		                                                <th>학과명</th>
		                                                <th>교수명</th>
		                                                <th>이수구분</th>
		                                                <th>학점</th>
		                                                <th>등급</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
	                                            	<c:forEach items="${list}" var="course">
		                                            <tr>
		                                                <fmt:parseNumber value="${course.semester % 2 == 0 ? course.semester / 2 : course.semester / 2 + 1}" integerOnly="true" var ="grade"/>
		                                               	<td class="text-center">${grade}</td>
		                                                <fmt:parseNumber value="${course.semester}" integerOnly="true" var ="semester"/>
		                                               	<td class="text-center">${course.semester % 2 == 0 ? 2 : 1}</td>
		                                                <td class="text-center">${course.name}</td>
		                                                <td class="text-center">${course.dname}</td>
		                                                <td class="text-center">${course.pname}</td>
		                                                <c:if test="${empty course.category}">
		                                                <td class="text-center">일반</td>
		                                                </c:if>
		                                                <c:if test="${not empty course.category}">
		                                                <td class="text-center">${course.category}</td>
		                                                </c:if>
		                                                <td class="text-center">${course.credit}</td>
		                                                <td class="text-center">${course.result}</td>
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
         </div>
<jsp:include page="../includes/footer.jsp" />