package com.sps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sps.dao.HistoryDao;
import com.sps.entity.History;
import com.sps.util.HibernateUtil;
/**
 * 病例DaoImpl
 * 
 */
public class HistoryDaoImpl implements HistoryDao {

	private HibernateUtil hibernateUtil;
	private Session session;

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	// 病例个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findCount(String id, String pid) {

		StringBuffer hql = new StringBuffer(
				" select count(*) from History where 1=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		if (pid != null && !pid.equals("")) {
			hql.append(" and pid ='" + pid + "'");
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

	// 未初步诊断病例个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findcbCount(String id, String pid) {

		StringBuffer hql = new StringBuffer(
				" select count(*) from History where czstate=0 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		if (pid != null && !pid.equals("")) {
			hql.append(" and pid ='" + pid + "'");
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

	// 未审核病例个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findshCount(String id, String pid) {

		StringBuffer hql = new StringBuffer(
				" select count(*) from History where shstate=0 and czstate=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		if (pid != null && !pid.equals("")) {
			hql.append(" and pid ='" + pid + "'");
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

	// 分页查找全部病例
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<History> findByPage(int begin, int pageSize, String id,
			String pid) {
		StringBuffer hql = new StringBuffer(" from History where 1=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		if (pid != null && !pid.equals("")) {
			hql.append(" and pid ='" + pid + "'");
		}
		// 获取被Spring托管的session
		session = hibernateUtil.getSession();
		// 获取query对象
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<History> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 分页查找全部未审核病例
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<History> findshByPage(int begin, int pageSize, String id,
			String pid) {
		StringBuffer hql = new StringBuffer(
				" from History where czstate=1 and shstate=0");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		if (pid != null && !pid.equals("")) {
			hql.append(" and pid ='" + pid + "'");
		}
		// 获取被Spring托管的session
		session = hibernateUtil.getSession();
		// 获取query对象
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<History> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 分页查找全部未初步诊断病例
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<History> findcbByPage(int begin, int pageSize, String id,
			String pid) {
		StringBuffer hql = new StringBuffer(" from History where czstate=0 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		if (pid != null && !pid.equals("")) {
			hql.append(" and pid ='" + pid + "'");
		}
		// 获取被Spring托管的session
		session = hibernateUtil.getSession();
		// 获取query对象
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<History> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 保存病例
	@SuppressWarnings("static-access")
	@Override
	public void save(History history) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(history);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 根据ID查找病例
	@SuppressWarnings("static-access")
	@Override
	public History findById(String hid) {
		session = hibernateUtil.getSession();
		History history = (History) session.get(History.class, hid);
		hibernateUtil.closeSession(session);
		return history;
	}

	// 修改病例
	@SuppressWarnings("static-access")
	@Override
	public void update(History history) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(history);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 删除病例
	@SuppressWarnings("static-access")
	@Override
	public void delete(History history) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(history);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 查找全部病例
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<History> findAll() {
		String hql = "from History";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<History> list = query.list();
		return list;
	}

}
