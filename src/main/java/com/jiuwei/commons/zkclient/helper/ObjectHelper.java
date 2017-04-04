package com.jiuwei.commons.zkclient.helper;

/**
 * java对象相关操作辅助类
 *
 * @author  cpthack cpt@jianzhimao.com
 * @date    Jul 22, 2016 3:40:58 PM <br/>
 * @version 
 * @since   JDK 1.7
 */
public final class ObjectHelper {
  
  /**
   * <b>isNull</b> <br/>
   * 
   * 判断传入的java对象是否为null，是返回ture，否返回false
   * 
   * @author cpthack  cpt@jianzhimao.com
   * @return 
   *
   */
  public static boolean isNull(Object obj){
    return null == obj;
  }
  
  /**
   * 
   * <b>isNotNull</b> <br/>
   * 判断传入的java对象是否不为null，是返回ture，否返回false
   * 
   * @author cpthack  cpt@jianzhimao.com
   * @param obj
   * @return 
   *
   */
  public static boolean isNotNull(Object obj){
    return !isNull(obj);
  }
}
