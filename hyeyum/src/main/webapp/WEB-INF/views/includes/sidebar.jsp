<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
 <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar" data-sidebarbg="skin6">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar" data-sidebarbg="skin6">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="${pageContext.request.contextPath}/admin/index"
                                aria-expanded="false"><i data-feather="home" class="feather-icon"></i><span
                                    class="hide-menu">홈</span></a></li>
					</sec:authorize>
                                    
                    <sec:authorize access="hasRole('ROLE_STUDENT')">
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="${pageContext.request.contextPath}/student/index"
                                aria-expanded="false"><i data-feather="home" class="feather-icon"></i><span
                                    class="hide-menu">홈</span></a></li>
                    </sec:authorize>
                                    
                    <sec:authorize access="hasRole('ROLE_PROFESSOR')">
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="${pageContext.request.contextPath}/professor/index"
                                aria-expanded="false"><i data-feather="home" class="feather-icon"></i><span
                                    class="hide-menu">홈</span></a></li>
                    </sec:authorize>
                      	<sec:authorize access="hasRole('ROLE_ADMIN')">
                    	<!-- 행정 -->
                        <li class="list-divider"></li>
                        <li class="nav-small-cap"><span class="hide-menu">admin Components</span></li>
                       		<li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">인적자원관리
                                    </span></a>
                            <ul aria-expanded="false" class="collapse first-level base-level-line">
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">교직원</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/professorlist" class="sidebar-link"><span
                                                    class="hide-menu">교직원 목록 조회 
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/registerprofessor" class="sidebar-link"><span
                                                    class="hide-menu">교직원 등록 
                                                    </span></a></li>
                                    </ul>
                                </li>
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">학생</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/studentlist" class="sidebar-link"><span
                                                    class="hide-menu"> 학생 목록 조회
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/registerstudent" class="sidebar-link"><span
                                                    class="hide-menu"> 학생 등록
                                                    </span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        
                        <li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">강의 관리 </span></a>
                            <ul aria-expanded="false" class="collapse  first-level base-level-line">
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/managementopencourse" class="sidebar-link"><span
                                            class="hide-menu"> 강의 개설 관리
                                        </span></a>
                                </li>
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/managementcourse" class="sidebar-link"><span
                                            class="hide-menu"> 강의 관리
                                        </span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="${pageContext.request.contextPath}/admin/managementstatus"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">학적변동 관리
                                </span></a>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="${pageContext.request.contextPath}/admin/curriculum"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">커리큘럼
                                </span></a>
                        </li>
                        
                        <li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">등록/장학/급여
                                    </span></a>
                            <ul aria-expanded="false" class="collapse first-level base-level-line">
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">등록금</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/tuitionlist" class="sidebar-link"><span
                                                    class="hide-menu">등록급 납부 내역조회 
                                                    </span></a></li>
                                    </ul>
                                </li>
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">장학금</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/scholarship" class="sidebar-link"><span
                                                    class="hide-menu"> 장학금 지급
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/scholarshiplist" class="sidebar-link"><span
                                                    class="hide-menu"> 장학금지급 내역조회
                                                    </span></a></li>
                                    </ul>
                                </li>
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">교직원 급여</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/salary" class="sidebar-link"><span
                                                    class="hide-menu"> 교직원 급여지급
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/admin/salarylist" class="sidebar-link"><span
                                                    class="hide-menu"> 교직원 급여지급 내역조회
                                                    </span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        </sec:authorize>
                        
                        <sec:authorize access="hasRole('ROLE_STUDENT')">
                        <!-- 학생  -->
						<li class="list-divider"></li>
                        <li class="nav-small-cap"><span class="hide-menu">Student Components</span></li>
						<li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i class="fas fa-graduation-cap"></i><span
                                    class="hide-menu">학적관리 </span></a>
                            <ul aria-expanded="false" class="collapse  first-level base-level-line">
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/info" class="sidebar-link"><span
                                            class="hide-menu"> 개인신상정보관리
                                        </span></a>
                                </li>
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/statuslist" class="sidebar-link"><span
                                            class="hide-menu"> 학적 변동 이력 조회
                                        </span></a>
                                </li>
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/status" class="sidebar-link"><span
                                            class="hide-menu"> 휴복학 신청
                                        </span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i class="fas fa-graduation-cap"></i><span
                                    class="hide-menu">수강/성적
                                    </span></a>
                            <ul aria-expanded="false" class="collapse first-level base-level-line">
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">수강</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/courselist" class="sidebar-link"><span
                                                    class="hide-menu">개설강의 조회 
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/sugang" class="sidebar-link"><span
                                                    class="hide-menu"> 수강신청
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/suganglist" class="sidebar-link"><span
                                                    class="hide-menu"> 수강신청 내역 조회
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/timetable" class="sidebar-link"><span
                                                    class="hide-menu"> 시간표 조회
                                                    </span></a></li>
                                    </ul>
                                </li>
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">성적</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/creditlist" class="sidebar-link"><span
                                                    class="hide-menu"> 이수학점 조회
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/gradelist" class="sidebar-link"><span
                                                    class="hide-menu"> 성적조회
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/correction" class="sidebar-link"><span
                                                    class="hide-menu"> 성적 이의신청
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/correctionlist" class="sidebar-link"><span
                                                    class="hide-menu"> 이의신청 내역 조회
                                                    </span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i class="fas fa-graduation-cap"></i><span
                                    class="hide-menu">등록/장학
                                    </span></a>
                            <ul aria-expanded="false" class="collapse first-level base-level-line">
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">등록</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/tuition" class="sidebar-link"><span
                                                    class="hide-menu">등록금 납부 
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/tuitionlist" class="sidebar-link"><span
                                                    class="hide-menu"> 등록금 납부 내역 조회
                                                    </span></a></li>
                                    </ul>
                                </li>
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">장학</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/student/scholarshiplist" class="sidebar-link"><span
                                                    class="hide-menu"> 장학금 내역 조회
                                                    </span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_PROFESSOR')">
                        <!-- 교수  -->
						<li class="list-divider"></li>
                        <li class="nav-small-cap"><span class="hide-menu">Professor Components</span></li>
						<li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">신상관리 </span></a>
                            <ul aria-expanded="false" class="collapse  first-level base-level-line">
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/professor/info?profno=<sec:authentication property="principal.username"/>" class="sidebar-link"><span
                                            class="hide-menu"> 개인신상정보관리
                                        </span></a>
                                </li>
                            </ul>
                        </li>
						<li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">강의개설관리</span></a>
                            <ul aria-expanded="false" class="collapse  first-level base-level-line">
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/professor/registercourse" class="sidebar-link"><span
                                            class="hide-menu"> 강의개설신청
                                        </span></a>
                                </li>
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/professor/courselist" class="sidebar-link"><span
                                            class="hide-menu"> 강의현황조회
                                        </span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">학생/성적
                                    </span></a>
                            <ul aria-expanded="false" class="collapse first-level base-level-line">
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">담당학생</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/professor/studentlist?profno=<sec:authentication property="principal.username"/>
                                        " class="sidebar-link"><span
                                                    class="hide-menu">담당학생조회 
                                                    </span></a></li>
                                    </ul>
                                </li>
                                <li class="sidebar-item"> <a class="has-arrow sidebar-link" href="javascript:void(0)"
                                        aria-expanded="false"><span class="hide-menu">성적</span></a>
                                    <ul aria-expanded="false" class="collapse second-level base-level-line">
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/professor/registergrade?profno=<sec:authentication property="principal.username"/>
                                        " class="sidebar-link"><span
                                                    class="hide-menu"> 성적입력
                                                    </span></a></li>
                                        <li class="sidebar-item"><a href="${pageContext.request.contextPath}/professor/correctionlist?profno=<sec:authentication property="principal.username"/>
                                        " class="sidebar-link"><span
                                                    class="hide-menu"> 성적 이의신청 조회
                                                    </span></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link has-arrow" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="folder" class="feather-icon"></i><span
                                    class="hide-menu">급여관리</span></a>
                            <ul aria-expanded="false" class="collapse  first-level base-level-line">
                                <li class="sidebar-item"><a href="${pageContext.request.contextPath}/professor/salarylist" class="sidebar-link"><span
                                            class="hide-menu"> 급여 내역 조회
                                        </span></a>
                                </li>
                            </ul>
                        </li>
                        </sec:authorize>
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->