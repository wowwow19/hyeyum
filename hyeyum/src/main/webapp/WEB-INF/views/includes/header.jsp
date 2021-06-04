<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/assets/images/favicon.png">
    <title>혜윰대학교 종합정보시스템-혜윰누리</title>
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/assets/libs/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/assets/extra-libs/c3/c3.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/libs/chartist/dist/chartist.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.css" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/style.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/assets/libs/jquery/dist/jquery.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <!-- 개별 CSS -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/student-style.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
        data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar" data-navbarbg="skin6">
            <nav class="navbar top-navbar navbar-expand-md">
                <div class="navbar-header" data-logobg="skin6">
                    <!-- This is for the sidebar toggle which is visible on mobile only -->
                    <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i
                            class="ti-menu ti-close"></i></a>
                    <!-- ============================================================== -->
                    <!-- Logo -->
                    <!-- ============================================================== -->
                    <div class="navbar-brand text-center">
                          <!-- Logo text -->
                       <sec:authorize access="hasRole('ROLE_ADMIN')">
                       <a href="${pageContext.request.contextPath}/admin/index">
                       </sec:authorize>
                       <sec:authorize access="hasRole('ROLE_STUDENT')">
                       <a href="${pageContext.request.contextPath}/student/index">
                       </sec:authorize>
                       <sec:authorize access="hasRole('ROLE_PROFESSOR')">
                       <a href="${pageContext.request.contextPath}/professor/index">
                       </sec:authorize>
                           <!-- Big Logo -->
                           <img src="${pageContext.request.contextPath}/resources/assets/images/logo2.png" alt="homepage" class="mt-3 big-logo" style="width: 100%;"/>
                           <!-- Middle Logo -->
                           <img src="${pageContext.request.contextPath}/resources/assets/images/logo3.png" alt="homepage" class="midium-logo d-none mb-1" style="max-width: 40%"/>
                           <!-- Small Logo -->
                           <img src="${pageContext.request.contextPath}/resources/assets/images/favicon.png" alt="homepage" class="mt-3 small-logo d-none" style="width: 100%;"/>
                       </a>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End Logo -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Toggle which is visible on mobile only -->
                    <!-- ============================================================== -->
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse collapse" id="navbarSupportedContent">
                    <!-- ============================================================== -->
                    <!-- Right side toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav ml-auto">
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <sec:authentication property="principal" var="member"/>
                                <span class="text-dark">${member == 'anonymousUser' ? 'Not Login' : member.vo.name}</span>
                                <span class="d-none d-lg-inline-block mr-2">님 </span>
                                <span class="text-dark"><i data-feather="chevron-down" class="svg-icon"></i></span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right user-dd animated flipInY">
                            	<sec:authorize access="hasRole('ROLE_STUDENT')">
                                <a href="${pageContext.request.contextPath}/student/index" class="dropdown-item mt-2"><i data-feather="home"
                                        class="svg-icon mr-2 ml-1"></i>
                                    홈</a>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_PROFESSOR')">
                                <a href="${pageContext.request.contextPath}/professor/index" class="dropdown-item mt-2"><i data-feather="home"
                                        class="svg-icon mr-2 ml-1"></i>
                                    홈</a>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="${pageContext.request.contextPath}/admin/index" class="dropdown-item mt-2"><i data-feather="home"
                                        class="svg-icon mr-2 ml-1"></i>
                                    홈</a>
                                </sec:authorize>
                                <form method="post" action="${pageContext.request.contextPath}/customLogout">
                                <button class="dropdown-item mt-2"><i data-feather="power"
                                        class="svg-icon mr-2 ml-1"></i>
                                    로그아웃</button>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								</form>
                                <div class="dropdown-divider"></div>
                                <div class="pl-4 p-3">
                                	<sec:authorize access="hasRole('ROLE_PROFESSOR')">
                                	<a href="${pageContext.request.contextPath}/professor/info" class="btn btn-sm btn-info btn-block">
                                	</sec:authorize>
                                	<sec:authorize access="hasRole('ROLE_STUDENT')">
                                	<a href="${pageContext.request.contextPath}/student/info" class="btn btn-sm btn-info btn-block">
                                	</sec:authorize>
                                		내 정보보기
                               		</a>
                           		</div>
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <script>
       	changeLogo();
        
        $(window).resize(function() {
        	changeLogo();
        });
        
        function changeLogo() {
            var windowWidth = $(window).width();
			
            if(windowWidth >= 1170) {
            	$(".big-logo").removeClass("d-none");
            	$(".midium-logo").addClass("d-none");
            	$(".small-logo").addClass("d-none");
            }
            
            if(windowWidth < 1170){
            	$(".big-logo").addClass("d-none");
            	$(".midium-logo").addClass("d-none");
            	$(".small-logo").removeClass("d-none");
            }
            
            if(windowWidth < 768){
            	$(".big-logo").addClass("d-none");
            	$(".midium-logo").removeClass("d-none");
            	$(".small-logo").addClass("d-none");
            }
        }
        </script>