package com.sps.service.impl;

import java.util.List;

import com.sps.dao.HistoryDao;
import com.sps.entity.History;
import com.sps.entity.PageBean;
import com.sps.service.HistoryService;

/**
 * 病例ServiceImpl
 * 
 */
public class HistoryServiceImpl implements HistoryService {

	private HistoryDao historyDao;

	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}

	// 分页查找全部病例
	@Override
	public PageBean<History> findByPage(Integer currPage, String id, String pid) {
		PageBean<History> pageBean = new PageBean<History>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = historyDao.findCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<History> list = historyDao.findByPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}

	// 保存病例
	@Override
	public void save(History history) {
		historyDao.save(history);
	}

	// 根据ID查找病例
	@Override
	public History findById(String hid) {
		return historyDao.findById(hid);
	}

	// 修改病例
	@Override
	public void update(History history) {
		historyDao.update(history);
	}

	// 删除病例
	@Override
	public void delete(History history) {
		historyDao.delete(history);
	}

	// 查找全部病例
	@Override
	public List<History> findAll() {
		List<History> list = historyDao.findAll();
		return list;
	}

	// 分页查找全部未初步诊断病例
	@Override
	public PageBean<History> findcbByPage(Integer currPage, String id,
			String pid) {
		PageBean<History> pageBean = new PageBean<History>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = historyDao.findcbCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<History> list = historyDao.findcbByPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}

	// 分页查找全部未审核病例
	@Override
	public PageBean<History> findshByPage(Integer currPage, String id,
			String pid) {
		PageBean<History> pageBean = new PageBean<History>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = historyDao.findshCount(id, pid);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<History> list = historyDao.findshByPage(begin, pageSize, id, pid);
		pageBean.setList(list);
		return pageBean;
	}

}
