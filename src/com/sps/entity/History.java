package com.sps.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * History entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class History implements java.io.Serializable {

	// Fields

	private String id;
	private Patient patient;
	private String oname;
	private String oposition;
	private String blzy;
	private String crbxx;
	private Timestamp htime;
	private Integer czstate;
	private String czperson;
	private Timestamp cztime;
	private String cbzd;
	private Integer shstate;
	private String shperson;
	private Timestamp shtime;
	private String images;
	private String radio;
	private Set specimens = new HashSet(0);
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOposition() {
		return oposition;
	}
	public void setOposition(String oposition) {
		this.oposition = oposition;
	}
	public String getBlzy() {
		return blzy;
	}
	public void setBlzy(String blzy) {
		this.blzy = blzy;
	}
	public String getCrbxx() {
		return crbxx;
	}
	public void setCrbxx(String crbxx) {
		this.crbxx = crbxx;
	}
	public Timestamp getHtime() {
		return htime;
	}
	public void setHtime(Timestamp htime) {
		this.htime = htime;
	}
	public Integer getCzstate() {
		return czstate;
	}
	public void setCzstate(Integer czstate) {
		this.czstate = czstate;
	}
	public String getCzperson() {
		return czperson;
	}
	public void setCzperson(String czperson) {
		this.czperson = czperson;
	}
	public Timestamp getCztime() {
		return cztime;
	}
	public void setCztime(Timestamp cztime) {
		this.cztime = cztime;
	}
	public String getCbzd() {
		return cbzd;
	}
	public void setCbzd(String cbzd) {
		this.cbzd = cbzd;
	}
	public Integer getShstate() {
		return shstate;
	}
	public void setShstate(Integer shstate) {
		this.shstate = shstate;
	}
	public String getShperson() {
		return shperson;
	}
	public void setShperson(String shperson) {
		this.shperson = shperson;
	}
	public Timestamp getShtime() {
		return shtime;
	}
	public void setShtime(Timestamp shtime) {
		this.shtime = shtime;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public Set getSpecimens() {
		return specimens;
	}
	public void setSpecimens(Set specimens) {
		this.specimens = specimens;
	}
	public History(String id, Patient patient, String oname, String oposition,
			String blzy, String crbxx, Timestamp htime, Integer czstate,
			String czperson, Timestamp cztime, String cbzd, Integer shstate,
			String shperson, Timestamp shtime, String images, String radio,
			Set specimens) {
		super();
		this.id = id;
		this.patient = patient;
		this.oname = oname;
		this.oposition = oposition;
		this.blzy = blzy;
		this.crbxx = crbxx;
		this.htime = htime;
		this.czstate = czstate;
		this.czperson = czperson;
		this.cztime = cztime;
		this.cbzd = cbzd;
		this.shstate = shstate;
		this.shperson = shperson;
		this.shtime = shtime;
		this.images = images;
		this.radio = radio;
		this.specimens = specimens;
	}
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}