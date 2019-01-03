package com.gltv.bigwig.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/** 
	   * 将java.util.Date 格式转换为字符串格式'yyyyMMddHHmmss'(24小时制)<br> 
	   * 如Sat May 11 17:23:22 CST 2002 to '2002-05-11 05:23:22'<br> 
	   * @param time Date 日期<br> 
	   * @param x int 任意整数如：1<br> 
	   * @return String 字符串<br> 
	   */ 
	public static String dateToString(Date time){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat ("yyyyMMddHHmmss"); 
	    String ctime = formatter.format(time); 
	    return ctime; 
	} 
}
