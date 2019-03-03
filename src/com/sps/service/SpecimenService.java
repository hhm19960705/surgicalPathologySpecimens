package com.sps.service;

import java.util.List;

import com.sps.entity.PageBean;
import com.sps.entity.RockObjectValue;
import com.sps.entity.Specimen;

/**
 * 标本Service
 * 
 */
public interface SpecimenService {
	// 分页查找全部标本根据标本接收时间降序排列
	public PageBean<Specimen> findByjsPage(Integer currPage, String id,
			String pid);

	// 分页查找全部标本根据标本核对时间降序排列
	public PageBean<RockObjectValue> findByhdPage(Integer currPage, String id,
			String pid);

	// 分页查找未核对标本
	public PageBean<Specimen> findhdByPage(Integer currPage, String id,
			String pid);

	// 分页查找未送检标本
	public PageBean<Specimen> findsjByPage(Integer currPage, String id,
			String pid);

	// 分页查找未接收标本
	public PageBean<Specimen> findjsByPage(Integer currPage, String id,
			String pid);

	// 新增标本
	public void save(Specimen specimen);

	// 根据ID查找标本
	public Specimen findById(String sid);

	// 修改标本
	public void update(Specimen specimen);

	// 删除标本
	public void delete(Specimen specimen);

	// 查找全部标本
	public List<Specimen> findAll();

}
