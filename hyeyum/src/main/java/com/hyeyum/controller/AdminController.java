package com.hyeyum.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hyeyum.domain.CourseAttachVO;
import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.CurriculumVO;
import com.hyeyum.domain.ProfessorVO;
import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.StatusCategory;
import com.hyeyum.domain.StudStatusVO;
import com.hyeyum.domain.StudentCategory;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.service.AdminCourseService;
import com.hyeyum.service.AdminCurriculumService;
import com.hyeyum.service.AdminEstablishService;
import com.hyeyum.service.AdminHRService;
import com.hyeyum.service.AdminStatusService;
import com.hyeyum.service.CommonService;
import com.hyeyum.service.CountService;
import com.hyeyum.service.ProferssorCourseService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


/**
 * 강의 객체 정보
 * @author 강영훈, 박수연
 * @since 2021/05/24
 */
@Log4j
@Controller
@RequestMapping("/admin/*")
@AllArgsConstructor
public class AdminController {
	
	private AdminHRService adminHRService;
	
	private AdminEstablishService adminEstablishService;
	
	private AdminCourseService adminCourseService;
	
	private AdminCurriculumService adminCurriculumService;
	
	private AdminStatusService adminStatusService;
	
	private CountService countService;
	
	private CommonService commonService;
	
	private ProferssorCourseService professorCourseService;
	
	@GetMapping("index")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void index(ScheduleCategory category, Model model) {
		log.info("admin main....");
		
		Calendar cal = Calendar.getInstance();
		
		category.setYear(cal.get(Calendar.YEAR));
		category.setMonth(cal.get(Calendar.MONTH)+1);
		
		model.addAttribute("studcount", countService.getStudCnt());
		model.addAttribute("profcount", countService.getProfCnt());
		model.addAttribute("statuscount", countService.getStatusCnt());
		model.addAttribute("courscount", countService.getCourseCnt());
		model.addAttribute("category", category);
		model.addAttribute("totalScheduleList", commonService.getScheduleList(new ScheduleCategory()));
		model.addAttribute("scheduleList", commonService.getScheduleList(category));
	}
	
	/**
	 * DB에 등록되어 있는 교수들의 목록을 서비스로 부터 받아오는 겟 매핑 메서드 
	 * @author 박수연
	 */
	@GetMapping("professorlist")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void professorlist(Model model) {
		log.info("professorlist....");
		model.addAttribute("list", adminHRService.getProfessorList());
	}
	
	/**
	 * DB에 등록되어 있는 교수의 상세정보를 서비스로 부터 받아오는 겟 매핑 메서드 
	 * @author 박수연
	 */
	@GetMapping("getprofessor")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void getProfessor(String profno, Model model) {
		log.info("getprofessor....");
		model.addAttribute("professor", adminHRService.getProfessor(profno));
	}
	
	/**
	 * 새로운 교수를 DB에 등록하기 위한 폼이있는 뷰페이지 겟 매핑 메서드 
	 * @author 박수연
	 */
	@GetMapping("registerprofessor")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerprofessor() {
		log.info("registerprofessor....");
	}
	
	/**
	 * 입력받은 교수정보를 등록하는 메서드  
	 * @author 박수연
	 */
	@PostMapping("registerprofessor")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String registerprofessor(ProfessorVO professorVO, RedirectAttributes rttr) {
		log.info("registerprofessor....");
		
		if(adminHRService.addProfessor(professorVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else{
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*log.info(professorVO);
		adminHRService.addProfessor(professorVO);
		rttr.addFlashAttribute("result", professorVO.getProfno());*/
		
		return "redirect:/admin/professorlist";
	}
	
	/**
	 * 교수의 인적정보를 수정하는 메서드  
	 * @author 박수연
	 */
	@PostMapping("getprofessor")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updateProfessor(ProfessorVO professorVO, RedirectAttributes rttr) {
		log.info("update Professor....");
		if(adminHRService.updateProfessor(professorVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		return "redirect:/admin/getprofessor?profno="+professorVO.getProfno();
	}
	
	/**
	 * 교수의 인적정보를 삭제하는 메서드 
	 * @author 박수연
	 */
	@PostMapping("deleteprofessor")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteprofessor(Long profno, RedirectAttributes rttr) {
		log.info("delete professor....");
		
		if(adminHRService.deleteProfessor(profno)>0){
			rttr.addFlashAttribute("result","success");
		}else {
			rttr.addFlashAttribute("result","fail");
		}
		
		/*adminHRService.deleteProfessor(profno);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/professorlist";
	}
	
	/**
	 * DB에 등록되어 있는 학생들의 목록을 서비스로 부터 받아오는 겟 매핑 메서드 
	 * @author 강영훈
	 */
	@GetMapping("studentlist")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void studentlist(StudentCategory studentCategory, Model model) {
		log.info("studentlist....");
		model.addAttribute("list", adminHRService.getStudentList(studentCategory));
	}
	
	/**
	 * DB에 등록되어 있는 학생의 상세정보를 서비스로 부터 받아오는 겟 매핑 메서드 
	 * @author 강영훈
	 */
	@GetMapping("getstudent")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void getStudent(Long studno, Model model) {
		log.info("get student....");
		model.addAttribute("student", adminHRService.getStudent(studno));
	}
	
	/**
	 * 학생의 인적정보를 수정하는 메서드  
	 * @author 강영훈
	 */
	@PostMapping("getstudent")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updateStudent(StudentVO studentVO, RedirectAttributes rttr) {
		log.info("update Student....");
		if(adminHRService.updateStudent(studentVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*adminHRService.updateStudent(studentVO);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/getstudent?studno="+studentVO.getStudno();
	}
	
	/**
	 * 학생의 인적정보를 삭제하는 메서드  
	 * @author 강영훈
	 */
	@PostMapping("deletestudent")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteStudent(Long studno, RedirectAttributes rttr) {
		log.info("delete Student....");
		
		if(adminHRService.deleteStudent(studno)>0){
			rttr.addFlashAttribute("result","success");
		}else {
			rttr.addFlashAttribute("result","fail");
		}
		
		/*adminHRService.deleteStudent(studno);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/studentlist";
	}
	
	
	/**
	 * 새로운 학생을 DB에 등록하기 위한 폼이있는 뷰페이지 겟 매핑 메서드
	 * @author 강영훈
	 */
	@GetMapping("registerstudent")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerstudent() {
		log.info("registerstudent....");
	}
	
	/**
	 * 입력받은 학생정보를 등록하는 메서드
	 * @author 강영훈
	 */
	@PostMapping("registerstudent")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String registerstudent(StudentVO studentVO, RedirectAttributes rttr){
		log.info("Controller student register....");
		
		if(adminHRService.addStudent(studentVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*log.info(studentVO);
		adminHRService.addStudent(studentVO);
		rttr.addFlashAttribute("result", studentVO.getStudno());*/
		
		return "redirect:/admin/studentlist";
	}
	
	/**
	 * 개설승인이 되지않은 강의들의 목록을 받아 오는 메서드
	 * @author 강영훈
	 */
	@GetMapping("managementopencourse")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void managementopencourse(Model model) {
		log.info("managementopencourse....");
		CourseCategory category = new CourseCategory();
		category.setEnable(false);
		model.addAttribute("list", adminEstablishService.getList(category));
	}
	
	/**
	 * 개설승인이 되지않은 강의를 개설승인 해주는 메서드
	 * @author 강영훈
	 */
	@PostMapping("managementopencourse")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String enableUpdate(CourseVO courseVO, RedirectAttributes rttr) {
		log.info("enableUpdate....");
		
		if(adminEstablishService.approveCourse(courseVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*adminEstablishService.approveCourse(courseVO);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/managementopencourse";
	}
	
	/**
	 * 개설된 강의들의 목록을 받아 오는 메서드
	 * @author 박수연
	 */
	@GetMapping("managementcourse")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void managementcourse(CourseCategory category, Model model) {
		log.info("managementcourse....");
		category.setEnable(true);
		model.addAttribute("list", adminCourseService.getCourseList(category));
	}
	
	/**
	 * 개설된 강의의 상세정보을 받아 오는 메서드
	 * @author 박수연
	 */
	@GetMapping("getmanagementcourse")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void getmanagementcourse(CourseCategory category, Model model) {
		log.info("get managementcourse.....");
		
		CourseVO courseVO = adminCourseService.getCourse(category);
		
		model.addAttribute("course", courseVO);
		model.addAttribute("location", professorCourseService.getLocationList(courseVO.getDeptno()));
	}
	
	/**
	 * 개설된 강의의 정보을 수정하는 메서드
	 * @author 박수연
	 */
	@PostMapping("updatecourse")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updatecourse(CourseVO courseVO, RedirectAttributes rttr) {
		log.info("update Course....");
		
		if(adminCourseService.updateCourse(courseVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*adminCourseService.updateCourse(courseVO);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/getmanagementcourse?coursno="+courseVO.getCoursno();
	}
	
	/**
	 * 강의를 삭제하는 메서드
	 * @author 박수연
	 */
	@PostMapping("deletecourse")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deletecourse(String coursno, RedirectAttributes rttr) {
		log.info("delete Course....");
		
		if(adminCourseService.deleteCourse(coursno)>0){
			rttr.addFlashAttribute("result","success");
		}else {
			rttr.addFlashAttribute("result","fail");
		}
		
		/*adminCourseService.deleteCourse(coursno);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/managementcourse";
	}
	
	/**
	 * 학적변동 신청 목록을 조회하는 메서드
	 * @author 강영훈
	 */
	@GetMapping("managementstatus")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void managementstatus(StatusCategory category, Model model) {
		log.info("managementstatus...."+ category);
		model.addAttribute("list", adminStatusService.getStatusList(category));
	}
	
	/**
	 * 학적변동 신청을 승인하는 메서드
	 * @author 강영훈
	 */
	@PostMapping("approvestatus")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String approveStatus(StudStatusVO studStatusVO, RedirectAttributes rttr){
		log.info("approve Ststus...");
		
		if(adminStatusService.updateStatus(studStatusVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*adminStatusService.updateStatus(studStatusVO);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/managementstatus";
	}
	
	
	/**
	 * 교육과정목록을 받아오는 메서드
	 * @author 강영훈
	 */
	@GetMapping("curriculum")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void curriculum(Model model) {
		log.info("curriculum....");
		model.addAttribute("list", adminCurriculumService.getList());
	}
	
	/**
	 * 교육과정정보를 상세조회 하는 메서드
	 * @author 강영훈
	 */
	@GetMapping("getcurriculum")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void getCurriculum(String coursno, Model model) {
		log.info("curriculum....");
		model.addAttribute("curriculum", adminCurriculumService.get(coursno));
	}
	
	
	/**
	 * 교육과정을 등록 하는 메서드
	 * @author 강영훈
	 */
	@PostMapping("registercurriculum")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String registerCurriculum(CurriculumVO curriculumVO, RedirectAttributes rttr) {
		log.info("update Course....");
		
		if(adminCurriculumService.addCurriculum(curriculumVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*adminCurriculumService.addCurriculum(curriculumVO);
		rttr.addFlashAttribute("result", "success");*/
		return "redirect:/admin/curriculum";
	}
	
	/**
	 * 교육과정정보를 수정 하는 메서드
	 * @author 강영훈
	 */
	@PostMapping("updatecurriculum")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updateCurriculum(CurriculumVO curriculumVO, RedirectAttributes rttr) {
		log.info("update Course....");
		
		if(adminCurriculumService.updateCurriculum(curriculumVO)>0){
			rttr.addFlashAttribute("msg","success");
		}else {
			rttr.addFlashAttribute("msg","fail");
		}
		
		/*adminCurriculumService.updateCurriculum(curriculumVO);
		rttr.addFlashAttribute("result", "success");*/
		return "redirect:/admin/getcurriculum?coursno="+curriculumVO.getCoursno();
	}
	
	/**
	 * 교육과정정보를 삭제 하는 메서드
	 * @author 강영훈
	 */
	@PostMapping("deletecurriculum")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteCurriculum(String coursno, RedirectAttributes rttr) {
		log.info("delete Course....");
		
		if(adminCurriculumService.deleteCurriculum(coursno)>0){
			rttr.addFlashAttribute("result","success");
		}else {
			rttr.addFlashAttribute("result","fail");
		}
		
		/*adminCurriculumService.deleteCurriculum(coursno);
		rttr.addFlashAttribute("result", "success");*/
		
		return "redirect:/admin/curriculum";
	}
	
	@ResponseBody
	@GetMapping("getAttachList")
	public List<CourseAttachVO> getAttachList(Long coursno) {
		log.info("getAttachList...");
		return adminCourseService.getAttachList(coursno);
	}
	
	@GetMapping("tuitionlist")
	
	public void tuitionlist() {
		log.info("tuitionlist....");
	}
	@GetMapping("scholarship")
	public void scholarship() {
		log.info("scholarship....");
	}
	@GetMapping("scholarshiplist")
	public void scholarshiplist() {
		log.info("scholarshiplist....");
	}
	@GetMapping("salary")
	public void salary() {
		log.info("salary....");
	}
	@GetMapping("salarylist")
	public void salarylist() {
		log.info("salarylist....");
	}
	
}
