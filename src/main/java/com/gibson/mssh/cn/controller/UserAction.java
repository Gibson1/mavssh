package com.gibson.mssh.cn.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gibson.mssh.cn.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private Map currentSession;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		
		return "";
	}
	
	public String login() {
		
		String returnCode="success";
		User user=this.getUser();
		if(user == null){
			returnCode="needAuth";
			return returnCode;
		}
		
		currentSession=ActionContext.getContext().getSession();
		
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println("Login meghod of User Action..................");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//check currentSession
		if(1 == 2 && !currentSession.isEmpty() && currentSession.containsKey("uid") && !currentSession.get("uid").equals("")){
			String uid=currentSession.get("uid").toString();
			String searchUser="From User u where u.uid = :uid";
			Query query = session.createQuery(searchUser);
			query.setParameter("uid",uid);
			List results = (List) query.list();
			
			if(results.size()!=1){
				returnCode="needAuth";
				currentSession.remove("uid");
				((org.apache.struts2.dispatcher.SessionMap<String, Object>)currentSession).invalidate();
			}else{
				System.out.println("login success with existed session attribute uid..........");
			}
		}else{
			/*// search User by query
			String searchUser="From User u where u.name = :name";
			Query query = session.createQuery(searchUser);
			query.setParameter("name",user.getName());
			List results = (List) query.list();
			*/
			
			// search User by criteria
			Criteria crit=session.createCriteria(User.class);
			crit.add(Restrictions.eq("name", user.getName()));
			List results = crit.list();
			
			if(results.size()!=1){
				returnCode="needAuth";
			}else{
				User loginUser=(User) results.iterator().next();
				if(loginUser.getPassword() != null && loginUser.getPassword().equals(user.getPassword())){
					System.out.println("login success..........");
					currentSession.put("uid", loginUser.getUid());
				}else{
					System.out.println("login failure..........");
					returnCode="needAuth";
				}
			}
			
			tx.commit();
			session.close();
			factory.close();
		}
		
		if(user != null){
			this.setUser(null);
		}
		
		return returnCode;
	}

}
