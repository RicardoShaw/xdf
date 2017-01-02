package com.ricardo.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ricardo.dao.ITlinkcDAO;
import com.ricardo.entity.Tlinkc;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tlinkc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ricardo.entity.Tlinkc
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TlinkcDAO extends HibernateDaoSupport implements ITlinkcDAO{
	private static final Logger log = LoggerFactory.getLogger(TlinkcDAO.class);
	// property constants
	private int totalPage;
	private int recordNumber;
	

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	public void save(Object transientInstance) {
		log.debug("saving Tlinkc instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Tlinkc instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tlinkc findById(java.lang.Integer id) {
		log.debug("getting Tlinkc instance with id: " + id);
		try {
			Tlinkc instance = (Tlinkc) currentSession().get(
					"com.ricardo.entity.Tlinkc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Tlinkc> findByExample(Object instance) {
		log.debug("finding Tlinkc instance by example");
		try {
			List<Tlinkc> results = currentSession()
					.createCriteria("com.ricardo.entity.Tlinkc")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	public List<Tlinkc> findAll() {
		log.debug("finding all Tlinkc instances");
		try {
			String queryString = "from Tlinkc as model"
					+ " order by model.teacher.teacherName and model.cl.className";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public void attachDirty(Object instance) {
		log.debug("attaching dirty Tlinkc instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Tlinkc instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}



	public int findByTiCi(String teacherId, String classId) {
		log.debug("finding Tlinkc instance with property: teacherId and classId");
		try {
			String queryString = "from Tlinkc as model where model.teacher.username = :username and model.cl.classId = :classId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("username", teacherId);
			queryObject.setParameter("classId", classId);
			return queryObject.list().size();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}



	public List<Tlinkc> findByTnCiCnCsCe(String teacherName, String classId,
			String className,String classStartDate,String classEndDate ,int offset) {
		log.debug("finding Tlinkc instance with property: teacherId and classId");
		try {
			String queryString = "from Tlinkc as model where model.teacher.teacherName like :teacherName and model.cl.classId like :classId"
					+ " and model.cl.className like :className and model.cl.classStartDate like :startDate"
					+ " and model.cl.classEndDate like :endDate"
					+ " order by model.teacher.teacherName ,model.cl.className";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("teacherName","%"+ teacherName+"%");
			queryObject.setParameter("classId", "%"+ classId+"%");
			queryObject.setParameter("className", "%"+ className+"%");
			queryObject.setParameter("startDate", classStartDate+"%");
			queryObject.setParameter("endDate", "%"+ classEndDate+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public List<Tlinkc> findByTiCn(String teacherId, String className,String classStartDate,String classEndDate,
			int offset) {
		log.debug("finding Tlinkc instance with property: teacherId and classId");
		try {
			String queryString = "from Tlinkc as model where model.teacher.username = :username"
					+ " and model.cl.className like :className"
					+ " and model.cl.classStartDate like :classStartDate "
					+ " and model.cl.classEndDate like :classEndDate"
					+ " order by model.teacher.teacherName ,model.cl.className";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("username",teacherId);
			queryObject.setParameter("className", "%"+ className+"%");
			queryObject.setParameter("classStartDate","%"+classStartDate+"%");
			queryObject.setParameter("classEndDate","%"+classEndDate+"%");
			int startIndex = (offset-1) * pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public int calculatePageSize(String teacherId, String className,String classStartDate,String classEndDate) {
		log.debug("finding Tlinkc instance with property: teacherId and classId");
		try {
			String queryString = "from Tlinkc as model where model.teacher.username = :username"
					+ " and model.cl.className like :className"
					+ " and model.cl.classStartDate like :classStartDate "
					+ " and model.cl.classEndDate like :classEndDate"
					+ " order by model.teacher.teacherName ,model.cl.className ASC";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("username",teacherId);
			queryObject.setParameter("className", "%"+ className+"%");
			queryObject.setParameter("classStartDate","%"+classStartDate+"%");
			queryObject.setParameter("classEndDate","%"+classEndDate+"%");
			recordNumber = queryObject.list().size();
			int mod = recordNumber % pageSize;
			totalPage = recordNumber/pageSize;
			if(mod != 0){
				totalPage ++;
			}
			return totalPage;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public int calculatePageSize(String teacherName, String classId,
			String className, String classStartDate, String classEndDate) {
		log.debug("finding Tlinkc instance with property: teacherId and classId");
		try {
			String queryString = "from Tlinkc as model where model.teacher.teacherName like :teacherName and model.cl.classId like :classId"
					+ " and model.cl.className like :className "
					+ " and model.cl.classStartDate like :startDate"
					+ " and model.cl.classEndDate like :endDate"
					+ " order by model.teacher.teacherName ,model.cl.className";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("teacherName","%"+ teacherName+"%");
			queryObject.setParameter("classId", "%"+ classId+"%");
			queryObject.setParameter("className", "%"+ className+"%");
			queryObject.setParameter("startDate", "%"+classStartDate+"%");
			queryObject.setParameter("endDate", "%"+ classEndDate+"%");
			recordNumber = queryObject.list().size();
			int mod = recordNumber % pageSize;
			totalPage = recordNumber/pageSize;
			if(mod != 0){
				totalPage++;
			}
			return totalPage;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public void delete(int id) {		
		log.debug("finding Tlinkc instance with property: teacherId and classId");
	try {
		String queryString = "delete Tlinkc as model"
				+ " where model.id = :id";
		Query queryObject = currentSession().createQuery(queryString);
		queryObject.setParameter("id", id);
	} catch (RuntimeException re) {
		log.error("find by property name failed", re);
		throw re;
	}
		
	}


	
}