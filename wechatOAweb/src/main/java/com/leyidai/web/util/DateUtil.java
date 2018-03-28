package com.leyidai.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leyidai.web.util.CategoryConstants;
import com.leyidai.entity.Dictionary;

/**
 * 时间工具类
 * 所有跟时间相关的工具集合
 * @author Administrator
 *
 */
@Component
public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * 时间格式
	 * @author Administrator
	 *
	 */
	public enum DateFormat{
		YYYY_MM_DD_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
		YYYY_MM_DD("yyyy-MM-dd"),
		YYYYMMDDHHMMSS("yyyyMMddHHmmss"),
		YYYYMMDDCHINESE("yyyy年MM月dd日"),
		MM_DD("MM-dd"),
		YYYY("yyyy"),
		MM("MM"),
		DD("dd");
		
		private String value;
		DateFormat(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
	}
	/**
	 * 当前时间
	 * @param format
	 * @return
	 */
	public String getCurrentTime(DateFormat format){
		
		Date date = new Date();// 当前日期
		SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());// 格式化对象
		return sdf.format(date);
	}
	
	/**
	 * 格式化时间
	 * @param format
	 * @return
	 */
	public String getFormatTime(String time, DateFormat format){
		
		SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());// 格式化对象
		
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date!=null?sdf.format(date):time;
	}
	
	/**
	 * 过去时间
	 * @param time
	 * @return
	 */
	public boolean isPassedTime(String time){
		boolean result = false;
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.YYYY_MM_DD_HH_mm_ss.getValue());
		try {
			
			Date date = sdf.parse(time);
			result = date.getTime() <= new Date().getTime();
		} catch (ParseException e) {
			
			log.error("please parse correct format time {}", time);
		}
		
		return result;
	}
	
	/**
	 * 时间相减  开始时间 paramSystemTime 系统时间
	 * 
	 * @return 时间相减工具方法 Second(秒) 
	 */
	public int timeSubtractionSecond(String paramSystemTime,String startTime) {
		int resultTime = 0;// 结果时间
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat.YYYY_MM_DD_HH_mm_ss.getValue());// 格式化对象
		Calendar calSystem = Calendar.getInstance();// 系统时间
		Calendar calStart = Calendar.getInstance();// 开始时间
		try {
			calSystem.setTime(sdf.parse(paramSystemTime));
			calStart.setTime(sdf.parse(startTime));
			long l=calStart.getTimeInMillis()-calSystem.getTimeInMillis();
			resultTime=new Long(l/1000).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("时间相减  开始时间 paramSystemTime 系统时间 {},{}", paramSystemTime + startTime);
		}
		
		return resultTime;
	}
	/**
	 * 时间相差天数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public int betweenDays(String startTime,String endTime) {
		
		int seconds = timeSubtractionSecond(startTime, endTime);
		return seconds/60/60/24;
	}
	
	/**
	 * 在日期上减去天数
	 * @param date
	 * @param dateFormat
	 * @param numDay
	 * @return
	 */
	public String subDayOfMonth(String date, DateFormat dateFormat, int numDay){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - numDay);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}

	/**
	 * 日期加上天数
	 * @param date
	 * @param dateFormat
	 * @param numDay
	 * @return
	 */
	public String addDayOfMonth(String date, DateFormat dateFormat, int numDay){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + numDay);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}
	
	/**
	 * 日期减月数
	 * @param date
	 * @param dateFormat
	 * @param monthNum
	 * @return
	 */
	public String subMonth(String date, DateFormat dateFormat, int monthNum){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) - monthNum);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}
	
	/**
	 * 日期加上月数
	 * @param date
	 * @param dateFormat
	 * @param monthNum
	 * @return
	 */
	public String addMonth(String date, DateFormat dateFormat, int monthNum){
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(df.parse(date));
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) + monthNum);
			
			return df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.print(e);
			return null;
		}
	}
	
	/** 
	 * 得到当月天数 
	 */  
	public int getCurrentMonthLastDay()  
	{  
	    Calendar a = Calendar.getInstance();  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    int maxDate = a.get(Calendar.DATE);  
	    return maxDate;  
	}  
	
	/**
	 * 得到当月第一天是星期几
	 * @return
	 */
	public int getCurrentMonthFirstWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 得到当月第一天的年月日
	 * @return
	 */
	public String getCurrentMonthFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return format.format(c.getTime());
	}
	
	/** 
	 * 得到指定月的天数 
	 * */  
	public int getMonthLastDay(int year, int month)  
	{  
	    Calendar a = Calendar.getInstance();  
	    a.set(Calendar.YEAR, year);  
	    a.set(Calendar.MONTH, month - 1);  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    int maxDate = a.get(Calendar.DATE);  
	    return maxDate;  
	}  
	
	/**
	 * 得到当前年份
	 * @return
	 */
	public int getCurrentYear(){
		Date date = new Date();  
        String year = new SimpleDateFormat("yyyy").format(date);  
        return Integer.parseInt(year); 
	}
	
	/**
	 * 得到当前月份
	 * @return
	 */
	public int getCurrentMonth(){
		Date date = new Date();  
        String month = new SimpleDateFormat("MM").format(date);  
        return Integer.parseInt(month);  
	}
	
	/**
	 * 得到当前日期
	 * @return
	 */
	public int getCurrentDay(){
		Date date = new Date();  
        String month = new SimpleDateFormat("dd").format(date);  
        return Integer.parseInt(month);  
	}
	
	/**
	 * 得到上月月份
	 * @return
	 */
	public int getLastMonth(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.get(Calendar.MONTH);
		
		return cal.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 得到上月天数
	 * @return
	 */
	public int getLastMonthDay(){
		//取得系统当前时间
		Calendar cal = Calendar.getInstance();
		//取得系统当前时间所在月第一天时间对象
		cal.set(Calendar.DAY_OF_MONTH, 1);
		//日期减一,取得上月最后一天时间对象
		cal.add(Calendar.DAY_OF_MONTH, -1);
		//输出上月最后一天日期
		return cal.get(Calendar.DATE);
	}
	
	/** 
	 * 取得当月天数 
	 * */  
	public int getCurrentMonthDay()  
	{  
	    Calendar a = Calendar.getInstance();  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    int maxDate = a.get(Calendar.DATE);  
	    return maxDate;  
	} 
	
	/**
	 * 在日期上减去天数, 返回 月数
	 * @param date
	 * @param dateFormat
	 * @param numDay
	 * @return
	 * @throws ParseException 
	 */
	public int subDayOfMonthNum(String date, DateFormat dateFormat, int numDay) throws ParseException{
		
		SimpleDateFormat df = new SimpleDateFormat(dateFormat.getValue());
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(date));
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - numDay);
		String month =  new SimpleDateFormat("MM").format(date);
		
		return Integer.parseInt(month);
	}
	
	/**
	 * 得到当天是星期几
	 * @return
	 */
	public int getCurrentDayWeek(){
		Date date = new Date();  
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return w;
	}
	/**
	 * 获取当前月最后一天是周几
	 */
	public int getlastMonthDayWeek(){
        Calendar ca = Calendar.getInstance();    
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
        int w = ca.get(Calendar.DAY_OF_WEEK) - 1;
        return w;
	}

	/**
	 * 转换格式
	 * @param time
	 * @param format
	 * @param formatOut
	 * @return
	 */
	public String changeFormatTime(String time, DateFormat format, DateFormat formatOut){
		
		SimpleDateFormat sdf = new SimpleDateFormat(format.getValue());// 格式化对象
		SimpleDateFormat sdfOut = new SimpleDateFormat(formatOut.getValue());
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date!=null?sdfOut.format(date):time;
	}
	

	
	/**
	 * 
	 * @param -02-02格式
	 * @return 日期
	 */
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String date = sdf.format(calendar.getTime());
		
		return date;
	}
	
}
