/**
 * 
 */
package com.gibson.mssh.cn.entity;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

/**
 * @author gichen
 *
 */
@FixMethodOrder(org.junit.runners.MethodSorters.NAME_ASCENDING)
public class UserHistoryTest extends TestCase {

	private ApplicationContext context;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	private Criteria crit;
	private List results;
	private UserHistory uh;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		factory = (SessionFactory) context.getBean("sessionFactory");
		session = factory.openSession();
		tx = session.beginTransaction();
		uh = context.getBean(UserHistory.class);
		System.out.println("...................SetUp..................." + getName());
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		uh = null;
		results = null;
		crit = null;
		session.close();
		factory.close();
		System.out.println("...................TearDown...................\n");
	}

	@Test
	public void testNewUserHistory() {

		uh = context.getBean(UserHistory.class);
		uh.setUHR_CREATE_UID("gichen");
		uh.setUHR_USR_ID(1);
		uh.setUHR_RED1("03");
		uh.setUHR_RED2("05");
		uh.setUHR_RED3("10");
		uh.setUHR_RED4("12");
		uh.setUHR_RED5("13");
		uh.setUHR_RED6("22");
		uh.setUHR_BLUE("12");
		session.save(uh);
		tx.commit();
		session.clear();
		printNumbers(uh);

		tx.begin();
		uh = context.getBean(UserHistory.class);
		uh.setUHR_CREATE_UID("gichen");
		uh.setUHR_USR_ID(1);
		uh.setUHR_RED1("07");
		uh.setUHR_RED2("08");
		uh.setUHR_RED3("11");
		uh.setUHR_RED4("12");
		uh.setUHR_RED5("13");
		uh.setUHR_RED6("23");
		uh.setUHR_BLUE("18");
		session.save(uh);
		tx.commit();
		session.clear();
		printNumbers(uh);

		tx.begin();
		uh = context.getBean(UserHistory.class);
		uh.setUHR_CREATE_UID("Gibson");
		uh.setUHR_USR_ID(2);
		uh.setUHR_RED1("07");
		uh.setUHR_RED2("08");
		uh.setUHR_RED3("11");
		uh.setUHR_RED4("12");
		uh.setUHR_RED5("13");
		uh.setUHR_RED6("23");
		uh.setUHR_BLUE("18");
		session.save(uh);
		tx.commit();
		session.clear();
		printNumbers(uh);

	}

	@Test
	public void testSearchUserHistory() {

		crit = session.createCriteria(UserHistory.class);
		crit.add(Restrictions.eq("UHR_USR_ID", 0));
		results = crit.list();
		assertFalse(results.size() > 0);

		crit = session.createCriteria(UserHistory.class);
		crit.add(Restrictions.eq("UHR_USR_ID", 1));
		results = crit.list();
		assertTrue(results.size() > 0);
		uh = (UserHistory) results.iterator().next();
		printNumbers(uh);

	}

	@Test
	public void testUpdateUserHistory() {

		crit = session.createCriteria(UserHistory.class);
		crit.add(Restrictions.eq("UHR_USR_ID", 1));
		results = crit.list();
		assertTrue(results.size() > 0);
		uh = (UserHistory) results.iterator().next();

		System.out.println("Before Update:");
		printNumbers(uh);

		Long id = uh.getUHR_ID();

		uh.setUHR_CREATE_UID("天天向上");
		uh.setUHR_UPDATE_UID("女神来了");
		uh.setUHR_USR_ID(3);
		String tmp = uh.getUHR_RED1();
		uh.setUHR_RED1(uh.getUHR_RED2());
		uh.setUHR_RED2(uh.getUHR_RED3());
		uh.setUHR_RED3(uh.getUHR_RED4());
		uh.setUHR_RED4(uh.getUHR_RED5());
		uh.setUHR_RED5(uh.getUHR_RED6());
		uh.setUHR_RED6(uh.getUHR_BLUE());
		uh.setUHR_BLUE(tmp);

		session.update(uh);
		tx.commit();

		crit = session.createCriteria(UserHistory.class);
		crit.add(Restrictions.eq("UHR_ID", id));
		results = crit.list();
		assertTrue(results.size() == 1);
		uh = (UserHistory) results.iterator().next();
		System.out.println("After Update:");
		printNumbers(uh);

		uh.setUHR_USR_ID(1);
		session.update(uh);
		tx.begin();
		tx.commit();

	}

	@Test
	public void testDeleteUserHistory() {

		crit = session.createCriteria(UserHistory.class);
		crit.add(Restrictions.eq("UHR_USR_ID", 1));
		results = crit.list();
		Iterator it = results.iterator();
		assertTrue(results.size() > 0);
		UserHistory uh;

		// delete by session.delete
		uh = (UserHistory) it.next();
		System.out.println("Delete object:" + uh.getClass());
		printNumbers(uh);
		session.delete(uh);
		tx.commit();

		// delete by query
		uh = (UserHistory) it.next();
		System.out.println("Delete object:" + uh.getClass());
		String deleteHsql = "delete from UserHistory uh where uh.UHR_ID = :id";
		Query q = session.createQuery(deleteHsql);
		q.setParameter("id", uh.getUHR_ID());
		printNumbers(uh);
		q.executeUpdate();

	}

	private void printNumbers(UserHistory uh) {
		System.out.print("id:" + uh.getUHR_ID());
		System.out.print("\tblue:" + uh.getUHR_BLUE());
		System.out.print("\tred1:" + uh.getUHR_RED1());
		System.out.print("\tred2:" + uh.getUHR_RED2());
		System.out.print("\tred3:" + uh.getUHR_RED3());
		System.out.print("\tred4:" + uh.getUHR_RED4());
		System.out.print("\tred5:" + uh.getUHR_RED5());
		System.out.print("\tred6:" + uh.getUHR_RED6() + "\n");
	}

}
