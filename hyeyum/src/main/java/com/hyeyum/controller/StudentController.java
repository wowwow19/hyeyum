package com.hyeyum.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;
import com.hyeyum.domain.SugangVO;
import com.hyeyum.service.CommonService;
import com.hyeyum.service.StudentCourseService;
import com.hyeyum.service.StudentGradeService;
import com.hyeyum.service.StudentInfoService;
import com.hyeyum.service.StudentStatusService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 학생 계정으로 로그인 시의 기능을 제어하는 컨트롤러
 * @author 전민우
 * @since 2021/05/18
 */
@Log4j
@Controller
@RequestMapping("student/*")
@AllArgsConstructor
public class StudentController {
	private StudentCourseService courseService;
	private StudentInfoService infoService;
	private StudentGradeService gradeService;
	private StudentStatusService statusService;
	private CommonService commonService;
	
	/**
	 * 학생으로 로그인했을 때의 메인화면을 보여주는 메서드
	 * @author 전민우
	 */
	@GetMapping("index")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void list(Principal principal, ScheduleCategory category, Model model) {
		log.info("student main....");
		
		Long studno = Long.parseLong(principal.getName());
		StatusCategory statusCategory = new StatusCategory();
		CorrectionCategory correctionCategory = new CorrectionCategory();
		Calendar cal = Calendar.getInstance();
		
		category.setYear(cal.get(Calendar.YEAR));
		category.setMonth(cal.get(Calendar.MONTH)+1);
		statusCategory.setStudno(studno);
		correctionCategory.setStudno(studno);
		
		model.addAttribute("category", category);
		model.addAttribute("totalScheduleList", commonService.getScheduleList(new ScheduleCategory()));
		model.addAttribute("scheduleList", commonService.getScheduleList(category));
		model.addAttribute("sugangNum", courseService.getConfirmedSugangList(studno).size());
		model.addAttribute("credit", gradeService.getCredit(studno));
		model.addAttribute("status", statusService.getList(statusCategory).stream().filter(vo -> vo.getReStatus() == false).collect(Collectors.toList()));
		model.addAttribute("correction", gradeService.getCorrectionList(correctionCategory).stream().filter(vo -> vo.getCorrStatus() == 1).collect(Collectors.toList()));
	}
		
	/**
	 * 로그인시 자신의 개인신상정보관리페이지를 보여주는 메서드
	 * @author 이찬희
	 */
	@GetMapping("info")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void info(Principal principal, Model model) {
		log.info("info....");
		
		Long studno = Long.parseLong(principal.getName()); 
		
		model.addAttribute("student", infoService.get(studno));
	}
	
	/**
	 * 개인신상정보관리 페이지에서 수정된 정보를 받아와 DB에 반영하는 메서드
	 * @author 전민우
	 */
	@PostMapping("info/update")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public String updateInfo(StudentVO studentVO, RedirectAttributes rttr) {
		log.info("updateInfo....");
		
		// 수정요청결과에 대한 메세지를 리다이렉트 페이지로 전송
		if(infoService.update(studentVO) > 1) {
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:../info";
	}
	
	/**
	 * DB에서 데이터를 받아와 학적변동이력의 목록을 보여주는 메서드
	 * @author 전민우
	 */
	@GetMapping("statuslist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void statuslist(StatusCategory category, Principal principal, Model model) {
		log.info("statuslist....");
		
		// 현재 로그인된 학생의 학번을 담음
		category.setStudno(Long.parseLong(principal.getName()));

		model.addAttribute("list", statusService.getList(category));
	}
	
	/**
	 * DB에서 데이터를 받아와 학적변동이력의 목록과 휴복학 신청화면을 보여주는 메서드
	 * @author 전민우
	 */
	@GetMapping("status")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void getStatus(Principal principal, Model model) {
		log.info("getStatus...");
		
		// 현재 로그인된 학생의 학번을 담음
		Long studno = Long.parseLong(principal.getName());
		StatusCategory category = new StatusCategory();
		category.setStudno(studno);
		
		model.addAttribute("user", infoService.get(studno));
		model.addAttribute("list", statusService.getList(category));
	}
	
	/**
	 * 휴복학신청 페이지에서 입력된 신청정보를 받아와 DB에 반영하는 메서드
	 * @author 전민우
	 */
	@PostMapping("status/request")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public String requestStatus(StudStatusVO studStatusVO, RedirectAttributes rttr) {
		log.info("requestStatus....");
		
		// 신청요청결과에 대한 메세지를 리다이렉트 페이지로 전송
		if(statusService.insert(studStatusVO) > 0) {
			rttr.addFlashAttribute("reqErrMsg", "success");
		} else {
			rttr.addFlashAttribute("reqErrMsg", "fail");
		};
		
		return "redirect:../status";
	}
	
	/**
	 * 휴복학신청 페이지에서 받아온 신청내역의 취소요청을 DB에 반영하는 메서드
	 * @author 전민우
	 */
	@PostMapping("status/cancel")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public String cancelStatus(StudStatusVO studStatusVO, RedirectAttributes rttr) {
		log.info("cancelStatus....");
		
		// 취소요청결과에 대한 메세지를 리다이렉트 페이지로 전송
		if(statusService.delete(studStatusVO) > 0) {
			rttr.addFlashAttribute("canErrMsg", "success");
		} else {
			rttr.addFlashAttribute("canErrMsg", "fail");
		};
		
		return "redirect:../status";
	}
	
	/**
	 * DB에서 데이터를 받아와 개설된 강의의 목록을 보여주는 메서드
	 * @author 전민우
	 */
	@GetMapping("courselist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void courselist(CourseCategory category, Model model) {
		log.info("courselist....");
		
		// 현재 개설승인된 강의만을 보여줌
		category.setEnable(true);
		
		model.addAttribute("list", courseService.getCourseList(category));
	}
	
	/**
	 * DB에서 데이터를 받아와 개설된 강의의 목록과 수강신청화면을 보여주는 메서드
	 * @author 전민우
	 */
	@GetMapping("sugang")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void sugang(CourseCategory category, Principal principal, Model model) {
		log.info("sugang....");
		
		// 현재 로그인된 학생의 학번을 담음
		Long studno = Long.parseLong(principal.getName());
		
		List<CourseVO> sugangList = new ArrayList<>();
		CourseCategory category2 = new CourseCategory();
		
		// 수강신청내역 중에서 아직 확정되지 않은 장바구니 목록을 가져옴
		for(SugangVO vo : courseService.getSugangList(studno)) {
			category2.setCoursno(vo.getCoursno());
			if(!vo.getStatus()) sugangList.add(courseService.get(category2));
		}		
		
		model.addAttribute("student", infoService.get(studno));
		model.addAttribute("list", courseService.getCourseList(category));
		model.addAttribute("sugangList", sugangList);
		model.addAttribute("timeTable", courseService.getTimeTable(studno, false));
	}
	
	/**
	 * 수강신청 페이지에서 받아온 장바구니 담기 요청을 DB에 반영하는 메서드
	 * @author 전민우
	 */
	@PostMapping("sugang/add")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public String addSugang(@RequestBody SugangVO sugangVO) {
		log.info("addSugang...");
		
		// 담기요청결과에 대한 메세지를 ajax를 통해 전송
		if(courseService.addSugang(sugangVO) > 0) {
			log.info("addSugang success...");
			CourseCategory category = new CourseCategory();
			category.setCoursno(sugangVO.getCoursno());
			return "success";
		}
		
		log.info("addSugang fail...");
		return null;
	}
	
	/**
	 * 수강신청 페이지에서 받아온 신청내역 확정 요청을 DB에 반영하는 메서드
	 * @author 전민우
	 */
	@PostMapping("sugang/complete")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public String completeSugang(Principal principal) {
		log.info("completeSugang...");
		
		// 현재 로그인된 학생의 학번을 담음
		Long studno = Long.parseLong(principal.getName());
		
		courseService.completeSugang(studno);
		
		return "redirect:../sugang";
	}
	
	/**
	 * 수강신청 페이지에서 받아온 장바구니 제외 요청을 DB에 반영하는 메서드
	 * @author 전민우
	 */
	@PostMapping("sugang/delete")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public String deleteSugang(@RequestBody SugangVO sugangVO) {
		log.info("deleteSugang...");
		
		// 제외요청 결과에 대한 메세지를 ajax를 통해 전송
		return courseService.deleteSugang(sugangVO) > 0 ? "success" : null;
	}
	
	/**
	 * DB에서 데이터를 받아와 확정된 수강 목록을 보여주는 메서드
	 * @author 전민우
	 */
	@GetMapping("suganglist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void suganglist(Principal principal, Model model) {
		log.info("suganglist....");
		
		// 현재 로그인된 학생의 학번을 담음
		Long studno = Long.parseLong(principal.getName());
		
		model.addAttribute("list", courseService.getConfirmedSugangList(studno));
	}
	
	/**
	 * DB에서 데이터를 받아와 확정된 수강 목록에 대한 시간표를 보여주는 메서드
	 * @author 전민우
	 */
	@GetMapping("timetable")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void timetable(Principal principal, Model model) {
		log.info("timetable....");
		
		// 현재 로그인된 학생의 학번을 담음
		Long studno = Long.parseLong(principal.getName());
		StudentVO studentVO = infoService.get(studno);
		
		model.addAttribute("student", studentVO);
		model.addAttribute("timeTable", courseService.getTimeTable(studno, true));
	}
	
	/**
	 * 이수학점 조회하는 메서드
	 * @author 이찬희
	 */
	@GetMapping("creditlist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void creditlist(Principal principal, Model model) {
		log.info("creditlist....");
		Long studno = Long.parseLong(principal.getName()); 
		model.addAttribute("list",gradeService.getList(studno));
		model.addAttribute("credit",gradeService.getCredit(studno));
	}
	
	/**
	 * 성적조회 메서드
	 * @author 이찬희
	 */
	@GetMapping("gradelist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void gradelist(Principal principal, Model model) {
		log.info("gradelist....");
		Long studno = Long.parseLong(principal.getName()); 
		model.addAttribute("list",gradeService.getList(studno));
		model.addAttribute("credit",gradeService.getCredit(studno));
	}
	
	/**
	 * 성적 이의신청 조회 
	 * @author 이찬희
	 */
	@GetMapping("correction")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
    public void correction(Principal principal, Model model) {
        log.info("correction....");
        Long studno = Long.parseLong(principal.getName()); 
        model.addAttribute("student", infoService.get(studno));
        model.addAttribute("list",gradeService.getList(studno));
        model.addAttribute("credit",gradeService.getCredit(studno));
    }
	
	/**
	 * 성적 이의신청 내용 전송 메서드
	 * @author 이찬희
	 */
	@PostMapping("correction/request")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public String correction(CorrectionVO correction, RedirectAttributes rttr) {
		log.info("correction....");
		log.info(correction);
		if(gradeService.requestCorrection(correction) > 0) {
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		return "redirect:../correction";
	}
	
	/**
	 * 성적 이의신청한 내역을 조회
	 * @author 이찬희
	 */
	@GetMapping("correctionlist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void correctionlist(Principal principal, CorrectionCategory category, Model model) {
		log.info("correctionlist....");
		
        Long studno = Long.parseLong(principal.getName()); 
        category.setStudno(studno);
		model.addAttribute("list",gradeService.getCorrectionList(category));
	}
	
	@GetMapping("tuition")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void tuition() {
		log.info("tuition....");
	}
	
	@GetMapping("tuitionlist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void tuitionlist() {
		log.info("tuitionlist....");
	}
	
	@GetMapping("scholarshiplist")
	@PreAuthorize("hasRole('ROLE_STUDENT')")
	public void scholarshiplist() {
		log.info("scholarshiplist....");
	}
	
}
