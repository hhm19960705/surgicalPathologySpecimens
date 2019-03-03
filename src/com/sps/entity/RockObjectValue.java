package com.sps.entity;

import java.util.Date;

public class RockObjectValue {

	private String id;
	private String pid;
	private String name;
	private int hdstate;
	private Date hdtime;
	private int sstate;
	private Date stime;
	private String sperson;
	private int jsstate;
	private Date jstime;
	private String jsperson;
	private Date time;
	private int czstate;
	private int shstate;
	private String location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHdstate() {
		return hdstate;
	}

	public void setHdstate(int hdstate) {
		this.hdstate = hdstate;
	}

	public Date getHdtime() {
		return hdtime;
	}

	public void setHdtime(Date hdtime) {
		this.hdtime = hdtime;
	}

	public int getSstate() {
		return sstate;
	}

	public void setSstate(int sstate) {
		this.sstate = sstate;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public String getSperson() {
		return sperson;
	}

	public void setSperson(String sperson) {
		this.sperson = sperson;
	}

	public int getJsstate() {
		return jsstate;
	}

	public void setJsstate(int jsstate) {
		this.jsstate = jsstate;
	}

	public Date getJstime() {
		return jstime;
	}

	public void setJstime(Date jstime) {
		this.jstime = jstime;
	}

	public String getJsperson() {
		return jsperson;
	}

	public void setJsperson(String jsperson) {
		this.jsperson = jsperson;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getCzstate() {
		return czstate;
	}

	public void setCzstate(int czstate) {
		this.czstate = czstate;
	}

	public int getShstate() {
		return shstate;
	}

	public void setShstate(int shstate) {
		this.shstate = shstate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public RockObjectValue(String id, String pid, String name, int hdstate,
			Date hdtime, int sstate, Date stime, String sperson, int jsstate,
			Date jstime, String jsperson, Date time, int czstate, int shstate,
			String location) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.hdstate = hdstate;
		this.hdtime = hdtime;
		this.sstate = sstate;
		this.stime = stime;
		this.sperson = sperson;
		this.jsstate = jsstate;
		this.jstime = jstime;
		this.jsperson = jsperson;
		this.time = time;
		this.czstate = czstate;
		this.shstate = shstate;
		this.location = location;
	}

	public RockObjectValue() {
		super();
		// TODO Auto-generated constructor stub
	}

}
