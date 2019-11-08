package com.xkit.ssm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkit.ssm.entity.Easybuy_address;
import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.service.Easybuy_userService;

@Controller
public class AddController {
	
	@Autowired
	private Easybuy_userService easy;
	
	@RequestMapping("/initadd")
	public String initadd(){
		return "WEB-INF/paper/address";
	}
	
	@RequestMapping("/Addaddress")
	public String addAddress(Easybuy_address add,Model m){
		add.setCreatetime(new Date());
		if(add.getIsDefault()==null){
			add.setIsDefault(0);
		}
		int i = easy.Addaddress(add);
		if(i>0){
			m.addAttribute("msg","�����ɹ�");
		}else{
			m.addAttribute("msg", "����ʧ��");
		}
		return "WEB-INF/paper/address";
	}
	@ModelAttribute("userlist")
	public List<Easybuy_user> addUserName(){
		List<Easybuy_user> list = easy.addUserName();
		return list;
	}
	@RequestMapping("/selectadd")
	public @ResponseBody List<Easybuy_address> selectadd(){
		List<Easybuy_address> list = easy.selectlist();
		return list;
	}
	@RequestMapping("/deleteAddress/{a}/{b}")
	public String deleteAdd(@PathVariable("a") Integer id,@PathVariable("b") Integer uid){
		System.out.println(id+"+"+uid);
		return "selectadd";
	}
	
}
