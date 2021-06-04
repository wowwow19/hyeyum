<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
				<div class="row">
                    <div class="col-md-12">
               			<p class="card-title mb-3"><i class="fas fa-calendar-alt"></i> 학사일정</p>
                        <div class="card">
                            <div class="">
                                <div class="row">
                                    <div class="col-lg-3 border-right pr-0">
                                        <div class="card-body border-bottom text-center">
                                            <h4 class="card-title mt-2 calendar-title"></h4>
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div id="calendar-events" class="monthly-schedule-list">
                                                    	<c:forEach items="${scheduleList}" var="schedule">
                                                        <div class="calendar-events mb-3 ui-draggable ui-draggable-handle schedule-event" data-class="bg-secondary" style="position: relative;" data-scheno="${schedule.scheno}" data-startDay="${schedule.startDay}" data-endDay="${schedule.endDay}" data-content="${schedule.content}">
                                                        	<i class="fa fa-circle text-secondary mr-2"></i>${schedule.startDay} ~ ${schedule.endDay}
                                                        	<p>${schedule.content}</p>
                                                        </div>
                                                    	</c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                                        <div class="card-body text-center add-schedule">
                                  			<button type="button" class="btn btn-primary btn-block add-schedule-btn"><i class="fas fa-plus-circle"></i> 일정추가</button>
                                        </div>
                                        </sec:authorize>
                                    </div>
                                    <div class="col-lg-9">
                                        <div class="card-body b-l calender-sidebar">
                                            <div id="calendar" class="fc fc-unthemed fc-ltr"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- 추가/수정/삭제 성공여부 알림창 -->
	            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show add-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 일정을 추가했습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show add-fail" role="alert">
			        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			            <span aria-hidden="true">×</span>
			        </button>
			        <strong>실패 - </strong> 일정을 추가하는 데 실패했습니다
		        </div>
	            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show update-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 일정을 수정했습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show update-fail" role="alert">
			        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			            <span aria-hidden="true">×</span>
			        </button>
			        <strong>실패 - </strong> 일정을 수정하는 데 실패했습니다
		        </div>
	            <div class="alert alert-success alert-dismissible bg-success text-white border-0 fade show delete-success" role="alert">
				    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				        <span aria-hidden="true">×</span>
				    </button>
				    <strong>성공 - </strong> 일정을 삭제했습니다
				</div>
				<div class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show delete-fail" role="alert">
			        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			            <span aria-hidden="true">×</span>
			        </button>
			        <strong>실패 - </strong> 일정을 삭제하는 데 실패했습니다
		        </div>
		        
		        <!-- Insert Modal-->
				<div class="modal fade" id="addScheduleModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="myModalLabel">일정추가</h5>
								<button class="close" type="button" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<form method="post" class="add-schedule-form" action="${pageContext.request.contextPath}/schedule/add">
								<div class="modal-body">
		                          	    <div class="form-group mb-3">
											<label for="content" class="font-weight-bold text-secondary">행사내용</label>
											<input type="text" class="form-control" name="content" placeholder="행사내용" required>
									    </div>
			                          	    <div class="form-group mb-3">
											<label for="startDay" class="font-weight-bold text-secondary">시작날짜</label>
											<input type="date" class="form-control" name="startDay" placeholder="작성자" required>
									    </div>
			                          	    <div class="form-group mb-3">
											<label for="endDay" class="font-weight-bold text-secondary">종료날짜</label>
											<input type="date" class="form-control" name="endDay" placeholder="종료날짜" required>
									    </div>
								</div>
								<div class="modal-footer">
									<button class="btn btn-primary btn-sm submit-schedule-btn" type="submit">등록</button>
									<button class="btn btn-outline-secondary btn-sm" type="button"
										data-dismiss="modal">닫기</button>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								</div>
		                  	</form>
						</div>
					</div>
				</div>
				
		        <!-- Read/Update Modal-->
				<div class="modal fade" id="updateScheduleModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
								<h5 class="modal-title" id="myModalLabel">일정수정</h5>
								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_STUDENT') OR hasRole('ROLE_PROFESSOR')">
								<h5 class="modal-title" id="myModalLabel">일정보기</h5>
								</sec:authorize>
								<button class="close" type="button" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<form method="post" class="update-schedule-form" action="${pageContext.request.contextPath}/schedule/update">
								<div class="modal-body">
		                          	    <div class="form-group mb-3">
											<label for="content" class="font-weight-bold text-secondary">행사내용</label>
											<sec:authorize access="hasRole('ROLE_ADMIN')">
											<input type="text" class="form-control" name="content" placeholder="행사내용" required>
											</sec:authorize>
											<sec:authorize access="hasRole('ROLE_STUDENT') OR hasRole('ROLE_PROFESSOR')">
											<input type="text" class="form-control" name="content" placeholder="행사내용" readonly>
											</sec:authorize>
									    </div>
			                          	    <div class="form-group mb-3">
											<label for="startDay" class="font-weight-bold text-secondary">시작날짜</label>
											<sec:authorize access="hasRole('ROLE_ADMIN')">
											<input type="date" class="form-control" name="startDay" placeholder="작성자" required>
											</sec:authorize>
											<sec:authorize access="hasRole('ROLE_STUDENT') OR hasRole('ROLE_PROFESSOR')">
											<input type="date" class="form-control" name="startDay" placeholder="작성자" readonly>
											</sec:authorize>
									    </div>
			                          	    <div class="form-group mb-3">
											<label for="endDay" class="font-weight-bold text-secondary">종료날짜</label>
											<sec:authorize access="hasRole('ROLE_ADMIN')">
											<input type="date" class="form-control" name="endDay" placeholder="종료날짜" required>
											</sec:authorize>
											<sec:authorize access="hasRole('ROLE_STUDENT') OR hasRole('ROLE_PROFESSOR')">
											<input type="date" class="form-control" name="endDay" placeholder="종료날짜" readonly>
											</sec:authorize>
									    </div>
								</div>
								<div class="modal-footer">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
									<button class="btn btn-warning btn-sm submit-schedule-btn" type="submit">수정</button>
									<button class="btn btn-danger btn-sm delete-schedule-btn" type="button">삭제</button>
									</sec:authorize>
									<button class="btn btn-outline-secondary btn-sm" type="button"
										data-dismiss="modal">닫기</button>
									<input type="hidden" name="scheno" required>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								</div>
		                  	</form>
						</div>
					</div>
				</div>
		        
		        <script>
		        var d = "${category.day}";
		        var m = "${category.month}";
		        var y = "${category.year}";
		        
				! function($) {
				    "use strict";
		
				    var CalendarApp = function() {
				        this.$body = $("body")
				        this.$calendar = $('#calendar'),
				        this.$event = ('#calendar-events div.calendar-events'),
				        this.$categoryForm = $('#add-new-event form'),
				        this.$extEvents = $('#calendar-events'),
				        this.$modal = $('#my-event'),
				        this.$saveCategoryBtn = $('.save-category'),
				        this.$calendarObj = null
				    };
		
				    /* on drop */
				    CalendarApp.prototype.onDrop = function(eventObj, date) {
				            var $this = this;
				            // retrieve the dropped element's stored Event Object
				            var originalEventObject = eventObj.data('eventObject');
				            var $categoryClass = eventObj.attr('data-class');
				            // we need to copy it, so that multiple events don't have a reference to the same object
				            var copiedEventObject = $.extend({}, originalEventObject);
				            // assign it the date that was reported
				            copiedEventObject.start = date;
				            if ($categoryClass)
				                copiedEventObject['className'] = [$categoryClass];
				            // render the event on the calendar
				            $this.$calendar.fullCalendar('renderEvent', copiedEventObject, true);
				            // is the "remove after drop" checkbox checked?
				            if ($('#drop-remove').is(':checked')) {
				                // if so, remove the element from the "Draggable Events" list
				                eventObj.remove();
				            }
				        },
				        CalendarApp.prototype.enableDrag = function() {
				            //init events
				            $(this.$event).each(function() {
				                // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
				                // it doesn't need to have a start or end
				                var eventObject = {
				                    title: $.trim($(this).text()) // use the element's text as the event title
				                };
				                // store the Event Object in the DOM element so we can get to it later
				                $(this).data('eventObject', eventObject);
				                // make the event draggable using jQuery UI
				                $(this).draggable({
				                    zIndex: 999,
				                    revert: true, // will cause the event to go back to its
				                    revertDuration: 0 //  original position after the drag
				                });
				            });
				        }
				    /* Initializing */
				    CalendarApp.prototype.init = function() {
				            this.enableDrag();
				            /*  Initialize the calendar  */
				            var date = new Date();
				            var form = '';
				            var today = new Date($.now());
				            var length = "${fn:length(totalScheduleList)}";
				            var defaultEvents = [];
							var i = 0;
							
				            <c:forEach items="${totalScheduleList}" var="schedule">
			            		defaultEvents[i] = {
				                    title: "${schedule.content}",
				                    start: Date.parse("${schedule.startDay}"),
				                    end: Date.parse("${schedule.endDay}"),
				                    className: 'bg-secondary'
			            		};
			            		i++;
		            		</c:forEach>
		
				            var $this = this;
				            $this.$calendarObj = $this.$calendar.fullCalendar({
				                defaultView: 'month',
				                handleWindowResize: true,
		
				                header: {
				                    left: 'prev, today',
				                    center: 'title',
				                    right: 'next'
				                },
				                events: defaultEvents,
				                editable: false,
				                droppable: false, // this allows things to be dropped onto the calendar !!!
				                eventLimit: true, // allow "more" link when too many events
				                selectable: false
				            });
				        },
		
				        //init CalendarApp
				        $.CalendarApp = new CalendarApp, $.CalendarApp.Constructor = CalendarApp
		
				}(window.jQuery),
		
				//initializing CalendarApp
				$(window).on('load', function() {
					const thisYear = "${category.year}";
					const thisMonth = "${category.month}";
					const thisDay = "${category.day}";
		            var year = "${category.year}";
		            var month = "${category.month}";
		            var day = "${category.day}";
					var addMsg = "${addMsg}";
					var updateMsg = "${updateMsg}";
					var deleteMsg = "${deleteMsg}";
					var csrf = "${_csrf.headerName}";
					var csrfToken = "${_csrf.token}";
					
					init();
					
					if(addMsg == "success") {
						$(".add-success").show();
						setTimeout(function() {
						$(".add-success").hide();
						}, 3000);
					} else if(addMsg == "fail") {
						$(".add-fail").show();
						setTimeout(function() {
						$(".add-fail").hide();
						}, 3000);
					}
					
					if(updateMsg == "success") {
						$(".update-success").show();
						setTimeout(function() {
						$(".update-success").hide();
						}, 3000);
					} else if(updateMsg == "fail") {
						$(".update-fail").show();
						setTimeout(function() {
						$(".update-fail").hide();
						}, 3000);
					}
					
					if(deleteMsg == "success") {
						$(".delete-success").show();
						setTimeout(function() {
						$(".delete-success").hide();
						}, 3000);
					} else if(deleteMsg == "fail") {
						$(".delete-fail").show();
						setTimeout(function() {
						$(".delete-fail").hide();
						}, 3000);
					}
		        	
				    $.CalendarApp.init();
				    
		            $(".calendar-title").text(year + "년 " + month + "월");
		            
					$(".fc-prev-button").one().click(function() {
						if(--month == 0) {
							month = 12;
							year--;
						}
						
						showScheduleList(year, month);
					});
					
					$(".fc-next-button").one().click(function() {
						if(++month == 13) {
							month = 1;
							year++;
						}
						
						showScheduleList(year, month);
					});
					
					$(".fc-today-button").one().click(function() {
						year = thisYear;
						month = thisMonth;
		
						showScheduleList(year, month);
					});
					
					$(".add-schedule-btn").click(function() {
						$("#addScheduleModal").modal("show");
					});
								
					$(".add-schedule-form, .update-schedule-form").unbind().on("submit", function() {
						var startDay = $(this).find("input[name='startDay']").val();
						var endDay = $(this).find("input[name='endDay']").val();
						
						if(startDay > endDay) {
							event.preventDefault();
							alert("종료날짜는 시작날짜 이후이거나 같아야 합니다.");
						}
					});
					
					function init() {
						// 일정 수정/삭제 모달 팝업
						$(".schedule-event").click(function() {
							var scheno = $(this).data("scheno");
							var startDay = $(this).data("startday");
							var endDay = $(this).data("endday");
							var content = $(this).data("content");
							
							$("#updateScheduleModal").find("input[name='scheno']").val(scheno);
							$("#updateScheduleModal").find("input[name='startDay']").val(startDay);
							$("#updateScheduleModal").find("input[name='endDay']").val(endDay);
							$("#updateScheduleModal").find("input[name='content']").val(content);
							
							$("#updateScheduleModal").modal("show");
						});
						
						// 삭제버튼 클릭시 이벤트
						$(".delete-schedule-btn").off().click(function() {
							var scheno = $(this).next().next().val();
							var url = "${pageContext.request.contextPath}/schedule/delete?scheno=" + scheno;
							if(confirm("정말로 삭제하시겠습니까?")) {
								$.ajax({
									type: "post",
									url: url,
									beforeSend: function(xhr) {
										xhr.setRequestHeader(csrf, csrfToken);
									},
									complete: function(result) {
										alert("삭제되었습니다.");
										window.location.href = "${pageContext.request.contextPath}/admin/index";
									}
								});
							}
						});
					}
		            
					function showScheduleList(year, month) {
						
						$(".calendar-title").text(year + "년 " + (month) + "월");
						var url = "${pageContext.request.contextPath}/schedule/get";
		
						$.getJSON(url, {
							year: year,
							month: month
						}, function(resultArr) {
							var str = "";
							console.log(resultArr);
							if(resultArr != null) {
								for(var i in resultArr) {
									var obj = resultArr[i];
									str += '<div class="calendar-events mb-3 ui-draggable ui-draggable-handle schedule-event" data-class="bg-secondary" style="position: relative;" data-scheno="' + obj.scheno + '" data-startDay="' + obj.startDay + '" data-endDay="' + obj.endDay + '" data-content="' + obj.content + '">';
									str += '	<i class="fa fa-circle text-secondary mr-2"></i>' + obj.startDay + ' ~ ' + obj.endDay;
			                    	str += '	<p>' + obj.content + '</p>';
			                    	str += '</div>';
								}
								$(".monthly-schedule-list").html(str);
							}
							init();
						});
					}
				});
				</script>