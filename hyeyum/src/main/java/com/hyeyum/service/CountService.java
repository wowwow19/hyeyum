package com.hyeyum.service;


/**
 * 카운트 서비스 인터페이스 
 * @author 강영훈, 박수연
 * @since 2021-05-20
 */
public interface CountService {
	int getStudCnt();
	
	int getProfCnt();
	
	int getStatusCnt();
	
	int getCourseCnt();
	
	int getChargeStudCnt(String profno);
	
	int getChargeCourseCnt(String profno);
	
	int getCorrCnt(String profno);
}
