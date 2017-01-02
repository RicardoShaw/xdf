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

import com.ricardo.dao.ISlinkcDAO;
import com.ricardo.entity.Slinkc;

/**
 * A data access object (DAO) providing persistence and search support for
 * Slinkc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ricardo.entity.Slinkc
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SlinkcDAO extends HibernateDaoSupport implements ISlinkcDAO{
	private static final Logger log = LoggerFactory.getLogger(SlinkcDAO.class);
	
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
		log.debug("saving Slinkc instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Slinkc instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Slinkc findById(java.lang.Integer id) {
		log.debug("getting Slinkc instance with id: " + id);
		try {
			Slinkc instance = (Slinkc) currentSession().get(
					"com.ricardo.entity.Slinkc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Slinkc> findByExample(Object instance) {
		log.debug("finding Slinkc instance by example");
		try {
			List results = currentSession()
					.createCriteria("com.ricardo.entity.Slinkc")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	


	public List<Slinkc> findAll() {
		log.debug("finding all Slinkc instances");
		try {
			String queryString = "from Slinkc";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Slinkc merge(Slinkc detachedInstance) {
		log.debug("merging Slinkc instance");
		try {
			Slinkc result = (Slinkc) currentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Object instance) {
		log.debug("attaching dirty Slinkc instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Slinkc instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SlinkcDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SlinkcDAO) ctx.getBean("SlinkcDAO");
	}

	
	public void merge(Object object) {
		log.debug("merging Slinkc instance");
		try {
			currentSession()
					.merge(object);
			log.debug("merge successful");
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
		
	}


	public List<Slinkc> findByClId(String classId) {
		log.debug("finding Slinkc instance with property: classId" + 
				classId);
		try {
			String queryString = "from Slinkc as model where model.cl.classId = :classId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("classId", classId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}

	}


	public List<Slinkc> findBySnCi(String studentName, String classId,
			int offset) {
		log.debug("finding Slinkc instance with property: classId" + 
				classId+" studentName" + studentName);
		try {
			String queryString = "from Slinkc as model where model.cl.classId like :classId"
					+ " and model.student.studentName like :studentName "
					+ " order by model.cl.classId , model.student.studentName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("classId","%"+ classId+"%");
			queryObject.setParameter("studentName","%"+studentName+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public int calculatePageSize(String studentName, String classId) {
		log.debug("finding Slinkc instance with property: classId" + 
				classId+" studentName" + studentName);
		try {
			String queryString = "from Slinkc as model where model.cl.classId like :classId"
					+ " and model.student.studentName like :studentName "
					+ " order by model.cl.classId , model.student.studentName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("classId","%"+ classId+"%");
			queryObject.setParameter("studentName","%"+studentName+"%");
			recordNumber  = queryObject.list().size();
			int mod = recordNumber % pageSize;
			totalPage = recordNumber/pageSize;
			if(mod!=0){
				totalPage++;
			}
			return totalPage;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public int findBySiCi(String studentId, String classId) {
		log.debug("finding Slinkc instance with property: classId" + 
				classId+" studentId" + studentId);
		try {
			String queryString = "from Slinkc as model where model.cl.classId = :classId"
					+ " and model.student.studentId = :studentId "
					+ " order by model.cl.classId , model.student.studentId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("classId", classId);
			queryObject.setParameter("studentId",studentId);
			return queryObject.list().size();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	
}