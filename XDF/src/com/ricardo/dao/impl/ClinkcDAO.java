package com.ricardo.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ricardo.dao.IClinkcDAO;
import com.ricardo.entity.Clinkc;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clinkc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ricardo.entity.Clinkc
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ClinkcDAO extends HibernateDaoSupport implements IClinkcDAO{
	private static final Logger log = LoggerFactory.getLogger(ClinkcDAO.class);
	
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
		log.debug("saving Clinkc instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Clinkc instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clinkc findById(java.lang.Integer id) {
		log.debug("getting Clinkc instance with id: " + id);
		try {
			Clinkc instance = (Clinkc) currentSession().get(
					"com.ricardo.entity.Clinkc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Clinkc> findByExample(Object instance) {
		log.debug("finding Clinkc instance by example");
		try {
			List results = currentSession()
					.createCriteria("com.ricardo.entity.Clinkc")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	public List<Clinkc> findAll() {
		log.debug("finding all Clinkc instances");
		try {
			String queryString = "from Clinkc as model "
					+ "order by model.cl.classId,model.course.courseId";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Clinkc merge(Clinkc detachedInstance) {
		log.debug("merging Clinkc instance");
		try {
			Clinkc result = (Clinkc) currentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Object instance) {
		log.debug("attaching dirty Clinkc instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Clinkc instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public int findByCiCi(String classId, String courseId) {
		log.debug("finding all Clinkc instances");
		try {
			String queryString = "from Clinkc as model where "
					+ " model.cl.classId = :classId "
					+ " and model.course.courseId = :courseId"
					+ " order by model.cl.classId,model.course.courseId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("classId", classId);
			queryObject.setParameter("courseId", courseId);
			return queryObject.list().size();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public List<Clinkc> findByCnCn(String className, String courseName,
			int offset) {
		log.debug("finding all Clinkc instances");
		try {
			String queryString = "from Clinkc as model where "
					+ " model.cl.className like :className "
					+ " and model.course.courseName like :courseName"
					+ " order by model.cl.classId,model.course.courseId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("className", "%"+className+"%");
			queryObject.setParameter("courseName", "%"+courseName+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public int calculatePageSize(String className, String courseName) {
		log.debug("finding all Clinkc instances");
		try {
			String queryString = "from Clinkc as model where "
					+ " model.cl.className like :className "
					+ " and model.course.courseName like :courseName"
					+ " order by model.cl.classId,model.course.courseId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("className", "%"+className+"%");
			queryObject.setParameter("courseName", "%"+courseName+"%");
			recordNumber = queryObject.list().size();
			int mod = recordNumber % pageSize;
			totalPage = recordNumber/pageSize;
			if(mod != 0){
				totalPage++;
			}
			return totalPage;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	
	
}