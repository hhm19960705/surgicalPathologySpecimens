package com.sps.service.impl;

import java.util.List;

import com.sps.dao.SpecimenDao;
import com.sps.entity.PageBean;
import com.sps.entity.Specimen;
import com.sps.service.SpecimenService;

/**
 * 标本ServiceImpl
 * 
 */
public class SpecimenServiceImpl implements SpecimenService {

	private SpecimenDao specimenDao;

	public void setSpecimenDao(SpecimenDao specimenDao) {
		this.specimenDao = specimenDao;
	}

	// 分页查找全部标本根据标本接收时间降序排列
	@Override
	public PageBean<Specimen> findByjsPage(Integer currPage, String id, String pid) {
		PageBean<Specimen> pageBean = new PageBean<Specimen>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = specimenDao.findCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Specimen> list = specimenDao.findByjsPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}
	
	// 分页查找全部标本根据标本核对时间降序排列
	@Override
	public PageBean<Specimen> findByhdPage(Integer currPage, String id, String pid) {
		PageBean<Specimen> pageBean = new PageBean<Specimen>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = specimenDao.findCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Specimen> list = specimenDao.findByhdPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}

	// 新增标本
	@Override
	public void save(Specimen specimen) {
		specimenDao.save(specimen);
	}

	// 根据ID查找标本
	@Override
	public Specimen findById(String sid) {
		return specimenDao.findById(sid);
	}

	// 修改标本
	@Override
	public void update(Specimen specimen) {
		specimenDao.update(specimen);
	}

	// 删除标本
	@Override
	public void delete(Specimen specimen) {
		specimenDao.delete(specimen);
	}

	// 查找全部标本
	@Override
	public List<Specimen> findAll() {
		List<Specimen> list = specimenDao.findAll();
		return list;
	}

	// 分页查找未核对标本
	@Override
	public PageBean<Specimen> findhdByPage(Integer currPage, String id,
			String pid) {
		PageBean<Specimen> pageBean = new PageBean<Specimen>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = specimenDao.findhdCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Specimen> list = specimenDao
				.findhdByPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}

	// 分页查找未送检标本
	@Override
	public PageBean<Specimen> findsjByPage(Integer currPage, String id,
			String pid) {
		PageBean<Specimen> pageBean = new PageBean<Specimen>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = specimenDao.findsjCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Specimen> list = specimenDao
				.findsjByPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}

	// 分页查找未接收标本
	@Override
	public PageBean<Specimen> findjsByPage(Integer currPage, String id,
			String pid) {
		PageBean<Specimen> pageBean = new PageBean<Specimen>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = specimenDao.findjsCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Specimen> list = specimenDao
				.findjsByPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}

}
