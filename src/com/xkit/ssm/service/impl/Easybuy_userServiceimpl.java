package com.xkit.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkit.ssm.dao.Easybuy_addressDAO;
import com.xkit.ssm.dao.Easybuy_userDAO;
import com.xkit.ssm.entity.Easybuy_address;
import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.service.Easybuy_userService;

@Service
public class Easybuy_userServiceimpl implements Easybuy_userService {
	@Autowired
	private Easybuy_userDAO dao;
	@Autowired
	private Easybuy_addressDAO adddao;
	public Easybuy_user Login(String name, String password) {
		return dao.Login(name, password);
	}
	public int InSert(Easybuy_user user) throws Exception {
		int i  = dao.insert(user);
		return i;
	}
	public int Addaddress(Easybuy_address easy) {
		int i = adddao.addAddress(easy);
		return i;
	}
	public List<Easybuy_user> addUserName() {
		List<Easybuy_user> list = dao.addUserName();
		return list;
	}
	public boolean addSelectUser(String loginName) {
		int i = dao.addSelectUser(loginName);
		if(i==0){
			return true;
		}
		return false;
	}
	public List<Easybuy_user> selectUser() {
		List<Easybuy_user> list = dao.selectUser();
		return list;
	}
	public List<Easybuy_address> selectlist() {
		List<Easybuy_address> list = adddao.selectadd();
		return list;
	}
	public List<Easybuy_user> selectUserBypage(int pageIndex, int pageSize,Easybuy_user user) {
		List<Easybuy_user> list = dao.selectUserBypage(pageIndex, pageSize, user);
		return list;
	}
	public int pageCount(Easybuy_user user) {
		int i = dao.pageCount(user);
		return i;
	}

}
