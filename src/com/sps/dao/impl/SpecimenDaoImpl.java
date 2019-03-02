package com.sps.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sps.dao.SpecimenDao;
import com.sps.entity.Specimen;
import com.sps.util.HibernateUtil;

/**
 * 标本DaoImpl
 * 
 */
public class SpecimenDaoImpl implements SpecimenDao {

	private HibernateUtil hibernateUtil;
	private Session session;

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	// 标本个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findCount(String id, String pid) {

		StringBuffer hql = new StringBuffer(
				" select count(*) from Specimen where 1=1 ");
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

	// 未接收标本个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findjsCount(String id, String pid) {

		StringBuffer hql = new StringBuffer(
				" select count(*) from Specimen where jsstate=0 and sstate=1");
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

	// 未核对标本个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findhdCount(String id, String pid) {

		StringBuffer hql = new StringBuffer(
				" select count(*) from Specimen where hdstate=0 ");
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

	// 分页查找全部标本根据标本接收时间降序排列
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Specimen> findByjsPage(int begin, int pageSize, String id,
			String pid) {
		StringBuffer hql = new StringBuffer(" from Specimen where 1=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and id ='" + id + "'");
		}
		if (pid != null && !pid.equals("")) {
			hql.append(" and pid ='" + pid + "'");
		}
		hql.append("ORDER by jstime DESC");
		// 获取被Spring托管的session
		session = hibernateUtil.getSession();
		// 获取query对象
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Specimen> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 分页查找全部标本根据标本核对时间降序排列
		@SuppressWarnings({ "static-access", "unchecked" })
		@Override
		public List<Specimen> findByhdPage(int begin, int pageSize, String id,
				String pid) {
			StringBuffer hql = new StringBuffer(" from Specimen where 1=1 ");
			if (id != null && !id.equals("")) {
				hql.append(" and id ='" + id + "'");
			}
			if (pid != null && !pid.equals("")) {
				hql.append(" and pid ='" + pid + "'");
			}
			hql.append("ORDER by hdtime DESC");
			// 获取被Spring托管的session
			session = hibernateUtil.getSession();
			// 获取query对象
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(begin);
			query.setMaxResults(pageSize);
			List<Specimen> list = query.list();
			hibernateUtil.closeSession(session);
			return list;
		}
	// 分页查找未接收标本
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Specimen> findjsByPage(int begin, int pageSize, String id,
			String pid) {
		StringBuffer hql = new StringBuffer(" from Specimen where jsstate=0 and sstate=1 ");
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
		List<Specimen> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 分页查找未核对标本
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Specimen> findhdByPage(int begin, int pageSize, String id,
			String pid) {
		StringBuffer hql = new StringBuffer(" SELECT s.id,s.pid,s.name,s.hdstate,s.hdtime,s.sstate,s.sperson,s.jsstate,s.jstime,s.jsperson,s.time,h.czstate,h.shstate FROM Specimen s,History h WHERE s.hid=h.id  ");
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
		List<Specimen> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 新增标本
	@SuppressWarnings("static-access")
	@Override
	public void save(Specimen specimen) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(specimen);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 根据ID查找标本
	@SuppressWarnings("static-access")
	@Override
	public Specimen findById(String sid) {
		session = hibernateUtil.getSession();
		Specimen specimen = (Specimen) session.get(Specimen.class, sid);
		hibernateUtil.closeSession(session);
		return specimen;
	}

	// 修改标本
	@SuppressWarnings("static-access")
	@Override
	public void update(Specimen specimen) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(specimen);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 删除标本
	@SuppressWarnings("static-access")
	@Override
	public void delete(Specimen specimen) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(specimen);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 查找全部标本
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Specimen> findAll() {
		String hql = "from Specimen";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Specimen> list = query.list();
		return list;
	}

	// 未送检标本个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findsjCount(String id, String pid) {

		StringBuffer hql = new StringBuffer(
				" select count(*) from Specimen where sstate=0 and hdstate=1");
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

	//分页查找未送检标本
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Specimen> findsjByPage(int begin, int pageSize, String id,
			String pid) {
		StringBuffer hql = new StringBuffer(" from Specimen where sstate=0 and hdstate=1 ");
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
		List<Specimen> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

}
