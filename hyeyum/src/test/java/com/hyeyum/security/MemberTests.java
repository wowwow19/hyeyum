package com.hyeyum.security;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyeyum.domain.AuthVO;
import com.hyeyum.domain.MemberVO;
import com.hyeyum.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})

@Log4j
@WebAppConfiguration
public class MemberTests {
	@Autowired @Qualifier("BCryptPasswordEncoder")
	private PasswordEncoder encoder;
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testExist() {
		log.info(encoder);
		log.info(dataSource);
	}
	
	@Test
	public void testUpdate() {
		List<MemberVO> list = memberMapper.getList();
		//list.forEach(log::info);
		list.get(0).getUserid();
		for(int i = 0; i <=list.size(); i++){
			MemberVO vo = memberMapper.read(list.get(i).getUserid());
			log.info(vo);
			vo.setUserpw(encoder.encode(vo.getUserpw()));
			memberMapper.update(vo);
			log.info(vo);
			
		}
	}
	@Test
	public void testInsertAuth() {
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw(encoder.encode("1111"));
		vo.setName("최고관리자");
		memberMapper.insert(vo.getUserid(), vo.getUserpw(), vo.getName());
		AuthVO auth = new AuthVO();
		auth.setUserid(vo.getUserid());
		memberMapper.insertAdminAuth(auth);
		
	}
}
