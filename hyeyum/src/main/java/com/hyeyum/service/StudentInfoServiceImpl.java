package com.hyeyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.StudentVO;
import com.hyeyum.mapper.StudentMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * StudentInfoService를 구현한 클래스
 * @author 전민우
 * @since 21/05/20
 */
@Service
@AllArgsConstructor
@Log4j
public class StudentInfoServiceImpl implements StudentInfoService {
	private StudentMapper studentMapper;
	@Autowired @Qualifier("BCryptPasswordEncoder")
	private PasswordEncoder encoder;

	
	/**
	 * 학번을 이용하여 단일 학생의 데이터를 조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public StudentVO get(Long studno) {
		log.info("get...");
		return studentMapper.read(studno);
	}
	
	/**
	 * 학생의 신상정보 및 비밀번호를 수정하는 메서드
	 * @author 전민우
	 */
	@Override
	@Transactional
	public int update(StudentVO studentVO) {
		log.info("update...");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid(studentVO.getStudno().toString());
		memberVO.setUserpw(encoder.encode(studentVO.getPassword()));
		
		int cnt = 0;
		
		if(studentMapper.updateInfo(studentVO) > 0) {
			cnt++;
		}
		if(studentMapper.updatePassword(memberVO) > 0) {
			cnt++;
		}
		
		return cnt;
	}
}
