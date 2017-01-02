package com.ricardo.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ricardo.dao.ICchapterDAO;
import com.ricardo.entity.Cchapter;

@Transactional
public class CchapterDAO extends HibernateDaoSupport implements ICchapterDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CchapterDAO.class);
	
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
		log.debug("saving Cchapter instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Cchapter instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cchapter findById(java.lang.String id) {
		log.debug("getting Cchapter instance with id: " + id);
		try {
			Cchapter instance = (Cchapter) currentSession().get(
					"com.ricardo.entity.Cchapter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cchapter> findByExample(Object instance) {
		log.debug("finding Cchapter instance by example");
		try {
			List<Cchapter> results = currentSession()
					.createCriteria("com.ricardo.entity.Cchapter")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Cchapter> findByChIdChN(String chapterId,String chapterName,int offset) {
		log.debug("finding Cchapter instance with property: " + chapterName+" and "+chapterId);
		try {
			String queryString = "from Cchapter as model where "
					+ " model.chapterId like :chapterId "
					+ "and model.chapterName like :chapterName "
					+ " order by model.chapterId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("chapterId", "%"+chapterId+"%");
			queryObject.setParameter("chapterName", "%"+chapterName+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(this.pageSize).list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int calculatePageSize(String chapterId,String chapterName) {
		try {
			String queryString = "from Cchapter as model where "
					+ " model.chapterId like :chapterId "
					+ "and model.chapterName like :chapterName "
					+ " order by model.chapterId";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("chapterId", "%"+chapterId+"%");
			queryObject.setParameter("chapterName", "%"+chapterName+"%");
			List<Cchapter> chapters = queryObject.list();
			recordNumber = chapters.size();
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
	
	

	public List<Cchapter> findAll() {
		log.debug("finding all Cchapter instances");
		try {
			String queryString = "from Cchapter";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cchapter merge(Cchapter detachedInstance) {
		log.debug("merging Cchapter instance");
		try {
			Cchapter result = (Cchapter) currentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Object instance) {
		log.debug("attaching dirty Cchapter instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Cchapter instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}




	
	
}