package com.sps.dao;

import java.util.List;

import com.sps.entity.User;

/**
 * 用户Dao
 * 
 */
public interface UserDao {
	// 用户登录验证
	public User UserLogin(User user);

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

	// 分页查找所有用户
	public List<User> findByPage(int begin, int pageSize, String id);

	// 用户个数
	public int findCount(String id);

	// 分页查找问题反馈
	public List<User> findwtByPage(int begin, int pageSize, String id);

	// 问题反馈个数
	public int findwtCount(String id);

}
