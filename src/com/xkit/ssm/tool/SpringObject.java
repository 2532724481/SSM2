package com.xkit.ssm.tool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringObject {
	private static ApplicationContext ctx;
	static{
		ctx = new  ClassPathXmlApplicationContext("applicationContext_aop.xml");
	}
	public static Object GetObject(String url){
		return ctx.getBean(url);
	}
}
