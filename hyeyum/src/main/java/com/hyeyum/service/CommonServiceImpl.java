package com.hyeyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.ScheduleCategory;
import com.hyeyum.domain.ScheduleVO;
import com.hyeyum.mapper.MemberMapper;
import com.hyeyum.mapper.ScheduleMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * CommonService를 구현한 클래스
 * @author 전민우
 * @since 21/05/28
 */
@Service
@AllArgsConstructor
@Log4j
public class CommonServiceImpl implements CommonService {
	private ScheduleMapper scheduleMapper;
	private MemberMapper memberMapper;
	@Autowired @Qualifier("BCryptPasswordEncoder")
	private PasswordEncoder encoder;
	
	/**
	 * 특정 학사일정을 상세조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public ScheduleVO getSchedule(Long scheno) {
		log.info("getSchedule...");
		return scheduleMapper.read(scheno);
	}
	
	/**
	 * 카테고리에 해당하는 특정 학사일정 목록을 조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public List<ScheduleVO> getScheduleList(ScheduleCategory category) {
		log.info("getScheduleList...");
		return scheduleMapper.getList(category);
	}
	
	/**
	 * 학사일정을 추가하는 메서드
	 * @author 전민우
	 */
	@Override
	public int insertSchedule(ScheduleVO scheduleVO) {
		log.info("insertSchedule...");
		return scheduleMapper.insert(scheduleVO);
	}

	/**
	 * 학사일정을 수정하는 메서드
	 * @author 전민우
	 */
	@Override
	public int updateSchedule(ScheduleVO scheduleVO) {
		log.info("updateSchedule...");
		return scheduleMapper.update(scheduleVO);
	}

	/**
	 * 학사일정을 삭제하는 메서드
	 * @author 전민우
	 */
	@Override
	public int deleteSchedule(ScheduleVO scheduleVO) {
		log.info("deleteSchedule...");
		return scheduleMapper.delete(scheduleVO);
	}
	
	/**
	 * 학생 및 교수 계정의 비밀번호를 변경하는 메서드
	 * @author 전민우
	 */
	@Override
	public int updateAccount(MemberVO memberVO) {
		log.info("updateAccount...");
		
		memberVO.setUserpw(encoder.encode(memberVO.getUserpw()));
		
		return memberMapper.update(memberVO);
	}
	
}
