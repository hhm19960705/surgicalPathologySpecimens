package com.sps.dao;

import java.util.List;

import com.sps.entity.History;

/**
 * 病例Dao
 * 
 */
public interface HistoryDao {

	// 保存病例
	public void save(History history);

	// 根据ID查找病例
	public History findById(String hid);

	// 修改病例
	public void update(History history);

	// 删除病例
	public void delete(History history);

	// 查找全部病例
	public List<History> findAll();

	// 分页查找全部病例
	public List<History> findByPage(int begin, int pageSize, String id,
			String pid);

	// 病例个数
	public int findCount(String id, String pid);

	// 未初步诊断病例个数
	public int findcbCount(String id, String pid);

	// 未审核病例个数
	public int findshCount(String id, String pid);

	// 分页查找全部未初步诊断病例
	public List<History> findcbByPage(int begin, int pageSize, String id,
			String pid);

	// 分页查找全部未审核病例
	public List<History> findshByPage(int begin, int pageSize, String id,
			String pid);

}
