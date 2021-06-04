package com.hyeyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyeyum.domain.SalaryVO;
import com.hyeyum.domain.ScheduleVO;
import com.hyeyum.domain.ScholarshipVO;
import com.hyeyum.domain.TuitionVO;
import com.hyeyum.mapper.SalaryMapper;
import com.hyeyum.mapper.ScheduleMapper;
import com.hyeyum.mapper.ScholarshipMapper;
import com.hyeyum.mapper.TuitionMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


/**
* 장학금,급여,등록금 서비스 구현 클래스 
* @author 강영훈, 박수연
* @since 2021-05-20
*/
@Service
@Log4j
@AllArgsConstructor
public class AdminAdditionalServiceImpl implements AdminAdditionalService{
	
	@Autowired
	private ScholarshipMapper scholarshipMapper;
	@Autowired
	private TuitionMapper tuitionMapper;
	@Autowired
	private SalaryMapper salaryMapper;
	private ScheduleMapper scheduleMapper;

	@Override
	public List<ScholarshipVO> getScholarshipList(Long deptno, Long studno) {
		log.info("getScholarshipList.....");
		return scholarshipMapper.getList(deptno, studno);
	}
	
	@Override
	public ScholarshipVO getScholarship(Long schono) {
		log.info("getScholarship.....");
		return scholarshipMapper.read(schono);
	}

	@Override
	public int payScholarship(ScholarshipVO scholarshipVO) {
		log.info("payScholarship.....");
		return scholarshipMapper.insert(scholarshipVO);
	}

	@Override
	public List<TuitionVO> getTuitionList() {
		log.info("get Tuition List...");
		return tuitionMapper.getList();
	}

	@Override
	public TuitionVO getTuition(Long tuitno) {
		log.info("get tuition....");
		return tuitionMapper.read(tuitno);
	}

	@Override
	public List<SalaryVO> getSalaryList(String profno) {
		log.info("get Salary List...");
		return salaryMapper.getList(profno);
	}

	@Override
	public SalaryVO getSalary(String profno, Long salno) {
		log.info("get Salary...");
		return salaryMapper.read(profno, salno);
	}

	@Override
	public int paySalary(SalaryVO salaryVO) {
		log.info("pay salary....");
		return salaryMapper.insert(salaryVO);
	}
	
	/**
	 * 학사일정을 입력하는 메서드
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

}
