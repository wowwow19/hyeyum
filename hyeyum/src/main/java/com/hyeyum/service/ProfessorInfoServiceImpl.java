package com.hyeyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.MemberVO;
import com.hyeyum.domain.ProfessorVO;
import com.hyeyum.mapper.ProfessorMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * ProfessorinfoService를 구현한 클래스
 * @author 오승현
 * @since 21 / 05 / 20
 */
@Service
@Log4j
@AllArgsConstructor
public class ProfessorInfoServiceImpl implements ProferssorInfoService{
	private ProfessorMapper professorMapper;
	@Autowired @Qualifier("BCryptPasswordEncoder")
	private PasswordEncoder encoder;
	@Override
	public ProfessorVO getProInfo(String profno) {
		// TODO Auto-generated method stub
		log.info("getProInfo.....");
		return professorMapper.read(profno);
	}

	@Override
	public int updateProfInfo(ProfessorVO professorVO) {
		// TODO Auto-generated method stub
		log.info("updateProfInfo...." + professorVO);
		MemberVO memberVO = new MemberVO();
		memberVO.setUserid(professorVO.getProfno());
		memberVO.setUserpw(encoder.encode(professorVO.getPassword()));
		
		int cnt = 0;
		
		if(professorMapper.update(professorVO) > 0) {
			cnt++;
		}
		if(professorMapper.updatePassword(memberVO.getUserid(), memberVO.getUserpw()) > 0) {
			cnt++;
		}
		
		return cnt;
	}

}
