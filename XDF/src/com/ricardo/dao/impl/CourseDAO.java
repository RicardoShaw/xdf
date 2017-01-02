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

import com.ricardo.dao.ICourseDAO;
import com.ricardo.entity.Course;

/**
 * A data access object (DAO) providing persistence and search support for
 * Course entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ricardo.entity.Course
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CourseDAO extends HibernateDaoSupport implements ICourseDAO{
	private static final Logger log = LoggerFactory.getLogger(CourseDAO.class);

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
		log.debug("saving Course instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Course instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Course findById(java.lang.String id) {
		log.debug("getting Course instance with id: " + id);
		try {
			Course instance = (Course) currentSession().get(
					"com.ricardo.entity.Course", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Course> findByExample(Object instance) {
		log.debug("finding Course instance by example");
		try {
			List<Course> results = currentSession()
					.createCriteria("com.ricardo.entity.Course")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}




	public List<Course> findAll() {
		log.debug("finding all Course instances");
		try {
			String queryString = "from Course as model"
					+ " order by model.courseId,model.courseName";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Course merge(Course detachedInstance) {
		log.debug("merging Course instance");
		try {
			Course result = (Course) currentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Object instance) {
		log.debug("attaching dirty Course instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Course instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Course> findByCoIdCoName(String courseId, String courseName,
			int offset) {
		log.debug("finding Course instance with property: courseId courseName" );
		try {
			String queryString = "from Course as model where "
					+ "model.courseId like :courseId"
					+ " and model.courseName like :courseName"
					+ " order by model.courseId,model.courseName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("courseId","%"+courseId+"%");
			queryObject.setParameter("courseName", "%"+courseName+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(this.pageSize).list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public int calculatePageSize(String courseId, String courseName) {
		log.debug("finding Course instance with property: courseId courseName" );
		try {
			String queryString = "from Course as model where "
					+ "model.courseId like :courseId"
					+ " and model.courseName like :courseName"
					+ " order by model.courseId,model.courseName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("courseId","%"+courseId+"%");
			queryObject.setParameter("courseName", "%"+courseName+"%");
			recordNumber = queryObject.list().size();
            int mod = recordNumber % this.pageSize;
            totalPage = recordNumber / this.pageSize;
            if(mod != 0) 
            {totalPage++;}
            return totalPage;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}



	

}