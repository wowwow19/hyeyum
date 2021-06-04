package com.hyeyum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.hyeyum.domain.AuthVO;
import com.hyeyum.domain.MemberVO;




public interface MemberMapper {
	MemberVO read(String userid);
	
	List<MemberVO> getList();
	
	@Delete("delete from tbl_member where userid = #{userid}")
	int delete(String userid);
	
	@Insert("insert into tbl_member(userid, userpw, name) values(#{userid}, #{userpw}, #{name})")
	void insert(@Param("userid") String userid, @Param("userpw") String userpw, @Param("name") String name);
	
	@Insert("insert into tbl_member_auth(userid, auth) values(#{userid}, 'ROLE_STUDENT')")
	void insertStudAuth(AuthVO authVO);

	@Insert("insert into tbl_member_auth(userid, auth) values(#{userid}, 'ROLE_PROFESSOR')")
	void insertProfAuth(AuthVO authVO);
	
	@Insert("insert into tbl_member_auth(userid, auth) values(#{userid}, 'ROLE_ADMIN')")
	void insertAdminAuth(AuthVO authVO);
	
	@Update("update tbl_member set userpw = #{userpw} where userid = #{userid}")
	int update(MemberVO memberVo);
}
