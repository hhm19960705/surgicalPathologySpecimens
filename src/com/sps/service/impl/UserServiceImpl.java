package com.sps.service.impl;

import java.util.List;

import com.sps.dao.UserDao;
import com.sps.entity.PageBean;
import com.sps.entity.User;
import com.sps.service.UserService;
/**
 * 用户ServiceImpl
 * 
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User UserLogin(User user) {
		return userDao.UserLogin(user);
	}

	// 分页查找所有用户
	@Override
	public PageBean<User> findByPage(Integer currPage, String id) {

		PageBean<User> pageBean = new PageBean<User>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = userDao.findCount(id);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<User> list = userDao.findByPage(begin, pageSize, id);
		pageBean.setList(list);
		return pageBean;
	}

	// 分页查找问题反馈
	@Override
	public PageBean<User> findwtByPage(Integer currPage, String id) {

		PageBean<User> pageBean = new PageBean<User>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = userDao.findwtCount(id);
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<User> list = userDao.findwtByPage(begin, pageSize, id);
		pageBean.setList(list);
		return pageBean;
	}

	// 新增用户
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	// 根据Id查找用户
	@Override
	public User findById(String uid) {
		return userDao.findById(uid);
	}

	// 修改用户
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	// 删除用户
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	// 查找所有用户
	@Override
	public List<User> findAll() {

		List<User> list = userDao.findAll();
		return list;
	}
}
