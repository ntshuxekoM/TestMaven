package com.moconsulting.helper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.activation.UnsupportedDataTypeException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected final Log logger = LogFactory.getLog(this.getClass());

	public abstract AbstractDataProvider getDataProvider();

	public Session getSession() {
		return getDataProvider().getSession();
	}

	public void create(IDataEntity entity) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			create(entity, session);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void createBatch(List<IDataEntity> entityList) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (IDataEntity entity : entityList)
				create(entity, session);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void updateBatch(List<IDataEntity> entityList) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (IDataEntity entity : entityList)
				update(entity, session);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void update(IDataEntity entity) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			update(entity, session);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void delete(IDataEntity entity) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			delete(entity, session);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void deleteBatch(List<IDataEntity> entityList) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (IDataEntity entity : entityList)
				delete(entity, session);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void create(IDataEntity entity, Session session) throws Exception {
		session.save(entity);
	}

	public void update(IDataEntity entity, Session session) throws Exception {
		session.update(entity);
	}

	public void delete(IDataEntity entity, Session session) throws Exception {
		session.delete(entity);
	}

	private void addParameter(Query query, String key, Object value) {
		query.setParameter(key, value);
	}
	
	protected List<?> getList(String hql) {
		return getList(hql, null);
	}
	
	@SuppressWarnings("unchecked")
	protected List<?> getListColumn(String hql) {
		List<Object> result = null;
		Session session = getSession();
		try {
			org.hibernate.Query query = session.createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
		return result;
	}

	protected List<?> getList(String hql, int noRows) {
		return getList(hql, null, noRows);
	}
	@SuppressWarnings("unchecked")
	protected List<?> getList(String hql, Map<String, Object> parameters) {
		List<Object> result = null;
		Session session = getSession();
		try {
			Query query = (Query) session.createQuery(hql);
			if (parameters != null)
				for (String key : parameters.keySet())
					addParameter(query, key, parameters.get(key));
			result = query.getResultList();
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected List<?> getList(String hql, Map<String, Object> parameters, int noRows) {
		List<Object> result = null;
		Session session = getSession();
		try {
			Query query = (Query) session.createQuery(hql);
			if (parameters != null)
				for (String key : parameters.keySet())
					addParameter(query, key, parameters.get(key));
			query.setMaxResults(noRows);
			result = query.getResultList();
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected List<?> getList(String hql, Map<String, Object> parameters, int startingAt, int maxPerPage) {
		List<Object> result = null;
		Session session = getSession();
		try {
			Query query = (Query) session.createQuery(hql);
			if (parameters != null)
				for (String key : parameters.keySet())
					addParameter(query, key, parameters.get(key));
			query.setFirstResult(startingAt);
			query.setMaxResults(maxPerPage);
			result = query.getResultList();
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
		return result;
	}

	protected Object getUniqueResult(String hql) {
		return getUniqueResult(hql, null);
	}

	protected Object getUniqueResult(String hql, Map<String, Object> parameters) {
		Object result = null;
		Session session = getSession();
		try {
			Query query = (Query) session.createQuery(hql);
			if (parameters != null)
				for (String key : parameters.keySet())
					addParameter(query, key, parameters.get(key));
			result = query.getSingleResult();// uniqueResult();
		} catch (javax.persistence.NoResultException ne) {
			logger.info("No result exception!");
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected long getNextFromSequence(String sequence) throws Exception {
		Session session = getSession();
		try {
			String sql = "select (nextval for " + sequence + ") from users fetch first 1 rows only";
			List<Object> l = session.createSQLQuery(sql).list();
			for (Object o : l) {
				if (o instanceof BigInteger)
					return ((BigInteger) o).longValue();
				if (o instanceof BigDecimal)
					return ((BigDecimal) o).longValue();
				else if (o instanceof Long)
					return ((Long) o).longValue();
				else if (o instanceof Integer)
					return ((Integer) o).longValue();
				else if (o instanceof Short)
					return ((Short) o).longValue();
				else
					throw new UnsupportedDataTypeException("No sequence cast defined for " + o.getClass().toString());
			}
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return 0l;
	}

	@SuppressWarnings("rawtypes")
	protected long getLastSeqNr(String hql) {
		long nr = 0;
		try {
			List array = (List) getList(hql);
			for (Object o : array) {
				if (o instanceof Integer)
					try {
						nr = ((Integer) o).longValue();
					} catch (java.lang.NullPointerException np) {
					}
				else if (o instanceof Short)
					try {
						nr = ((Short) o).longValue();
					} catch (java.lang.NullPointerException np) {
					}
				else if (o instanceof Long)
					try {
						nr = ((Long) o).longValue();
					} catch (java.lang.NullPointerException np) {
					}
			}
			nr++;
		} catch (Exception e) {
			logger.fatal(e);
		}
		return nr;
	}
	
	protected Object oneRow(String hql) {
		Object result = null;
		Session session = getSession();
		try {
			Query query = (Query) session.createQuery(hql);
			query.setMaxResults(1);
			result = query.getSingleResult();
		} catch (javax.persistence.NoResultException ne) {
			logger.info("No result exception!");
		} catch (HibernateException e) {
			throw e;
		} finally {
			session.close();
		}
		return result;
	}

	public void nonSelectSql(String sql) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.createSQLQuery(sql).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Long count(Class<?> entity) throws Exception {
		return (Long) getUniqueResult("select count(o) from " + entity.getName() + " o ");
	}

	public int count(Class<?> entity, Map<String, Object> filters) {
		String hql = "select count(o) from " + entity.getName() + " o ";
		if (filters != null) {
			boolean ft = true;
			Map<String, Object> parms = new HashMap<String, Object>();
			String hvar = null;
			for (Entry<String, Object> entry : filters.entrySet()) {
				hvar = entry.getKey();
				if (hvar.contains(".")) {
					hvar = hvar.replaceAll("\\.", "");
					parms.put(hvar, entry.getValue());
				} else {
					parms.put(entry.getKey(), entry.getValue());
				}
				if (ft) {
					hql += " where o." + entry.getKey() + " like " + " :" + hvar;
					ft = false;
				} else {
					hql += " and o." + entry.getKey() + " like " + " :" + hvar;
				}
			}
			filters = parms;
		}
		return ((Long) getUniqueResult(hql, filters)).intValue();
	}


}
