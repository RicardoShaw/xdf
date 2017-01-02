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
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.transaction.annotation.Transactional;

import com.ricardo.dao.ITeacherDAO;
import com.ricardo.entity.Teacher;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ricardo.entity.Teacher
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TeacherDAO extends HibernateDaoSupport implements ITeacherDAO{
	private static final Logger log = LoggerFactory.getLogger(TeacherDAO.class);
	
	private int recordNumber;
	private int totalPage;
	
	
	

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void save(Object transientInstance) {
		log.debug("saving Teacher instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Teacher instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacher findById(java.lang.String id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) currentSession().get(
					"com.ricardo.entity.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Teacher> findByExample(Object instance) {
		log.debug("finding Teacher instance by example");
		try {
			List<Teacher> results = currentSession()
					.createCriteria("com.ricardo.entity.Teacher")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	public List<Teacher> findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher as model"
					+ "  order by  model.username , model.teacherName";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public void attachDirty(Object instance) {
		log.debug("attaching dirty Teacher instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Teacher instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	
	public int findByTiTp(String teacherId, String teacherPsw) {
		log.debug("finding Admin instance with proporites:  teacherId and password");
		try {
			String queryString = "from Teacher as model where model.username = :username and model.password=:password";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("username", teacherId);
			queryObject.setParameter("password",teacherPsw);
			return queryObject.list().size();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}



	public List<Teacher> findByTnTt(String teacherName, String teacherTelephone,int offset) {
		log.debug("finding Admin instance with proporites:  teacherName and teacherTelephone");
		try {
			String queryString = "from Teacher as model where model.teacherName  like :teacherName and model.teacherPhone  like  :teacherTelephone"
					+ "  order by  model.username , model.teacherName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("teacherName", "%"+teacherName+"%");
			queryObject.setParameter("teacherTelephone","%"+teacherTelephone+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ricardo.dao.ITeacherDAO#calculatePageSize(java.lang.String, java.lang.String)
	 */
	@Override
	public int calculatePageSize(String teacherName, String teacherTelephone) {
		log.debug("finding Admin instance with proporites:  teacherName and teacherTelephone");
		try {
			String queryString = "from Teacher as model where model.teacherName  like :teacherName and model.teacherPhone  like  :teacherTelephone"
					+ "  order by  model.username , model.teacherName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("teacherName", "%"+teacherName+"%");
			queryObject.setParameter("teacherTelephone","%"+teacherTelephone+"%");
			recordNumber = queryObject.list().size();
			int mod = recordNumber % pageSize;
			totalPage = recordNumber/pageSize;
			if(mod != 0){
				totalPage ++;
			}
			return totalPage ;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	
	
	

}