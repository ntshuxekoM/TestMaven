package com.moconsulting.helper;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDataProvider implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected abstract String getConfigFileName();
  
  public AbstractDataProvider() {
	  createSessionFactory();
  }
  
  private void createSessionFactory() {
    if (DataProviderFactory.getInstance().getSessionFactory(getConfigFileName()) == null) {
        Configuration configuration = new Configuration();
        configuration.configure(getConfigFileName());
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        DataProviderFactory.getInstance().putSessionFactory(getConfigFileName(), sessionFactory); 
    }
  }

  public SessionFactory getSessionFactory() {
	  return DataProviderFactory.getInstance().getSessionFactory(getConfigFileName());
  }
  
  public Session getSession() {
	  return getSessionFactory().openSession();
  }
}
