package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.hyeyum.domain.CourseAttachVO;

public interface CourseAttachMapper {
	int insert(CourseAttachVO vo);
	
	int delete(String uuid);
	
	List<CourseAttachVO> findBy(Long coursno);
	
	@Delete("DELETE FROM TBL_ATTACH WHERE COURSNO = #{coursno}")
	int deleteAll(Long coursno);
	
	@Delete("DELETE FROM TBL_ATTACH")
	int deleteAllComplete();
	
	@Select("SELECT * FROM TBL_ATTACH WHERE UPLOADPATH = TO_CHAR(SYSDATE - 1, 'YYYY/MM/DD')")
	List<CourseAttachVO> getOldFiles();

}
