package com.hyeyum.service;

import java.util.List;

import com.hyeyum.domain.SalaryVO;
import com.hyeyum.domain.ScheduleVO;
import com.hyeyum.domain.ScholarshipVO;
import com.hyeyum.domain.TuitionVO;

/**
 * 장학금,급여,등록금 서비스 인터페이스 
 * @author 강영훈, 박수연
 * @since 2021-05-20
 */
public interface AdminAdditionalService {
	
	List<ScholarshipVO> getScholarshipList(Long deptno, Long studno); //장학금 지급 내역 목록
	
	ScholarshipVO getScholarship(Long schono);//장학금 지급 내역 상세목록
	 
	int payScholarship(ScholarshipVO scholarshipVO); //장학금 지급
	
	List<TuitionVO> getTuitionList();//등록금 납부 목록
	
	TuitionVO getTuition(Long tuitno); //등록금 납부 상세목록
	
	List<SalaryVO> getSalaryList(String profno); //급여 지급 목록
	
	SalaryVO getSalary(String profno, Long salno); //급여 지급 상세조회
	
	int paySalary(SalaryVO salaryVO); //급여 지급
	
	/**
	 * 학사일정을 입력하는 메서드
	 * @author 전민우
	 */
	int insertSchedule(ScheduleVO scheduleVO);
	
	/**
	 * 학사일정을 수정하는 메서드
	 * @author 전민우
	 */
	int updateSchedule(ScheduleVO scheduleVO);
	
	/**
	 * 학사일정을 삭제하는 메서드
	 * @author 전민우
	 */
	int deleteSchedule(ScheduleVO scheduleVO);
}
