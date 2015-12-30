package com.gibson.mssh.cn.entity;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gibson.mssh.cn.entity.User;

import junit.framework.TestCase;

public class UserTest extends TestCase{


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
		p.setPassword("default");
		// 保存对象
		session.save(p);
		// 提交事务
		tx.commit();
		// 关闭资源
		session.close();
		factory.close();
	}
	
	@Test
	public void testSpringHibernate(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		User p = (User) context.getBean("user");
		p.setUid(UUID.randomUUID().toString());
		p.setName("gichen");
		p.setPassword("qwEr1234");
		session.save(p);
		tx.commit();
		session.close();
		factory.close();
	}
}
