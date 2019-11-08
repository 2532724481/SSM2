package com.xkit.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkit.ssm.entity.Easybuy_user;



public interface Easybuy_userDAO {
	public Easybuy_user Login(@Param("login") String login,@Param("pass") String pass);
	
	public int insert(Easybuy_user user) throws Exception;
	
	public List<Easybuy_user> addUserName();
	
	public int addSelectUser(String zh);
	
	public List<Easybuy_user> selectUser();
	public List<Easybuy_user> selectUserBypage(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize,@Param("user") Easybuy_user user);
	public int pageCount(Easybuy_user user);
}
