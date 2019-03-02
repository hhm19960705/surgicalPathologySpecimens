package com.sps.service.impl;

import java.util.List;

import com.sps.dao.PatientDao;
import com.sps.entity.PageBean;
import com.sps.entity.Patient;
import com.sps.service.PatientService;

/**
 * 患者ServiceImpl
 * 
 */
public class PatientServiceImpl implements PatientService {

	private PatientDao patientDao;

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	// 分页查找所有患者
	@Override
	public PageBean<Patient> findByPage(Integer currPage, String id) {
		PageBean<Patient> pageBean = new PageBean<Patient>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = patientDao.findCount(id);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Patient> list = patientDao.findByPage(begin, pageSize, id);
		pageBean.setList(list);
		return pageBean;
	}

	// 新增患者
	@Override
	public void save(Patient patient) {
		patientDao.save(patient);
	}

	// 根据Id查找患者
	@Override
	public Patient findById(String pid) {
		return patientDao.findById(pid);
	}

	// 修改患者
	@Override
	public void update(Patient patient) {
		patientDao.update(patient);
	}

	// 删除患者
	@Override
	public void delete(Patient patient) {
		patientDao.delete(patient);
	}

	// 查找所有患者
	@Override
	public List<Patient> findAll() {
		List<Patient> list = patientDao.findAll();
		return list;
	}

}
