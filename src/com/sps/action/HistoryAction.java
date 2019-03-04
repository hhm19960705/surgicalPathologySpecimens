package com.sps.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sps.entity.History;
import com.sps.entity.PageBean;
import com.sps.entity.Patient;
import com.sps.service.HistoryService;
import com.sps.service.PatientService;

/**
 * 病例Action
 * 
 */
@SuppressWarnings("serial")
public class HistoryAction extends ActionSupport implements
		ModelDriven<History> {

	private History history = new History();

	@Override
	public History getModel() {
		// TODO Auto-generated method stub
		return history;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	private File[] files;
	private String[] filesFileName ;
	
	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	
	public void setFiles(File[] files) {
		this.files = files;
	}

	// 注入业务层的类
	private HistoryService historyService;

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	private PatientService patientService;

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	// 根据条件查找全部病例的动作
	public String findAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<History> pageBean = historyService.findByPage(currPage, id,
				pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	// 添加病例的动作
	public String saveUI() {
		// 查询所有患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI_ok";
	}

	// 保存病例的动作
	public String add(){
		//遍历 files 数组
		if(files != null){
			//获取服务器 根目录下的upload 文件夹
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
			File upload = new File(realPath) ;
			if(!upload.exists()){
				upload.mkdirs() ;
			}
			if(files.length > 0){//取图片
				//根据父目录 和 上传的文件名创建 文件
				File img = new File(upload, filesFileName[0]) ;
				try {
					//复制文件
					FileUtils.copyFile(files[0], img);
					//这个地方的 upload 目录 是相对路径  可以改成 /+项目绝对路径
					history.setImages("upload/" + filesFileName[0]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(files.length > 1){//取录音
				//根据父目录 和 上传的文件名创建 文件
				File radio = new File(upload, filesFileName[1]) ;
				try {
					//复制文件
					FileUtils.copyFile(files[1],radio);
					history.setRadio("upload/" + filesFileName[1]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		historyService.save(history);
		return "add_ok";
	}

	// 跳转修改病例页面的动作
	public String editUI() {
		// 根据标本Id查询标本
		history = historyService.findById(history.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editUI_ok";
	}

	// 根据条件查找全部未审核病例的动作
	public String findshAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<History> pageBean = historyService.findshByPage(currPage, id,
				pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findshAll";
	}

	// 跳转病例审核页面的动作
	public String shUI() {
		// 根据标本Id查询病例
		history = historyService.findById(history.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "shUI_ok";
	}

	// 提交最终诊断的动作
	public String shsuccess() {
		historyService.update(history);
		return "shsuccess_ok";
	}

	// 根据条件查找全部未初步诊断病例的动作
	public String findcbAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pid = request.getParameter("pid");
		PageBean<History> pageBean = historyService.findcbByPage(currPage, id,
				pid);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findcbAll";
	}

	// 跳转初步诊断页面的动作
	public String cbUI() {
		history = historyService.findById(history.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "cbUI_ok";
	}

	// 提交初步诊断的动作
	public String cbsuccess() {
		historyService.update(history);
		return "cbsuccess_ok";
	}

	// 修改病例的动作
	public String edit() {
		historyService.update(history);
		return "edit_ok";
	}

	// 删除病例的动作
	public String delete() {
		history = historyService.findById(history.getId());
		historyService.delete(history);
		return "history_delete_ok";
	}

	// 跳转到查看病理单详情信息页面的动作
	public String detailsUI() {
		// 根据标本Id查询标本
		history = historyService.findById(history.getId());
		// 查询所有的患者
		List<Patient> list = patientService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "detailsUI_ok";
	}
}
