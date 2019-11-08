package com.xkit.ssm.service;

import java.util.List;

import com.xkit.ssm.entity.Easybuy_address;
import com.xkit.ssm.entity.Easybuy_user;


public interface Easybuy_userService {
	public Easybuy_user Login(String name, String password);
	public int InSert(Easybuy_user user) throws Exception;
	public int Addaddress(Easybuy_address easy);
	public List<Easybuy_user> addUserName();
	public boolean addSelectUser(String loginName);
	public List<Easybuy_user> selectUser();
	public List<Easybuy_address> selectlist();
	public List<Easybuy_user> selectUserBypage(int pageIndex,int pageSize, Easybuy_user user);
	public int pageCount(Easybuy_user user);
}
