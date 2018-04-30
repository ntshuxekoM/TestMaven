package com.moconsulting.helper;

public class MySQLProvider extends AbstractDataProvider
{
  private static final long serialVersionUID = 1L;

  public MySQLProvider() {
	  super();
  }
  
  @Override
  protected String getConfigFileName() {
    return "hibernate.cfg.xml";
  }

}
