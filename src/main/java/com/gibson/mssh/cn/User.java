package com.gibson.mssh.cn;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {

	private String Uid;
	private String name;
	private Integer age;

	

	/**
	 * @return the uid
	 */
	public String getUid() {
		return Uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		Uid = uid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param age
	 *            the age to set
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
	public void testSpringEnv() {
		// 加载Spring的配置文件，得到ApplicationContext对象
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 获取bean对象
		User user = (User) context.getBean("user");
		System.out.println(user.getAge());
	}

	@Test
	public void testHibernateEnv() {
		// 加载指定目录下的配置文件，得到configuration对象
		Configuration cfg = new Configuration()
				.configure("hibernate.cfg.xml");
		// 根据configuration对象得到session工厂对象
		SessionFactory factory = cfg.buildSessionFactory();
		// 使用工厂类打开一个session
		Session session = factory.openSession();
		// 开启事务
		Transaction tx = session.beginTransaction();
		// 创建待插入数据库的对象
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		User p = (User) context.getBean("user");
		p.setUid(UUID.randomUUID().toString());
		p.setName("Gibson");
		// 保存对象
		session.save(p);
		// 提交事务
		tx.commit();
		// 关闭资源
		session.close();
		factory.close();
	}
}
