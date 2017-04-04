package com.jiuwei.commons.zkclient.helper;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import com.google.common.base.Preconditions;

/**
 * 字符串相关操作辅助类
 * 
 * @author  cpthack cpt@jianzhimao.com
 * @date    Jul 22, 2016 3:34:16 PM <br/>
 * @version 
 * @since   JDK 1.7
 */
public final class StringHelper {
  
  /**
   * 
   * <b>isNullOrEmpty</b> <br/>
   * 判断传入的原字符串是否为null或空串，是则返回默认值，否返回原值
   * 
   * @author cpthack  cpt@jianzhimao.com
   * @param value 原字符串
   * @param defaultValue  默认字符串
   * @return
   *
   */
  public static String isNullOrEmpty(String value, String defaultValue){
    if(isNullOrEmpty(value)){
      return defaultValue;
    }
    
    return value;
  }
  
  /**
   * 
   * 判断字符串是否为空（null或者空串)<br/>
   * <b>example:</b><br/>
   * <p>
   * isEmpty(null)->true<br/>
   * isEmpty("")->true<br/>
   * isEmpty(" ")->true<br/>
   * isEmpty("abc")->false
   * </p>
   * <br/>
   * 
   * @author jun
   * @param str
   * @return
   * @since JDK 1.7
   */
  public static boolean isNullOrEmpty(String str) {
      return null == str || "".equals(str);
  }

  /**
   * <b>newString</b> <br/>
   * 
   * @author cpthack  cpt@jianzhimao.com
   * @param forPath
   * @param charset
   * @return
   * 
   */
  public static String newString(byte[] bytes, String charset) {
	  if(ObjectHelper.isNull(bytes)){
      return "";
    }
    
    String str = "";
    try {
      str = new String(bytes, charset);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    return str;
  }

  /**
   * <b>getBytes</b> <br/>
   * 
   * @author cpthack  cpt@jianzhimao.com
   * @param data
   * @param charset
   * @return
   * 
   */
  public static byte[] getBytes(String data, String charset) {
    return data.getBytes(Charset.forName(charset));
  }
  
  /**
   * 
   * <b>leftPad</b> <br/>
   * 根据指定长度和字符串在左边填充字符串<br/>
   * 当传入的字符串长度大于maxLen的值时，则会原值返回 <br/>
   * <pre>
   * leftPad("123", 10, "0")==>"0000000123"
   * </pre>
   * @author cpthack  cpt@jianzhimao.com
   * @param str
   * @param maxLen
   * @param symbol
   * @return
   *
   */
  public static String leftPad(String str, int maxLen, String symbol) {
    Preconditions.checkArgument(!isNullOrEmpty(symbol), "传入填充字符串不能为空");
    
    int len = str.length();
    int num = maxLen - len;
    if(num <= 0){
      return str;
    }
    
    for (int i = 0; i < num; i++) {
        str = symbol + str;
    }
    return str;
  }  
  
}
