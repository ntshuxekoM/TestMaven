package com.moconsulting.helper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;

public class DataProviderFactory implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  private static DataProviderFactory instance;
  
  /**
   * Return the singleton instance.
   * 
   * @return
   */
  public static DataProviderFactory getInstance()
  {
    if (instance==null)
      createInstance();
    return instance;
  }
  
  /**
   * Create the singleton instance.
   * 
   */
  private static synchronized void createInstance()
  {
    instance = new DataProviderFactory();
  }
  
  private static Map<String, SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
  
  /**
   * Private constructor to force singleton.
   * 
   */
  private DataProviderFactory()
  {
    
  }
  
  /**
   * Return SessionFactory with specified id from available map.
   * 
   * @param id
   * @return
   */
  public SessionFactory getSessionFactory(String id)
  {
    if (sessionFactoryMap.containsKey(id))
      return sessionFactoryMap.get(id);
    return null;
  }
  
  /**
   * Add SessionFactory with specified id to available map.
   * 
   * @param id
   * @param sessionFactory
   */
  public void putSessionFactory(String id, SessionFactory sessionFactory)
  {
    if (!sessionFactoryMap.containsKey(id))
      sessionFactoryMap.put(id, sessionFactory);
  }
}
