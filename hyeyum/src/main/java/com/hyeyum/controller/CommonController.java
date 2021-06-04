package com.hyeyum.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.ScheduleVO;
import com.hyeyum.service.CommonService;
import com.hyeyum.service.ProferssorInfoService;
import com.hyeyum.service.StudentInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class CommonController {
	private CommonService commonService;
	private JavaMailSender mailSender;
	private StudentInfoService studentInfoService;
	private ProferssorInfoService professorInfoService;
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("accessDenied .... " + auth);
		model.addAttribute("msg", "Acess Denied( 접근거부)");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error :: "+ error);
		log.info("logout :: "+ logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error check your account");
		}
		if(logout != null) {
			model.addAttribute("logout", "logout sss");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGet() {
		log.info("logout.........");
	}
	
	@PostMapping("/customLogout")
	public void logoutPost(HttpServletRequest req) {
		log.warn(" post  logout.........");
		log.warn(req.getHeader("referer"));
	}
	
	/**
	 * DB로부터 해당 카테고리의 학사일정 목록을 가져오는 메서드
	 * @author 전민우
	 */
	@GetMapping("schedule/get")
	@PreAuthorize("isAuthenticated()")
	@ResponseBody
	public List<ScheduleVO> getScheduleList(ScheduleCategory category) {
		log.info("getScheduleList...");
		
		return commonService.getScheduleList(category);
	}
	
	/**
	 * DB에 학사일정을 추가하는 메서드
	 * @author 전민우
	 */
	@PostMapping("schedule/add")
	@Secured("ROLE_ADMIN")
	public String addSchedule(ScheduleVO scheduleVO, RedirectAttributes rttr) {
		log.info("addSchedule..." + scheduleVO);
		
		if(commonService.insertSchedule(scheduleVO) > 0) {
			rttr.addFlashAttribute("addMsg", "success");
		} else {
			rttr.addFlashAttribute("addMsg", "fail");
		}
		
		return "redirect:../admin/index";
	}
	
	/**
	 * DB에 학사일정을 수정하는 메서드
	 * @author 전민우
	 */
	@PostMapping("schedule/update")
	@Secured("ROLE_ADMIN")
	public String updateSchedule(ScheduleVO scheduleVO, RedirectAttributes rttr) {
		log.info("addSchedule..." + scheduleVO);
		
		if(commonService.updateSchedule(scheduleVO) > 0) {
			rttr.addFlashAttribute("updateMsg", "success");
		} else {
			rttr.addFlashAttribute("updateMsg", "fail");
		}
		
		return "redirect:../admin/index";
	}
	
	/**
	 * DB에 학사일정을 삭제하는 메서드
	 * @author 전민우
	 */
	@PostMapping("schedule/delete")
	@Secured("ROLE_ADMIN")
	public String deleteSchedule(ScheduleVO scheduleVO, RedirectAttributes rttr) {
		log.info("addSchedule..." + scheduleVO);
		
		if(commonService.deleteSchedule(scheduleVO) > 0) {
			rttr.addFlashAttribute("deleteMsg", "success");
		} else {
			rttr.addFlashAttribute("deleteMsg", "fail");
		}
		
		return "redirect:../admin/index";
	}
	
	@GetMapping("verify/{user}/{userid}/{email:.+}")
	@ResponseBody
	public String verifyUserId(@PathVariable("user") String user, @PathVariable("userid") String userid, @PathVariable("email") String email) {
		log.info("verifyUserId..." + user + "/" + userid + "/" + email);
		
		// 학생 또는 교직원의 이메일주소와 일치하지 않으면 에러메세지 반환로직
		if((user.equals("student") && studentInfoService.get(Long.parseLong(userid)) == null) ||
		   (user.equals("student") && studentInfoService.get(Long.parseLong(userid)).getEmail() == null) ||
		   (user.equals("student") && !studentInfoService.get(Long.parseLong(userid)).getEmail().equals(email))) {
			return null;
		} else if((user.equals("professor") && professorInfoService.getProInfo(userid) == null) ||
				  (user.equals("professor") && professorInfoService.getProInfo(userid).getEmail() == null) ||
				  (user.equals("professor") && !professorInfoService.getProInfo(userid).getEmail().equals(email))) {
			return null;
		}
		
		// 인증번호 생성
		Integer number = (int)(Math.random() * 899999) + 100001;
		log.info("verification number..." + number);
		
        // 전송 내용 설정
        String setFrom = "hyeyumverify@gmail.com";
        String toMail = email;
        String title = "혜윰대학교 비밀번호 찾기 인증 이메일입니다.";
        String content = 
                "인증 번호는 " + number + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 입력해주세요.";
        
        // 이메일 전송
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
            log.info("sending email complete...");
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return number.toString();
	}
	
	@PostMapping("updateAccount")
	public String updateAccount(MemberVO memberVO, RedirectAttributes rttr) {
		log.info("updateAccount..." + memberVO.getUserid() + "/" + memberVO.getUserpw());
		
		if(commonService.updateAccount(memberVO) > 0) {
			rttr.addFlashAttribute("modifyMsg", "success");
		} else {
			rttr.addFlashAttribute("modifyMsg", "fail");
		}
		
		return "redirect:/customLogin";
	}

}
