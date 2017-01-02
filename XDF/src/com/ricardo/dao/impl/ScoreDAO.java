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

import com.ricardo.dao.IScoreDAO;
import com.ricardo.entity.Score;

/**
 * A data access object (DAO) providing persistence and search support for Score
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ricardo.entity.Score
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ScoreDAO extends HibernateDaoSupport implements IScoreDAO{
	private static final Logger log = LoggerFactory.getLogger(ScoreDAO.class);
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
		log.debug("saving Score instance");
		try {
			currentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Object persistentInstance) {
		log.debug("deleting Score instance");
		try {
			currentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Score findById(java.lang.Integer id) {
		log.debug("getting Score instance with id: " + id);
		try {
			Score instance = (Score) currentSession().get(
					"com.ricardo.entity.Score", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Score> findByExample(Object instance) {
		log.debug("finding Score instance by example");
		try {
			List<Score> results = currentSession()
					.createCriteria("com.ricardo.entity.Score")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	


	

	public List<Score> findAll() {
		log.debug("finding all Score instances");
		try {
			String queryString = "from Score as model order by model.cl.classId, model.courseId,model.chapterId,model.hwscore DESC,model.dtscore DESC";
			Query queryObject = currentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Score merge(Score detachedInstance) {
		log.debug("merging Score instance");
		try {
			Score result = (Score) currentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Object instance) {
		log.debug("attaching dirty Score instance");
		try {
			currentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Object instance) {
		log.debug("attaching clean Score instance");
		try {
			currentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	public List<Score> findBySnCnCnCn(String studentName, String classId,
			String chapterName, int offset) {
		log.debug("finding all Score by className , chapterId and studentName");
		try {
			String queryString = "from Score as model "
					+ " where  model.student.studentName like :studentName"
					+ " and model.cl.classId like :classId   "
					+ " and model.chapterName like :chapterName"
					+ " order by model.cl.classId, model.courseName,model.chapterName,model.dtscore DESC";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("studentName","%"+studentName+"%");
			queryObject.setParameter("classId", "%"+classId+"%");
			queryObject.setParameter("chapterName","%"+chapterName+"%");
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}

	/* (non-Javadoc)
	 * @see com.ricardo.dao.IScoreDAO#calculatePageSize(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int calculatePageSize(String studentName, String classId,
			String chapterName) {
		log.debug("finding all Score by className , chapterId and studentName");
		try {
			String queryString = "from Score as model "
					+ " where  model.student.studentName like :studentName"
					+ " and model.cl.classId like :classId   "
					+ " and model.chapterName like :chapterName"
					+ " order by model.cl.classId, model.courseName,model.chapterName,model.dtscore DESC";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("studentName","%"+studentName+"%");
			queryObject.setParameter("classId", "%"+classId+"%");
			queryObject.setParameter("chapterName","%"+chapterName+"%");
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


	public List<Score> findBySnCnCnCnDt(String studentName, String classId,
			String chapterName, float dtupperlimit, float dtlowerlimit,
			int offset) {
		log.debug("finding all Score by className , chapterId and studentName");
		try {
			String queryString = "from Score as model "
					+ " where  model.student.studentName like :studentName"
					+ " and model.cl.classId like :classId   "
					+ " and model.chapterName like :chapterName"
					+ " and model.dtscore <= :upperlimit"
					+ " and model.dtscore >= :lowerlimit"
					+ " order by model.cl.classId, model.courseName,model.chapterName,model.dtscore DESC";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("studentName","%"+studentName+"%");
			queryObject.setParameter("classId","%"+classId+"%");
			queryObject.setParameter("chapterName","%"+chapterName+"%");
			queryObject.setParameter("upperlimit", dtupperlimit);
			queryObject.setParameter("lowerlimit", dtlowerlimit);
			int startIndex = (offset-1) * this.pageSize;
			return queryObject.setFirstResult(startIndex).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} 
	}


	public int calculatePageSize(String studentName, String classId,
			String chapterName, float dtupperlimit, float dtlowerlimit) {
		log.debug("finding all Score by className , chapterId and studentName");
		try {
			String queryString = "from Score as model "
					+ " where  model.student.studentName like :studentName"
					+ " and model.cl.classId like :classId   "
					+ " and model.chapterName like :chapterName"
					+ " and model.dtscore <= :upperlimit"
					+ " and model.dtscore >= :lowerlimit"
					+ " order by model.cl.classId, model.courseName,model.chapterName,model.dtscore DESC";
			Query queryObject = currentSession().createQuery(queryString);
			queryObject.setParameter("studentName","%"+studentName+"%");
			queryObject.setParameter("classId","%"+classId+"%");
			queryObject.setParameter("chapterName","%"+chapterName+"%");
			queryObject.setParameter("upperlimit", dtupperlimit);
			queryObject.setParameter("lowerlimit", dtlowerlimit);
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