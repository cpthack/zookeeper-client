package com.jiuwei.commons.zkclient.exception;


/**
 *
 * @author  cpthack cpt@jianzhimao.com
 * @date    Aug 6, 2016 3:24:02 PM <br/>
 * @version 
 * @since   JDK 1.7
 */
public class ZookeeperException extends ApplicationException {

  private static final long serialVersionUID = 2501309603238090961L;
  
  /**
   * @param string
   */
  
  public ZookeeperException(String message) {
    super(message);
  }

}
