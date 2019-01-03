package com.gltv.bigwig.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class weekUtils {
	/**
	     * 获取指定日期所在周的第一天和最后一天,用下划线连接
	     * @param dataStr
	     * @return
	     * @throws ParseException
	     */
	    public static String getFirstAndLastOfMonth(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
	        //获取当前月第一天：
	        Calendar c = Calendar.getInstance();
	        c.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
	        c.add(Calendar.MONTH, 0);
	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
	        String first = new SimpleDateFormat(resultDateFormat).format(c.getTime());
	        System.out.println("===============first:"+first);
	
	        //获取当前月最后一天
	        Calendar ca = Calendar.getInstance();
	        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
	        String last = new SimpleDateFormat(resultDateFormat).format(ca.getTime());
	        System.out.println("===============last:"+last);
	        return first+"_"+last;
	    }
	
	    /**
	     * 每周的第一天和最后一天
	     * @param dataStr
	     * @param dateFormat
	     * @param resultDateFormat
	     * @return
	     * @throws ParseException
	     */
	    public static String[] getFirstAndLastOfWeek(String dataStr,String dateFormat,String resultDateFormat) throws ParseException {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new SimpleDateFormat(dateFormat).parse(dataStr));
	        int d = 0;
	        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
	            d = -6;
	        } else {
	            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
	        }
	        cal.add(Calendar.DAY_OF_WEEK, d);
	        // 所在周开始日期
	        cal.add(Calendar.DAY_OF_WEEK, 1);
	        String data1 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
	        cal.add(Calendar.DAY_OF_WEEK, 7);
	        // 所在周结束日期
	        String data2 = new SimpleDateFormat(resultDateFormat).format(cal.getTime());
	        
	        String[] trn = {data1,data2};
	        return trn;
	
	    }
	    public static Date getNextDay(Date date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			date = calendar.getTime();
			return date;
		}
	    
	    
//	    public static void main(String[] args) throws ParseException {
//	    	String data = getFirstAndLastOfWeek("20190129","yyyyMMdd","yyyyMMdd");
//	    	System.out.println("======"+data);
//		}
}

