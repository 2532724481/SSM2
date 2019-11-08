package com.xkit.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.service.Easybuy_userService;
import com.xkit.ssm.tool.PageBean;
import com.xkit.ssm.validate.Userinsert;
import com.xkit.ssm.validate.Userlogin;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private Easybuy_userService easy;

	@RequestMapping("/login")
	public String loginUser(
			@Validated(value = Userlogin.class) Easybuy_user parms,
			BindingResult r, Model mv, HttpSession session) throws Exception {
		if (r.hasFieldErrors()) {
			return "Login";
		} else {
			Easybuy_user user = easy.Login(parms.getLoginName(),
					parms.getPassword());
			if (user == null) {
				mv.addAttribute("message", "哈哈");
				return "Login";
			} else {
				session.setAttribute("user",user);
				mv.addAttribute("message", "登录成功");
				return "WEB-INF/manage/Main";
			}
		}


	}

	@RequestMapping("/insert")
	public String insertUser(
			@Validated(value = Userinsert.class) Easybuy_user parms,
			BindingResult r, Model mv) throws Exception {
		if (r.hasFieldErrors()) {
			return "Regist";
		} else {
			int i = easy.InSert(parms);
			if (i > 0) {
				return "Login";
			} else {
				return "Regist";
			}
		}
	}

	@RequestMapping("/checkLoginName")
	public @ResponseBody
	Object checkLoginName(String zh) throws Exception {
		boolean isok = easy.addSelectUser(zh);
		String rs = "{\"msg\":1}";
		if (isok) {
			rs = "{\"msg\":0}";
		}
		return rs;
	}

	@RequestMapping("/selectUser")
	public @ResponseBody
	List<Easybuy_user> selectUser() throws Exception {
		List<Easybuy_user> list = easy.selectUser();
		return list;
	}

	@RequestMapping("/selectUserpage")
	public String selectUserpage(
			@RequestParam(defaultValue = "1") Integer pageIndex,
			Integer pageSize, Easybuy_user user, Model mv) throws Exception {
		pageSize = 2;
		int count = easy.pageCount(user);
		int pageCount = count % pageSize == 0 ? count / pageSize : count
				/ pageSize + 1;
		if (pageIndex < 1 || pageIndex > pageCount) {
			pageIndex = 1;
		}
		List<Easybuy_user> list = easy.selectUserBypage(pageIndex, pageSize,
				user);
		PageBean pb = new PageBean();
		pb.setDataList(list);
		pb.setPageCount(pageCount);
		pb.setRecord(count);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		mv.addAttribute("pageList", pb);
		return "WEB-INF/manage/selectList";
	}
	@RequestMapping("/mainTest")
	public String lxj(){
		return "WEB-INF/manage/mainTest";
	}
}
