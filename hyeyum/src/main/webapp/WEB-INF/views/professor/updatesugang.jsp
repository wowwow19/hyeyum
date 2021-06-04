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
                                    <li class="breadcrumb-item"><a href="index.html">correction</a>
                                    </li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
           <div class="container-fluid">
                <!-- *************************************************************** -->
                <!-- Start First Cards -->
                <!-- *************************************************************** -->
                <div class="card-group">
                    <div class="card border-right">
                        <div class="card-body">
                            <form method="post" action="">
								 <div class="form-row">
								 	<div class="form-group col-md-3">
									    <label for="studno">학번</label>
									    <input type="text" class="form-control" name="studno" id="studno" readonly value="${sugang.studno}" placeholder="학번 입력란">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="name">이름</label>
									    <input type="text" class="form-control" name="name" id="name" readonly value="${sugang.studname}" placeholder="이름 입력란">
								 	 </div>
								 	 <div class="form-group col-md-3">
									    <label for="name">과목명</label>
									    <input type="text" class="form-control" name="name" id="name" readonly value="${sugang.coursname}" placeholder="과목명 입력란">
								 	 </div>
									<div class="form-group col-md-3">
									    <label for="name">성적</label>
									    <input type="text" class="form-control" name="result" id="result" value="${sugang.result}" placeholder="성적 입력란">
								 	 </div>
								 </div>
								 <div class="row">
								 	<div class="col-md-12 mb-2">
									    <button type="submit" class="btn btn-info btn-block">수정하기</button>								 	
								 	</div>
								 </div>
								 <div class="row">
								 	<div class="col-md-12">
									    <a href="${pageContext.request.contextPath}/professor/correctionlist" class="btn btn-info btn-block">수정거부</a>								 	
								 	</div>
								 </div>
							</form>
                        </div>
                    </div>
                </div>
                <!-- *************************************************************** -->
                <!-- End Top Leader Table -->
                <!-- *************************************************************** -->
            </div>
            
<jsp:include page="../includes/footer.jsp" />