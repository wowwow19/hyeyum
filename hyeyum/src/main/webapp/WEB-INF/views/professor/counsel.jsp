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
                                    <li class="breadcrumb-item"><a href="index.html">counsel</a>
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
                <div class="card-group">
                    <div class="card border-right">
                        <div class="card-body">
                            <form method="post" action="">
								 <div class="form-row">
									 <div class="form-group col-md-3">
									    <label for="name">교수번호</label>
									    <input type="text" class="form-control" name="profno" id="profno" placeholder="교수번호 입력란">
								 	 </div>
									 <div class="form-group col-md-3">
									    <label for="birthdate">학생번호</label>
									    <input type="text" class="form-control" name="studno" id="studno" placeholder="학번 입력란">								 	
									 </div>
									 <div class="form-group col-md-3">
									    <label for="tel">상담일자</label>
									    <input type="text" class="form-control" name="coundate" id="coundate" pattern="[0-9]{6}" placeholder="상담일자 입력란(yymmdd)">								 	
									 </div>
									 <div class="form-group col-md-12">
									    <label for="content">내용</label>
									    <textarea rows="5"  class="form-control" id="content" name="content" placeholder="상담내용입력란"></textarea>
								 	 </div>
								 </div>
								 <div class="row">
								 	<div class="col-md-12">
									    <button type="submit" class="btn btn-info btn-block">등록하기</button>								 	
								 	</div>
								 </div>
								 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							</form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
<jsp:include page="../includes/footer.jsp" />