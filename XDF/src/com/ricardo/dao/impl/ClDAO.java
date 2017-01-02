package com.ricardo.dao.impl;

import java.util.List;
import java.util.Set;

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

import com.ricardo.dao.IClDAO;
import com.ricardo.entity.Cl;

/**
 * A data access object (DAO) providing persistence and search support for Cl
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ricardo.entity.Cl
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ClDAO extends HibernateDaoSupport implements IClDAO{
	private static final Logger log = LoggerFactory.getLogger(ClDAO.class);
	// property constants
	private int totalPage;
    private int recordNumber;
    
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public void save(Object transientInstance) {
		log.debug("saving Cl instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Cl instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cl findById(java.lang.String id) {
		log.debug("getting Cl instance with id: " + id);
		try {
			Cl cl =   (Cl) currentSession().get("com.ricardo.entity.Cl", id);
			return cl;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cl> findByExample(Object instance) {
		log.debug("finding Cl instance by example");
		try {
			List<Cl> results = currentSession()
					.createCriteria("com.ricardo.entity.Cl")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}


	public List<Cl> findAll() {
		log.debug("finding all Cl instances");
		try {
			String queryString = "from Cl as model"
					+ " order by model.classId ,model.className,model.classStartDate,model.classEndDate";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cl merge(Cl detachedInstance) {
		log.debug("merging Cl instance");
		try {
			Cl result = (Cl) currentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Object instance) {
		log.debug("attaching dirty Cl instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Cl instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Cl> findByClNameClStartDateClEndDate(String className,
			String startDate, String endDate, int offset) {
		log.debug("finding all Cl instances");
		try {
			String queryString = "from Cl as model where "
					+ " model.className like :className"
					+ " and model.classStartDate like :classStartDate"
					+ " and model.classEndDate like :classEndDate "
					+ " order by model.classId ,model.className,model.classStartDate,model.classEndDate";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("className", "%"+className+"%");
			queryObject.setParameter("classStartDate", "%"+startDate+"%");
			queryObject.setParameter("classEndDate", "%"+endDate+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public int calculatePageSize(String className, String startDate,
			String endDate) {
		log.debug("finding all Cl instances");
		try {
			String queryString = "from Cl as model where "
					+ " model.className like :className"
					+ " and model.classStartDate like :classStartDate"
					+ " and model.classEndDate like :classEndDate "
					+ " order by model.classId ,model.className,model.classStartDate,model.classEndDate";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("className", "%"+className+"%");
			queryObject.setParameter("classStartDate", "%"+startDate+"%");
			queryObject.setParameter("classEndDate", "%"+endDate+"%");
			recordNumber = queryObject.list().size();
            int mod = recordNumber % this.pageSize;
            totalPage = recordNumber / this.pageSize;
            if(mod != 0) 
            {totalPage++;}
            return totalPage;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


}