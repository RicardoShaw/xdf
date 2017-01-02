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

import com.ricardo.dao.IStudentDAO;
import com.ricardo.entity.Student;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ricardo.entity.Student
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class StudentDAO extends HibernateDaoSupport implements IStudentDAO{
	private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
	
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
		log.debug("saving Student instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Student instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Student findById(java.lang.String id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) currentSession().get(
					"com.ricardo.entity.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Student> findByExample(Object instance) {
		log.debug("finding Student instance by example");
		try {
			List<Student> results = currentSession()
					.createCriteria("com.ricardo.entity.Student")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void attachDirty(Object instance) {
		log.debug("attaching dirty Student instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Student instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	
	public List<Student> findAll() {
		log.debug("find all");
		try {
			String query = "from Student as model "
					+ " order by model.studentId ,model.studentName";
			Query queryObject = currentSession().createQuery(query);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	
	public List<Student> findBySnSt(String studentName, String studentPhone,
			int offset) {
		log.debug("finding Student instance with  StudentName: " + studentName+" and StudentPhone:"+studentPhone);
		try {
			String queryString = "from Student as model where model.studentName like :studentName"
					+ " and model.studentTelephone like :studentPhone "
					+ " order by model.studentId,model.studentName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("studentName", "%"+studentName+"%");
			queryObject.setParameter("studentPhone", "%"+studentPhone+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public int calculatePageSize(String studentName, String studentPhone) {
		log.debug("finding Student instance with  StudentName: " + studentName+" and StudentPhone:"+studentPhone);
		try {
			String queryString = "from Student as model where model.studentName like :studentName"
					+ " and model.studentTelephone like :studentPhone "
					+ " order by model.studentId , model.studentName";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("studentName", "%"+studentName+"%");
			queryObject.setParameter("studentPhone", "%"+studentPhone+"%");
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

	
	
	
}