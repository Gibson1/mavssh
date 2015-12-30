/**
 * 
 */
package com.gibson.mssh.cn.entity;

import java.io.Serializable;

import org.hibernate.annotations.Entity;

/**
 * @author gichen stores 6 red ball numbers and 1 blue ball number that belong
 *         to someone
 *
 */
@Entity
public class UserHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 197122515165912115L;
	private Long UHR_ID;
	private String UHR_CODE;
	private Integer UHR_USR_ID;
	private String UHR_RED1;
	private String UHR_RED2;
	private String UHR_RED3;
	private String UHR_RED4;
	private String UHR_RED5;
	private String UHR_RED6;
	private String UHR_BLUE;
	private String UHR_CREATE_UID;
	private String UHR_UPDATE_UID;

	public Long getUHR_ID() {
		return UHR_ID;
	}

	public void setUHR_ID(Long uHR_ID) {
		UHR_ID = uHR_ID;
	}

	public String getUHR_CODE() {
		return UHR_CODE;
	}

	public void setUHR_CODE(String uHR_CODE) {
		UHR_CODE = uHR_CODE;
	}

	public Integer getUHR_USR_ID() {
		return UHR_USR_ID;
	}

	public void setUHR_USR_ID(Integer uHR_USR_ID) {
		UHR_USR_ID = uHR_USR_ID;
	}

	public String getUHR_RED1() {
		return UHR_RED1;
	}

	public void setUHR_RED1(String uHR_RED1) {
		UHR_RED1 = uHR_RED1;
	}

	public String getUHR_RED2() {
		return UHR_RED2;
	}

	public void setUHR_RED2(String uHR_RED2) {
		UHR_RED2 = uHR_RED2;
	}

	public String getUHR_RED3() {
		return UHR_RED3;
	}

	public void setUHR_RED3(String uHR_RED3) {
		UHR_RED3 = uHR_RED3;
	}

	public String getUHR_RED4() {
		return UHR_RED4;
	}

	public void setUHR_RED4(String uHR_RED4) {
		UHR_RED4 = uHR_RED4;
	}

	public String getUHR_RED5() {
		return UHR_RED5;
	}

	public void setUHR_RED5(String uHR_RED5) {
		UHR_RED5 = uHR_RED5;
	}

	public String getUHR_RED6() {
		return UHR_RED6;
	}

	public void setUHR_RED6(String uHR_RED6) {
		UHR_RED6 = uHR_RED6;
	}

	public String getUHR_BLUE() {
		return UHR_BLUE;
	}

	public void setUHR_BLUE(String uHR_BLUE) {
		UHR_BLUE = uHR_BLUE;
	}

	public String getUHR_CREATE_UID() {
		return UHR_CREATE_UID;
	}

	public void setUHR_CREATE_UID(String uHR_CREATE_UID) {
		UHR_CREATE_UID = uHR_CREATE_UID;
	}

	public String getUHR_UPDATE_UID() {
		return UHR_UPDATE_UID;
	}

	public void setUHR_UPDATE_UID(String uHR_UPDATE_UID) {
		UHR_UPDATE_UID = uHR_UPDATE_UID;
	}

}
