package com.xkit.ssm.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.xkit.ssm.validate.Userinsert;
import com.xkit.ssm.validate.Userlogin;

public class Easybuy_user {
	private int id;
	@NotEmpty(groups={Userlogin.class,Userinsert.class},message="帐号不能为空")
	private String loginName;
	@NotEmpty(groups={Userinsert.class},message="名字不能为空")
	private String userName;
	@NotEmpty(groups={Userlogin.class,Userinsert.class},message="密码不符合格式")
	private String password;
	private int sex;
	@NotEmpty(groups={Userinsert.class},message="身份证不能为空")
	private String identityCode;
	@NotEmpty(groups={Userinsert.class},message="邮箱不能为空")
	private String email;
	@NotEmpty(groups={Userinsert.class},message="手机号不能为空")
	private String mobile;
	private int type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
