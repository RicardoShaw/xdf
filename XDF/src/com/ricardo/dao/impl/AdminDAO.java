package com.ricardo.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ricardo.dao.IAdminDAO;
import com.ricardo.entity.Admin;


@Transactional
public class AdminDAO extends HibernateDaoSupport implements IAdminDAO{
	private static final Logger log = LoggerFactory
			.getLogger(AdminDAO.class);
	
	private int totalPage;
	private int recordNumber;
	
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}


	public void save(Object transientInstance) {
		log.debug("saving Admin instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	
	public void delete(Object persistentInstance) {
		log.debug("deleting Admin instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	
	public Admin findById(java.lang.String id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = (Admin) currentSession().get(
					"com.ricardo.entity.Admin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	public List<Admin> findByExample(Object instance) {
		log.debug("finding Admin instance by example");
		try {
			List results = currentSession()
					.createCriteria("com.ricardo.entity.Admin")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	
	public List<Admin> findByProperty(String propertyName, Object value) {
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admin as model where model."
					+ propertyName + "= :propertyvalue";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("propertyvalue", value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	public List<Admin> findByPassword(Object password) {
		return findByProperty("password", password);
	}

	
	public List<Admin> findAll() {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	
	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
		try {
			Admin result = (Admin) currentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	
	public void attachDirty(Object instance) {
		log.debug("attaching dirty Admin instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	public void attachClean(Object instance) {
		log.debug("attaching clean Admin instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	
	public int findByNP(Admin admin) {
		return findByNP(admin.getUsername(),admin.getPassword());
	}

	public int findByNP(String username, String password) {
		log.debug("finding Admin instance with proporites: username and password");
		try {
			String queryString = "from Admin as model where model.username= :username and model.password=:password";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("username", username);
			queryObject.setParameter("password",password);
			return queryObject.list().size();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}


	public int getTotalPage() {
		return this.totalPage;
	}

	public int getRecordNumber() {
		return this.recordNumber;
	}
	

}