package com.sps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sps.dao.PatientDao;
import com.sps.entity.Patient;
import com.sps.util.HibernateUtil;

public class PatientDaoImpl implements PatientDao {

	private HibernateUtil hibernateUtil;
	private Session session;

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	// 患者个数
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int findCount(String id) {
		StringBuffer hql = new StringBuffer(
				" select count(*) from Patient where 1=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and pid ='" + id + "'");
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

	// 分页查找所有患者
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Patient> findByPage(int begin, int pageSize, String id) {
		StringBuffer hql = new StringBuffer(" from Patient where 1=1 ");
		if (id != null && !id.equals("")) {
			hql.append(" and pid ='" + id + "'");
		}
		// 获取被Spring托管的session
		session = hibernateUtil.getSession();
		// 获取query对象
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Patient> list = query.list();
		hibernateUtil.closeSession(session);
		return list;
	}

	// 新增患者
	@SuppressWarnings("static-access")
	@Override
	public void save(Patient patient) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(patient);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 根据Id查找患者
	@SuppressWarnings("static-access")
	@Override
	public Patient findById(String pid) {
		session = hibernateUtil.getSession();
		Patient patient = (Patient) session.get(Patient.class, pid);
		hibernateUtil.closeSession(session);
		return patient;
	}

	// 修改患者
	@SuppressWarnings("static-access")
	@Override
	public void update(Patient patient) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(patient);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 删除患者
	@SuppressWarnings("static-access")
	@Override
	public void delete(Patient patient) {
		session = hibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(patient);
		transaction.commit();
		hibernateUtil.closeSession(session);
	}

	// 查找所有患者
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<Patient> findAll() {
		String hql = "from Patient";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		List<Patient> list = query.list();
		return list;
	}

}
