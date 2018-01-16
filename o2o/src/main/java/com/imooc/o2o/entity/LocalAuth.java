package com.imooc.o2o.entity;

import java.util.Date;

public class LocalAuth {
	private Long localAythId;
	private String username;
	private String password;
	private Date createTime;
	private Date lastEditTime;
	private PersonInfo personInfo;

	public Long getLocalAythId() {
		return localAythId;
	}

	public void setLocalAythId(Long localAythId) {
		this.localAythId = localAythId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
