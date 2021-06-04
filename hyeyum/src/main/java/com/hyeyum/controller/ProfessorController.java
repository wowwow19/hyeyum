package com.hyeyum.controller;

import java.security.Principal;
import java.util.Calendar;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hyeyum.domain.CorrectionCategory;
import com.hyeyum.domain.CorrectionVO;
import com.hyeyum.domain.CounselVO;
import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.ProfessorVO;
import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.SugangVO;
import com.hyeyum.service.AdminHRService;
import com.hyeyum.service.CommonService;
import com.hyeyum.service.CountService;
import com.hyeyum.service.ProferssorCourseService;
import com.hyeyum.service.ProferssorInfoService;
import com.hyeyum.service.StudentCourseService;
import com.hyeyum.service.StudentManagementService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 교수 계정으로 로그인 시의 기능을 제어하는 컨트롤러
 * @author 오승현
 * @since 2021/05/24
 */

@Log4j
@Controller
@RequestMapping("/professor/*")
@AllArgsConstructor
public class ProfessorController {
	
	private ProferssorInfoService proferssorInfoService;
	private AdminHRService adminHRService;
	private ProferssorCourseService proferssorCourseService;
	private StudentManagementService studentManagementService;
	private CountService countService;
	private CommonService commonService;
	
	@GetMapping("index")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void list(ScheduleCategory category, Model model, Principal principal) {
		log.info("professor main....");
		
		Calendar cal = Calendar.getInstance();
		
		category.setYear(cal.get(Calendar.YEAR));
		category.setMonth(cal.get(Calendar.MONTH)+1);
		
		model.addAttribute("chargestud", countService.getChargeStudCnt(principal.getName()));
		model.addAttribute("chargecourse", countService.getChargeCourseCnt(principal.getName()));
		model.addAttribute("corrcnt", countService.getCorrCnt(principal.getName()));
		model.addAttribute("category", category);
		model.addAttribute("totalScheduleList", commonService.getScheduleList(new ScheduleCategory()));
		model.addAttribute("scheduleList", commonService.getScheduleList(category));
	}
	
	/**
	 * 로그인시 자신의 개인신상정보관리페이지를 보여주는 메서드
	 * @author 오승현
	 */
	@PostMapping("info")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String info(@ModelAttribute ProfessorVO professorVO, RedirectAttributes rttr) {
		
		log.info("infoupdate......." + professorVO.getProfno());
		proferssorInfoService.updateProfInfo(professorVO);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/professor/info?profno="+professorVO.getProfno();
		
	}
	
	@GetMapping("info")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void info(String profno, Model model) {
		log.info("info....");
		model.addAttribute("professor", adminHRService.getProfessor(profno));
		log.info(adminHRService.getProfessor(profno));
	}
	
	/**
	 * 강의개설신청을 보여주는 메서드
	 * @author 오승현
	 */
	@PostMapping("registercourse")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String registercourse(CourseVO courseVO, RedirectAttributes rttr) {
		log.info("registercourse.......");
		log.info(courseVO);
		
		// 수정요청결과에 대한 메세지를 리다이렉트 페이지로 전송
		if(proferssorCourseService.addCourse(courseVO) > 0) {
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		return "redirect:../professor/registercourse";
	}
	
	@GetMapping("registercourse")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void registercourse(Principal principal, Model model) {
		log.info("registercourse....");
		
		ProfessorVO professor = proferssorInfoService.getProInfo(principal.getName());
		
		model.addAttribute("professor", professor);
		model.addAttribute("current", proferssorCourseService.getCurrentNo(Long.parseLong(professor.getDeptno())));
		model.addAttribute("location", proferssorCourseService.getLocationList(Long.parseLong(professor.getDeptno())));
	}
	
	/**
	 * 강의현황조회를 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("courselist")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void courselist(Principal principal, CourseCategory category, Model model) {
		log.info("courselist....");
		category.setEnable(true);
		category.setProfno(Long.parseLong(principal.getName()));
		
		model.addAttribute("list", proferssorCourseService.getList(category));
	}
	
	/**
	 * 교수의 담당학생조회를 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("studentlist")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void studentlist(StudentCategory studentCategory, Model model) {
		log.info("studentlist....");
		model.addAttribute("list", adminHRService.getStudentList(studentCategory));
	}
	
	/**
	 * 교수의 담당학생에 대한 상담을 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("counsel")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void counsel() {
		log.info("counsel....");
	}
	
	@PostMapping("counsel")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String counsel(CounselVO counselVO, RedirectAttributes rttr) {
		log.info("counsellist.......");
		if(studentManagementService.getwriCounsel(counselVO) > 0)
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/professor/counsellist?studno="+counselVO.getStudno();
	}
	
	/**
	 * 교수의 담당학생에 대한 상담리스트를 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("counsellist")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void counsellist(Long studno, Model model) {
		log.info("counsellist....");
		model.addAttribute("list", studentManagementService.getCounselList(studno));
	}
	
	/**
	 * 교수의 담당수업리스트를 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("registergrade")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void registergrade(CourseCategory courseCategory, Model model) {
		log.info("registergrade....");
		/*courseCategory.setProfno(2111104L);*/
		model.addAttribute("list", proferssorCourseService.getList(courseCategory));
	}
	
	/**
	 * 교수의 담당수업의 학생들의 정보와 성적을 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("registergradelist")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void registergradelist(Long coursno, Model model) {
		log.info("registergradelist....");
		
		model.addAttribute("list", studentManagementService.getSugangList(coursno));
	}
	
	@PostMapping("insertgrade")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String insertGrade(SugangVO sugangVO, RedirectAttributes rttr) {
		log.info("insertGrade....");
		if(studentManagementService.insertGrade(sugangVO) > 0)
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/professor/registergradelist?coursno="+sugangVO.getCoursno();
	}
	
	/**
	 * 교수의 학생들의 성적이의 신청을 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("correctionlist")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void correctionlist(CorrectionCategory correctionCategory, Model model) {
		log.info("correctionlist....");
		model.addAttribute("list", studentManagementService.getCorrectionList(correctionCategory));
	}
	
	/**
	 * 교수의 학생들의 성적이의 상세정보를 보여주는 메서드
	 * @author 오승현
	 */
	@GetMapping("correction")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void correction(Long corrno, Long studno, Long coursno, Model model) {
		log.info("correctionlist....");
		model.addAttribute("correction", studentManagementService.getCorrection(corrno));
		model.addAttribute("sugang", studentManagementService.getSugang(studno, coursno));
	}
	@PostMapping("correction")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String correction(SugangVO sugangVO, CorrectionVO correctionVO, RedirectAttributes rttr) {
		log.info("correction....");
		correctionVO.setCorrStatus(1);
		if(studentManagementService.updateGrade(sugangVO, correctionVO) > 0)
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/professor/correction?corrno="+correctionVO.getCorrno()+"&studno="+correctionVO.getStudno()+"&coursno="+sugangVO.getCoursno();
	}
	
	/**
	 * 교수의 학생들의 성적이의 상세정보를 승인해주는 메서드
	 * @author 오승현
	 */
	@PostMapping("updategrade")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String updateGrade(CorrectionVO correctionVO, SugangVO sugangVO, RedirectAttributes rttr) {
		log.info("updateGrade....");
		correctionVO.setCorrStatus(1);
		studentManagementService.updateGrade(sugangVO, correctionVO);
		rttr.addAttribute("result", "success");
		return "redirect:/professor/correction?corrno="+correctionVO.getCorrno()+"&studno="+correctionVO.getStudno()+"&coursno="+sugangVO.getCoursno();
	}
	
	/**
	 * 교수의 학생들의 성적이의 상세정보를 거부하는 메서드
	 * @author 오승현
	 */
	@PostMapping("deny")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public String deny(CorrectionVO correctionVO, SugangVO sugangVO, RedirectAttributes rttr) {
		log.info("deny....");
		correctionVO.setCorrStatus(2);
		studentManagementService.updateGrade(sugangVO, correctionVO);
		rttr.addAttribute("result", "success");
		return "redirect:/professor/correction?corrno="+correctionVO.getCorrno()+"&studno="+correctionVO.getStudno()+"&coursno="+sugangVO.getCoursno();
	}
	
	@GetMapping("salarylist")
	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	public void salarylist() {
		log.info("salarylist....");
	}
}
