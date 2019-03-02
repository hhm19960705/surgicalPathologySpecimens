package com.sps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sps.dao.UserDao;
import com.sps.entity.User;
import com.sps.util.HibernateUtil;

/**
 * 用户DaoImpl
 * 
 */
public class UserDaoImpl implements UserDao {
	private HibernateUtil hibernateUtil;
	private Session session;

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	// 用户登录验证
	@SuppressWarnings({ "static-access", "unchecked" })
	public User UserLogin(User user) {
		try {
			String hql = "from User where name=? and password=? ";
			session = hibernateUtil.getSession();
			Query query = session.createQuery(hql);
			query.setString(0, user.getName());
			query.setString(1, user.getPassword());
			List<User> list = query.list();
			if (list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return null;
	}

	// 用户个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findCount(String id) {
		StringBuffer hql = new StringBuffer(
				" select count(*) from User where 1=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql.toString());
		List<Long> list = query.list();
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		hibernateUtil.closeSession(session);
		return 0;
	}

	// 分页查找所有用户
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<User> findByPage(int begin, int pageSize, String id) {
		StringBuffer hql = new StringBuffer(" from User where 1=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		// 获取被Spring托管的session
		session = hibernateUtil.getSession();
		// 获取query对象
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 新增用户
	@SuppressWarnings("static-access")
	@Override
	public void save(User user) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 根据Id查找用户
	@SuppressWarnings("static-access")
	@Override
	public User findById(String id) {
		session = hibernateUtil.getSession();
		User user = (User) session.get(User.class, id);
		hibernateUtil.closeSession(session);
		return user;
	}

	// 修改用户
	@SuppressWarnings("static-access")
	@Override
	public void update(User user) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}


	// 删除用户
	@SuppressWarnings("static-access")
	@Override
	public void delete(User user) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 查找所有用户
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<User> findAll() {
		String hql = "from User";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}

	// 问题反馈个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findwtCount(String id) {
		StringBuffer hql = new StringBuffer(
				" select count(*) from User where wtfk!='' and wtfk is not null ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql.toString());
		List<Long> list = query.list();
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		hibernateUtil.closeSession(session);
		return 0;
	}

	// 分页查找问题反馈
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<User> findwtByPage(int begin, int pageSize, String id) {
		StringBuffer hql = new StringBuffer(
				" from User where wtfk!='' and wtfk is not null ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		// 获取被Spring托管的session
		session = hibernateUtil.getSession();
		// 获取query对象
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

}
