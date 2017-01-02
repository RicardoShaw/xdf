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

import com.ricardo.dao.IColinkchDAO;
import com.ricardo.entity.Colinkch;

/**
 * A data access object (DAO) providing persistence and search support for
 * Colinkch entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ricardo.entity.Colinkch
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ColinkchDAO extends HibernateDaoSupport implements IColinkchDAO{
	private static final Logger log = LoggerFactory
			.getLogger(ColinkchDAO.class);
	
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
		log.debug("saving Colinkch instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Colinkch instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Colinkch findById(java.lang.Integer id) {
		log.debug("getting Colinkch instance with id: " + id);
		try {
			Colinkch instance = (Colinkch) currentSession().get(
					"com.ricardo.entity.Colinkch", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Colinkch> findByExample(Object instance) {
		log.debug("finding Colinkch instance by example");
		try {
			List results = currentSession()
					.createCriteria("com.ricardo.entity.Colinkch")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	public List<Colinkch> findAll() {
		log.debug("finding all Colinkch instances");
		try {
			String queryString = "from Colinkch as model"
					+ " order by model.course.courseName,model.cchapter.chapterId";
			Query queryObject = currentSession().createQuery(queryString);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}



	public void attachDirty(Object instance) {
		log.debug("attaching dirty Colinkch instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Colinkch instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	public List<Colinkch> findByCnCn(String courseName,
			String chapterName, int offset) {
		log.debug("finding all Colinkch instances by property : courseName and chapterName");
		try {
			String queryString = "from Colinkch as model where "
					+ " model.course.courseName like :courseName "
					+ " and model.cchapter.chapterName like :chapterName"
					+ " order by model.course.courseName,model.cchapter.chapterId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("courseName", "%"+courseName+"%");
			queryObject.setParameter("chapterName", "%"+chapterName+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(this.pageSize).list();
		} catch (RuntimeException re) {
			log.error("find list failed", re);
			throw re;
		}
	}

	
	public int calculatePageSize(String courseName, String chapterName) {
		log.debug("finding all Colinkch instances by property : courseName and chapterName");
		try {
			String queryString = "from Colinkch as model where "
					+ " model.course.courseName like :courseName "
					+ " and model.cchapter.chapterName like :chapterName"
					+ " order by model.course.courseName,model.cchapter.chapterId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("courseName", "%"+courseName+"%");
			queryObject.setParameter("chapterName", "%"+chapterName+"%");
			recordNumber =queryObject.list().size();
			int mod = recordNumber % pageSize;
			totalPage = recordNumber / pageSize;
			if(mod != 0){
				totalPage++;
			}
			return totalPage;
		} catch (RuntimeException re) {
			log.error("find list failed", re);
			throw re;
		}
	}


	public int findByCiCi(String courseId, String chapterId) {
		log.debug("finding all Colinkch instances by property : courseId and chapterId");
		try {
			String queryString = "from Colinkch as model where "
					+ " model.course.courseId = :courseId "
					+ " and model.cchapter.chapterId = :chapterId"
					+ " order by model.course.courseName,model.cchapter.chapterId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("courseId", courseId);
			queryObject.setParameter("chapterId", chapterId);
			return queryObject.list().size();
		} catch (RuntimeException re) {
			log.error("find list failed", re);
			throw re;
		}
	}





}