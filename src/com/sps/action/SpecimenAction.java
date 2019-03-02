package com.sps.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sps.entity.PageBean;
import com.sps.entity.Patient;
import com.sps.entity.Specimen;
import com.sps.service.PatientService;
import com.sps.service.SpecimenService;

/**
 * 标本Action
 * 
 */
@SuppressWarnings("serial")
public class SpecimenAction extends ActionSupport implements
		ModelDriven<Specimen> {

	private Specimen specimen = new Specimen();

	@Override
	public Specimen getModel() {
		// TODO Auto-generated method stub
		return specimen;
	}

	// 注入业务层的类
	private SpecimenService specimenService;

	public void setSpecimenService(SpecimenService specimenService) {
		this.specimenService = specimenService;
	}

	private PatientService patientService;

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 分页查找全部标本根据标本接收时间降序排列
	public String findAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<Specimen> pageBean = specimenService.findByjsPage(currPage,
				id, pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	// 分页查找全部标本根据标本核对时间降序排列
	public String findstateAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<Specimen> pageBean = specimenService.findByhdPage(currPage, id,
				pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findstateAll";
	}

	// 根据条件查找全部未接收标本的动作
	public String findjsAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<Specimen> pageBean = specimenService.findjsByPage(currPage,
				id, pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findjsAll";
	}

	// 根据条件查找全部未核对标本的动作
	public String findhdAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<Specimen> pageBean = specimenService.findhdByPage(currPage,
				id, pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findhdAll";
	}

	// 跳转到标本核对页面的动作
	public String hdUI() {
		// 根据标本Id查询标本
		specimen = specimenService.findById(specimen.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "hdUI_ok";
	}

	// 跳转到标本填写核对失败问题描述页面的动作
	public String hdfalseUI() {
		// 根据标本Id查询标本
		specimen = specimenService.findById(specimen.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "hdfalseUI_ok";
	}

	// 修改标本核对状态为失败的动作
	public String hdfalse() {
		specimenService.update(specimen);
		return "hdfalse_ok";
	}

	// 修改标本核对状态为成功的动作
	public String hdsuccess() {
		specimenService.update(specimen);
		return "hdsuccess_ok";
	}

	// 添加标本的动作
	public String saveUI() {
		// 查询所有患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);// 集合用SET，对象用PUSh
		return "saveUI_ok";
	}

	// 保存标本的动作
	public String add() {
		specimenService.save(specimen);
		return "add_ok";
	}

	// 跳转到修改标本页面的动作
	public String editUI() {
		// 根据标本Id查询标本
		specimen = specimenService.findById(specimen.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editUI_ok";
	}
	
	// 跳转到查看标本详情信息页面的动作
	public String detailsUI() {
		// 根据标本Id查询标本
		specimen = specimenService.findById(specimen.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "detailsUI_ok";
	}

	// 跳转标本接收页面的动作
	public String jsUI() {
		// 根据标本Id查询标本
		specimen = specimenService.findById(specimen.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "jsUI_ok";
	}

	// 跳转标本填写接收失败问题描述页面的动作
	public String jsfalseUI() {
		// 根据标本Id查询标本
		specimen = specimenService.findById(specimen.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "jsfalseUI_ok";
	}

	// 修改标本接收状态为失败的动作
	public String jsfalse() {
		specimenService.update(specimen);
		return "jsfalse_ok";
	}

	// 修改标本接收状态为成功的动作
	public String jssuccess() {
		specimenService.update(specimen);
		return "jssuccess_ok";
	}

	// 根据条件查找全部未送检标本的动作
	public String findsjAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<Specimen> pageBean = specimenService.findsjByPage(currPage,
				id, pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findsjAll";
	}

	// 跳转到标本送检页面的动作
	public String sjUI() {
		// 根据标本Id查询标本
		specimen = specimenService.findById(specimen.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "sjUI_ok";
	}

	// 标本送检的动作
	public String sj() {
		specimenService.update(specimen);
		return "sj_ok";
	}

	// 修改标本的动作
	public String edit() {
		specimenService.update(specimen);
		return "edit_ok";
	}

	// 删除标本的动作
	public String delete() {
		specimen = specimenService.findById(specimen.getId());
		specimenService.delete(specimen);
		return "specimen_delete_ok";
	}
}
