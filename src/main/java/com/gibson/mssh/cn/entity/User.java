package com.gibson.mssh.cn.entity;

import java.io.Serializable;

import org.hibernate.annotations.Entity;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5516449159729571638L;
	private String Uid;
	private String name;
	private String password;
	private Integer age;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return Uid;
	}

	/**
	 * @param uid
	 *            the uid to set
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

}
