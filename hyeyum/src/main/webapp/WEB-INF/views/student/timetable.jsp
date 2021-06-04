<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<jsp:include page="../includes/header.jsp" />
<jsp:include page="../includes/sidebar.jsp" />
		<!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper course-list-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">시간표조회</h4>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item"><a href="index.html" class="text-muted">수강/성적</a></li>
                                    <li class="breadcrumb-item text-muted active" aria-current="page">수강</li>
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
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- basic table -->
                <div class="row">
                    <div class="col-12">
                        <div class="card course-list-wrapper">
                            <div class="card-body">
                                <div class="table-responsive col-md-12">
                                	<div class="row mb-3">
                                		<div class="mr-auto">
		                            		<p class="card-title"><i class="fas fa-table"></i> 학업시간표</p>
                                		</div>
                                		<div class="ml-auto">
                                			<a class="btn btn-success btn-sm text-white" id="exportExcel"><i class="fas fa-file-excel"></i> EXCEL</a>
                                			<!-- <button class="btn btn-danger btn-sm" id="exportPdf"><i class="fas fa-file-pdf"></i> PDF</button> -->
                                		</div>
                                	</div>
                                	<div class="row tab-pane show" id="profile">
										<div class="table-responsive col-md-12">
		                                	<div class="row table-container" id="timeTable">
			                                    <table id="timeTable" class="table table-striped table-bordered">
			                                        <thead>
			                                            <tr class="text-center">
			                                                <th> </th>
			                                                <th>월</th>
			                                                <th>화</th>
			                                                <th>수</th>
			                                                <th>목</th>
			                                                <th>금</th>
			                                            </tr>
			                                        </thead>
			                                        <tbody>
			                                        	<c:forEach begin="0" end="7" var="j">
			                                        	<tr>
			                                        		<td class="text-center">${j+1}</td>
			                                        		<c:forEach begin="0" end="4" var="i">
			                                        		<c:if test="${timeTable[i][j].name ne null}">
		                                        			<td>${timeTable[i][j].name}<br>(${timeTable[i][0].locno}, ${timeTable[i][j].pname})</td>
			                                        		</c:if>
			                                        		<c:if test="${timeTable[i][j].name eq null}">
		                                        			<td></td>
			                                        		</c:if>
			                                        		</c:forEach>
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
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
		</div>
		<script>
		var studName = "${student.name}";
		
		$("#exportExcel").on('click', function () { 
			var fileName = "시간표_"+ studName + ".xls"; 
			
			var uri = $("#timeTable").excelexportjs({
				containerid: "timeTable", 
				datatype: 'table', 
				returnUri: true 
			}); 
			
			$(this).attr('download', fileName).attr('href', uri).attr('target', '_blank');
		});
		</script>
<jsp:include page="../includes/footer.jsp" />