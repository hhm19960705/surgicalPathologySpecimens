package com.sps.service;

import java.util.List;

import com.sps.entity.PageBean;
import com.sps.entity.User;

/**
 * 用户Service
 * 
 */
public interface UserService {
	// 用户登录验证
	public User UserLogin(User user);

	// 分页查找所有用户
	public PageBean<User> findByPage(Integer currPage, String id);

	// 分页查找问题反馈
	public PageBean<User> findwtByPage(Integer currPage, String id);

	// 新增用户
	public void save(User user);

	// 根据Id查找用户
	public User findById(String id);

	// 修改用户
	public void update(User user);

	// 删除用户
	public void delete(User user);

	// 查找所有用户
	public List<User> findAll();
}
