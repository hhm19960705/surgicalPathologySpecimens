package com.sps.service;

import java.util.List;

import com.sps.entity.PageBean;
import com.sps.entity.Patient;

/**
 * 患者Service
 * 
 */
public interface PatientService {
	// 分页查找所有患者
	public PageBean<Patient> findByPage(Integer currPage, String id);

	// 新增患者
	public void save(Patient patient);

	// 根据Id查找患者
	public Patient findById(String pid);

	// 修改患者
	public void update(Patient patient);

	// 删除患者
	public void delete(Patient patient);

	// 查找所有患者
	public List<Patient> findAll();
}
