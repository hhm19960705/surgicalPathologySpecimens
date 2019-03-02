package com.sps.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Patient entity. @author MyEclipse Persistence Tools
 */

public class Patient implements java.io.Serializable {

	// Fields

	private String pid;
	private String pname;
	private Integer sex;
	private Integer age;
	private Timestamp date;
	private String remark;
	private Set specimens = new HashSet(0);
	private Set histories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** minimal constructor */
	public Patient(String pid, String pname, Integer sex, Integer age,
			Timestamp date) {
		this.pid = pid;
		this.pname = pname;
		this.sex = sex;
		this.age = age;
		this.date = date;
	}

	/** full constructor */
	public Patient(String pid, String pname, Integer sex, Integer age,
			Timestamp date, String remark, Set specimens, Set histories) {
		this.pid = pid;
		this.pname = pname;
		this.sex = sex;
		this.age = age;
		this.date = date;
		this.remark = remark;
		this.specimens = specimens;
		this.histories = histories;
	}

	// Property accessors

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSpecimens() {
		return this.specimens;
	}

	public void setSpecimens(Set specimens) {
		this.specimens = specimens;
	}

	public Set getHistories() {
		return this.histories;
	}

	public void setHistories(Set histories) {
		this.histories = histories;
	}

}