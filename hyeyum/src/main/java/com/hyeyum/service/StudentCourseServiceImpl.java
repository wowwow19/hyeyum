package com.hyeyum.service;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.ServantActivatorPOA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyeyum.domain.CourseCategory;
import com.hyeyum.domain.CourseVO;
import com.hyeyum.domain.SugangVO;
import com.hyeyum.mapper.CourseAttachMapper;
import com.hyeyum.mapper.CourseMapper;
import com.hyeyum.mapper.SugangMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * StudentCourseService를 구현한 클래스
 * @author 이찬희
 * @since 21/05/20
 */
@Service
@Log4j
@AllArgsConstructor
public class StudentCourseServiceImpl implements StudentCourseService {
	private CourseMapper courseMapper;
	private SugangMapper sugangMapper;
	private CourseAttachMapper courseAttachMapper;
	
	/**
	 * 특정 카테고리에 해당하는 단일 강의를 상세조회하는 메서드
	 * @author 이찬희
	 */
	@Override
	public CourseVO get(CourseCategory category) {
		log.info("get...");
		
		CourseVO courseVO = courseMapper.read(category);
		courseVO.setSugangNum(sugangMapper.getSugangNum(courseVO.getCoursno()));
		courseVO.setAttachList(courseAttachMapper.findBy(category.getCoursno()));
		
		return courseVO;
	}
	
	/**
	 * 특정 카테고리에 해당하는 개설된 강의 목록을 조회하는 메서드
	 * @author 이찬희
	 */
	@Override
	public List<CourseVO> getCourseList(CourseCategory category) {
		log.info("getCourseList...");	
		
		List<CourseVO> list = courseMapper.getList(category);
		list.forEach(vo -> {
			vo.setSugangNum(sugangMapper.getSugangNum(vo.getCoursno()));
			vo.setAttachList(courseAttachMapper.findBy(vo.getCoursno()));
		});
		
		return list;
	}
	
	/**
	 * 특정 학생의 수강신청 및 장바구니 목록에 대한 시간표를 조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public CourseVO[][] getTimeTable(Long studno, Boolean status) {
		log.info("getTimeTable...");
		
		CourseVO[][] timeTable = new CourseVO[5][8];
		List<SugangVO> list = new ArrayList<>();
		CourseCategory category = new CourseCategory();
		CourseVO course = new CourseVO();
		int day;
		int startTime;
		int endTime;
		
		if(status) {
			getConfirmedSugangList(studno).forEach(vo -> {
				if(vo.getResult() == null) list.add(vo);
			});
		} else {
			getSugangList(studno).forEach(vo -> {
				if(vo.getResult() == null) list.add(vo);
			});
		}
		
		if(list != null) {
			for(SugangVO vo : list) {
				category.setCoursno(vo.getCoursno());
				course = get(category);
				
				day = course.getDay();
				startTime = course.getStartTime();
				endTime = course.getEndTime();
				
				for(int i = startTime-1; i <= endTime-1; i++) {
					if(timeTable[day-1][i] == null) {
						timeTable[day-1][i] = course;
					}
				}
				
			}
		}
		
		return timeTable;
	}
	
	/**
	 * 장바구니 목록의 특정 수강신청 항목을 상세조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public SugangVO getSugang(Long studno, Long coursno) {
		log.info("getSugang...");
		
		SugangVO sugangVO = sugangMapper.read(studno, coursno);
		sugangVO.setAttachList(courseAttachMapper.findBy(coursno));
		
		return sugangVO;
	}
	
	/**
	 * 특정 학생의 수강신청 장바구니 목록을 일괄적으로 조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public List<SugangVO> getSugangList(Long studno) {
		log.info("getSugangList...");
		
		List<SugangVO> list = sugangMapper.getList(studno);
		list.forEach(vo -> {
			vo.setAttachList(courseAttachMapper.findBy(vo.getCoursno()));
		});
		
		return list;
	}
	
	/**
	 * 특정 학생의 확정된 수강신청 목록을 일괄적으로 조회하는 메서드
	 * @author 전민우
	 */
	@Override
	public List<SugangVO> getConfirmedSugangList(Long studno) {
		log.info("getConfirmedSugangList...");
		
		List<SugangVO> list = sugangMapper.getConfirmedList(studno);
		list.forEach(vo -> {
			vo.setSugangNum(sugangMapper.getSugangNum(vo.getCoursno()));
			vo.setAttachList(courseAttachMapper.findBy(vo.getCoursno()));
		});
		
		return list;
	}
	
	/**
	 * 수강신청 장바구니 목록에 강의를 추가하는 메서드
	 * @author 전민우
	 */
	@Override
	@Transactional
	public int addSugang(SugangVO sugangVO) {
		log.info("addSugang...");
		
		// 학생의 시간표 가져오기
		CourseVO[][] timeTable = getTimeTable(sugangVO.getStudno(), false);
		CourseCategory category = new CourseCategory();
		CourseVO course = new CourseVO();
		int day;
		int startTime;
		int endTime;
		boolean flag = true;
		
		category.setCoursno(sugangVO.getCoursno());
		course = get(category);
		
		day = course.getDay();
		startTime = course.getStartTime();
		endTime = course.getEndTime();
		
		// 장바구니에 넣으려는 강의의 시간과 기존에 넣은 강의의 시간이 겹치는지 확인
		if(timeTable != null) {
			for(int i = startTime-1; i <= endTime-1; i++) {
				if(timeTable[day-1][i] != null) {
					flag = false;
				}
			}
		}
		
		// 겹치지 않는다면 장바구니 목록에 넣기
		if(flag) return sugangMapper.insert(sugangVO);
		
		return 0;
	}
	
	/**
	 * 수강신청 장바구니 목록에서 특정 강의를 삭제하는 메서드
	 * @author 전민우
	 */
	@Override
	public int deleteSugang(SugangVO sugangVO) {
		log.info("deleteSugang...");
		
		// 이미 수강신청이 확정된 내역을 삭제하려고 할 경우
		log.info(sugangVO.getStatus());
		if(sugangVO.getStatus()) return -1;
		return sugangMapper.delete(sugangVO);
	}
	
	/**
	 * 수강신청 장바구니 내역을 확정하는 메서드
	 * @author 전민우
	 */
	@Override
	@Transactional
	public int completeSugang(Long studno) {
		log.info("completeSugang...");
		
		List<SugangVO> list = sugangMapper.getList(studno);
		
		SugangVO sugangVO = new SugangVO();
		
		
		int cnt = 0;
		for(SugangVO vo : list) {
			sugangVO.setStudno(studno);
			sugangVO.setCoursno(vo.getCoursno());
			if(!vo.getStatus()) {
				sugangMapper.update(sugangVO);
				cnt++;
			}
		}
		return cnt;
	}
	
}
