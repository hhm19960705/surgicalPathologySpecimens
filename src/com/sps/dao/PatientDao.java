package com.sps.dao;

import java.util.List;

import com.sps.entity.Patient;

/**
 * 患者Dao
 * 
 */
public interface PatientDao {
	// 新增患者
	public void save(Patient patient);

	// 根据Id查找患者
	public Patient findById(String pid);

	// 修改患者
	public void update(Patient patient);

	// 删除患者
	public void delete(Patient spatient);

	// 查找所有患者
	public List<Patient> findAll();

	// 分页查找所有患者
	public List<Patient> findByPage(int begin, int pageSize, String id);

	// 患者个数
	public int findCount(String id);

}
