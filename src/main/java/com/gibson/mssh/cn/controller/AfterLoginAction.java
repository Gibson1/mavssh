package com.gibson.mssh.cn.controller;

import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gibson.mssh.cn.entity.User;
import com.gibson.mssh.cn.entity.UserHistory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AfterLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8826170165209686416L;
	/**
	 * 
	 */
	private Map currentSession;
	private List userHistories;

	public List getUserHistories() {
		return userHistories;
	}

	public void setUserHistories(List userHistories) {
		this.userHistories = userHistories;
	}

	public String execute() {

		String returnCode = "success";

		currentSession = ActionContext.getContext().getSession();

		// check currentSession
		if (!currentSession.isEmpty() && currentSession.containsKey("uid") && !currentSession.get("uid").equals("")) {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			// search User by criteria
			String uid = currentSession.get("uid").toString();
			Criteria crit = session.createCriteria(User.class);
			crit.add(Restrictions.eq("uid", uid));
			List results = crit.list();

			if (results.size() != 1) {
				returnCode = "needAuth";
				currentSession.remove("uid");
				((org.apache.struts2.dispatcher.SessionMap<String, Object>) currentSession).invalidate();
			} else {
				System.out.println("login success with existed session attribute uid..........");
				// Search history by user
				Integer usr_id=((User)results.iterator().next()).getId();
				Criteria crituh = session.createCriteria(UserHistory.class);
				crituh.add(Restrictions.eq("UHR_USR_ID", usr_id));
				userHistories = crituh.list();
				
			}

			tx.commit();
			session.close();
			factory.close();
		} else {
			returnCode = "needAuth";
			currentSession.remove("uid");
			currentSession.clear();
			((org.apache.struts2.dispatcher.SessionMap<String, Object>) currentSession).invalidate();
		}

		return returnCode;
	}

}
