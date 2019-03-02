package com.sps.service;

import java.util.List;

import com.sps.entity.History;
import com.sps.entity.PageBean;
/**
 * 病例Service
 * 
 */
public interface HistoryService {

	// 分页查找全部病例
	public PageBean<History> findByPage(Integer currPage, String id, String pid);

	// 分页查找全部未初步诊断病例
	public PageBean<History> findcbByPage(Integer currPage, String id,
			String pid);

	// 分页查找全部未审核病例
	public PageBean<History> findshByPage(Integer currPage, String id,
			String pid);

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

}
