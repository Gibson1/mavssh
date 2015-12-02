package com.gibson.mssh.cn;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {

	private String name;
	private Integer age;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void testSpringEnv(){
	    //加载Spring的配置文件，得到ApplicationContext对象
	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    //获取bean对象
	    User user = (User) context.getBean("user");
	    System.out.println(user.getAge());
	}
}
