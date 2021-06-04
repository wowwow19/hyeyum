<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper credit-list-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h3 class="page-title text-truncate text-dark font-weight-medium mb-1">이수학점 조회</h3>
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
		                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 이수학점 조회</p>
                                	</div>
                                    <div class="row table-container">
	                                    <table id="zero_config" class="table table-striped table-bordered no-wrap course-list">
	                                        <thead>
	                                            <tr class="text-center">
	                                                <th>이수구분</th>
	                                                <th>이수학점</th>
	                                                <th>강의명</th>
	                                                <th>학과명</th>
	                                                <th>교수명</th>
	                                                <th>학년</th>
	                                                <th>학기</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
                                            	<c:forEach items="${list}" var="course">
	                                            <tr>
	                                                <c:if test = "${empty course.category}">
	                                                <td class="text-center">일반</td>
	                                                </c:if>
	                                                <c:if test = "${not empty course.category}">
	                                                <td class="text-center">${course.category}</td>
	                                                </c:if>
	                                                <td class="text-center">${course.credit}</td>
	                                                <td class="text-center">${course.name}</td>
	                                                <td class="text-center">${course.dname}</td>
	                                                <td class="text-center">${course.pname}</td>
	                                                <fmt:parseNumber value="${course.semester / 2 + 1}" integerOnly="true" var ="grade"/>
	                                                <td class="text-center">${grade}</td>
	                                                 <c:if test = "${course.semester % 2 == 0}">
	                                                <td class="text-center">2</td>
	                                                 </c:if>
	                                                <c:if test = "${course.semester % 2 == 1}">
	                                                <td class="text-center">1</td>
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
	                <!-- *************************************************************** -->
	                <!-- End First Cards -->
	                <!-- *************************************************************** -->
                
                 	<div class="row">
   	               	    <div class="col-12">
	                        <div class="card">
	                            <div class="card-body">
	                                <div class="table-responsive col-md-12">
	                                	<div class="row">
			                            	<p class="card-title mb-3"><i class="fas fa-list"></i> 총 학점 조회</p>
	                                	</div>
	                                    <div class="row table-container">
		                                    <table id="zero_config" class="table table-striped table-bordered no-wrap course-list">
		                                        <thead>
		                                            <tr class="text-center">
		                                                <th>이수구분</th>
		                                                <th>이수총학점</th>
		                                            </tr>
		                                        </thead>
		                                        <tbody>
		                                            <tr>
		                                                <td class="text-center">전공필수</td>
		                                                <td class="text-center">${credit.contexts}</td>
	                                                </tr>
	                                                <tr>
		                                                <td class="text-center">전공선택</td>
		                                                <td class="text-center">${credit.electives}</td>
	                                                </tr>
	                                                <tr>
		                                                <td class="text-center">일반</td>
		                                                <td class="text-center">${credit.others}</td>
	                                                </tr>
	                                                <tr>
		                                                <td class="text-center">총계</td>
		                                                <td class="text-center">${credit.others+credit.electives+credit.contexts}</td>
	                                                </tr>
		                                        </tbody>
		                                    </table>
	                                    </div>
	                                </div>
                                </div>
                            </div>
                         </div>
                      </div>
                   </div>
                </div>
                <!-- *************************************************************** -->
                <!-- Start Top Leader Table -->
                <!-- *************************************************************** -->
               
                <!-- *************************************************************** -->
                <!-- End Top Leader Table -->
                <!-- *************************************************************** -->
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />