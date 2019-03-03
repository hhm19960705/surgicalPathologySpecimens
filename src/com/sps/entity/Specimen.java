package com.sps.entity;

import java.sql.Timestamp;

/**
 * Specimen entity. @author MyEclipse Persistence Tools
 */

public class Specimen implements java.io.Serializable {

	// Fields

	private String id;
	private Patient patient;
	private History history;
	private String name;
	private String type;
	private Timestamp otime;
	private Timestamp ctime;
	private Timestamp ltime;
	private Timestamp time;
	private Integer sstate;
	private Timestamp stime;
	private String sperson;
	private Integer jsstate;
	private Timestamp jstime;
	private String jsperson;
	private String jsfalse;
	private Integer hdstate;
	private Timestamp hdtime;
	private String hdfalse;
	private String location;

	// Constructors

	/** default constructor */
	public Specimen() {
	}

	/** minimal constructor */
	public Specimen(String id, Patient patient, History history, String name,
			String type, Timestamp otime, Timestamp ctime, Timestamp ltime,
			Timestamp time) {
		this.id = id;
		this.patient = patient;
		this.history = history;
		this.name = name;
		this.type = type;
		this.otime = otime;
		this.ctime = ctime;
		this.ltime = ltime;
		this.time = time;
	}

	/** full constructor */
	public Specimen(String id, Patient patient, History history, String name,
			String type, Timestamp otime, Timestamp ctime, Timestamp ltime,
			Timestamp time, Integer sstate, Timestamp stime, String sperson,
			Integer jsstate, Timestamp jstime, String jsperson, String jsfalse,
			Integer hdstate, Timestamp hdtime, String hdfalse, String location) {
		this.id = id;
		this.patient = patient;
		this.history = history;
		this.name = name;
		this.type = type;
		this.otime = otime;
		this.ctime = ctime;
		this.ltime = ltime;
		this.time = time;
		this.sstate = sstate;
		this.stime = stime;
		this.sperson = sperson;
		this.jsstate = jsstate;
		this.jstime = jstime;
		this.jsperson = jsperson;
		this.jsfalse = jsfalse;
		this.hdstate = hdstate;
		this.hdtime = hdtime;
		this.hdfalse = hdfalse;
		this.location = location;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public History getHistory() {
		return this.history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getOtime() {
		return this.otime;
	}

	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Timestamp getLtime() {
		return this.ltime;
	}

	public void setLtime(Timestamp ltime) {
		this.ltime = ltime;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Integer getSstate() {
		return this.sstate;
	}

	public void setSstate(Integer sstate) {
		this.sstate = sstate;
	}

	public Timestamp getStime() {
		return this.stime;
	}

	public void setStime(Timestamp stime) {
		this.stime = stime;
	}

	public String getSperson() {
		return this.sperson;
	}

	public void setSperson(String sperson) {
		this.sperson = sperson;
	}

	public Integer getJsstate() {
		return this.jsstate;
	}

	public void setJsstate(Integer jsstate) {
		this.jsstate = jsstate;
	}

	public Timestamp getJstime() {
		return this.jstime;
	}

	public void setJstime(Timestamp jstime) {
		this.jstime = jstime;
	}

	public String getJsperson() {
		return this.jsperson;
	}

	public void setJsperson(String jsperson) {
		this.jsperson = jsperson;
	}

	public String getJsfalse() {
		return this.jsfalse;
	}

	public void setJsfalse(String jsfalse) {
		this.jsfalse = jsfalse;
	}

	public Integer getHdstate() {
		return this.hdstate;
	}

	public void setHdstate(Integer hdstate) {
		this.hdstate = hdstate;
	}

	public Timestamp getHdtime() {
		return this.hdtime;
	}

	public void setHdtime(Timestamp hdtime) {
		this.hdtime = hdtime;
	}

	public String getHdfalse() {
		return this.hdfalse;
	}

	public void setHdfalse(String hdfalse) {
		this.hdfalse = hdfalse;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}