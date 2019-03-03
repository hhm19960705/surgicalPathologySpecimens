package com.sps.dao;

import java.util.List;

import com.sps.entity.RockObjectValue;
import com.sps.entity.Specimen;

/**
 * 标本Dao
 * 
 */
public interface SpecimenDao {

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

	// 分页查找全部标本根据标本接收时间降序排列
	public List<Specimen> findByjsPage(int begin, int pageSize, String id,
			String pid);

	// 分页查找全部标本根据标本核对时间降序排列
	public List<RockObjectValue> findByhdPage(int begin, int pageSize, String id,
			String pid);

	// 标本个数
	public int findCount(String id, String pid);

	// 未核对标本个数
	public int findhdCount(String id, String pid);

	// 未送检标本个数
	public int findsjCount(String id, String pid);

	// 未接收标本个数
	public int findjsCount(String id, String pid);

	// 分页查找未核对标本
	public List<Specimen> findhdByPage(int begin, int pageSize, String id,
			String pid);

	// 分页查找未送检标本
	public List<Specimen> findsjByPage(int begin, int pageSize, String id,
			String pid);

	// 分页查找未接收标本
	public List<Specimen> findjsByPage(int begin, int pageSize, String id,
			String pid);

}
