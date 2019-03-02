package com.sps.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sps.entity.PageBean;
import com.sps.entity.Patient;
import com.sps.service.PatientService;
/**
 * 患者Action
 *
 */
@SuppressWarnings("serial")
public class PatientAction extends ActionSupport implements
		ModelDriven<Patient> {

	private Patient patient = new Patient();

	@Override
	public Patient getModel() {
		return patient;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 注入业务层的类
	private PatientService patientService;

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	// 查找患者的动作
	public String findAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pid = request.getParameter("pid");
		PageBean<Patient> pageBean = patientService.findByPage(currPage, pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	// 跳转到添加患者的动作
	public String saveUI() {
		return "saveUI_ok";
	}

	// 添加患者的动作
	public String add() {
		patientService.save(patient);
		return "add_ok";
	}

	// 跳转到修改患者页面的动作
	public String editUI() {
		// 根据患者Id查询患者
		patient = patientService.findById(patient.getPid());
		return "editUI_ok";
	}

	// 修改患者信息的动作
	public String edit() {
		patientService.update(patient);
		return "edit_ok";
	}

	// 删除患者信息的动作
	public String delete() {
		patient = patientService.findById(patient.getPid());
		patientService.delete(patient);
		return "patient_delete_ok";
	}

}
