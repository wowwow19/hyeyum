package com.hyeyum.mapper;

import java.util.List;

import com.hyeyum.domain.TuitionVO;

public interface TuitionMapper {
	
	List<TuitionVO> getList();
	
	TuitionVO read(Long tuitno);
	
	int insert(TuitionVO tuitionVO);
	
	int update(TuitionVO tuitionVO);
	
	int delete(Long tuitno);
}
