package com.gltv.bigwig.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by VictorJ on 2018/02/11.
 * 
 * 
 * * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 *　　   ┃　　　┃神兽保佑
 * 　　      ┃　　　┃代码无BUG！
 * 　      　┃　　　┗━━━┓
 * 　      　┃　　　　　　　┣┓
 * 　     　┃　　　　　　　┏┛
 * 　     　┗┓┓┏━┳┓┏┛
 *      　　　┃┫┫　┃┫┫
 * 　　     　┗┻┛　┗┻┛
 *
 * 
 */

public class StringUtils {
	/**
	 * 字符串转换为16进制字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String stringToHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/**
	 * 16进制字符串转换为字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String hexStringToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "gbk");
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	public static String[] stringSpilt(String s, int len) {
		int spiltNum;// len->想要分割获得的子字符串的长度
		int i;
		int cache = len;// 存放需要切割的数组长度
		spiltNum = (s.length()) / len;
		String[] subs;// 创建可分割数量的数组
		if ((s.length() % len) > 0) {
			subs = new String[spiltNum + 1];
		} else {
			subs = new String[spiltNum];
		}

		// 可用一个全局变量保存分割的数组的长度
		// System.out.println(subs.length);
		// int leng = subs.length;
		int start = 0;
		if (spiltNum > 0) {
			for (i = 0; i < subs.length; i++) {
				if (i == 0) {
					subs[0] = s.substring(start, len);
					start = len;
				} else if (i > 0 && i < subs.length - 1) {
					len = len + cache;
					subs[i] = s.substring(start, len);
					start = len;
				} else {
					subs[i] = s.substring(len, s.length());
				}
			}
		}
		return subs;
	}
	/*方法二：推荐，速度最快
	  * 判断是否为整数 
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/

	  public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	  }
	  public static boolean isEmpty(String str){
	        if(str == null || "".equals(str)){
	            return true;
	        }
	        return false;
	    }

	    public static boolean isNotEmpty(String str){
	        if(str != null && !"".equals(str)){
	            return true;
	        }
	        return false;
	    }

	    public static boolean isBlank(String str){
	        if(str == null || "".equals(str.trim())){
	            return true;
	        }
	        return false;
	    }

	    public static boolean isNotBlank(String str){
	        if(str != null && !"".equals(str.trim())){
	            return true;
	        }
	        return false;
	    }

	    /**
	     * 判断是否是数字
	     * @param str
	     * @return
	     */
	    public static boolean isNumber(String str){
	        String regex = "^[0-9]+\\.{0,1}[0-9]{0,2}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(str);
	        return matcher.matches();
	    }

	    /**
	     * 判断是否是整数
	     * @param str
	     * @return
	     */
	   /* public static boolean isInteger(String str){
	        String regex = "^[0-9]*$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(str);
	        return matcher.matches();
	    }*/

	    /**
	     * 至少num个字符
	     * @param str
	     * @param num
	     * @return
	     */
	    public static boolean atLeast(String str,int num){
	        String regex = "^\\d{"+num+",}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(str);
	        return matcher.matches();
	    }

	    /**
	     * 是否是邮箱
	     * @param str
	     * @return
	     */
	    public static boolean isEmail(String str){
	        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(str);
	        return matcher.matches();
	    }

	    /**
	     * 是否是字母或数字
	     * @param str
	     * @return
	     */
	    public static boolean isLetterOrDigit(String str){
	        String regex = "^[A-Za-z0-9]+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(str);
	        return matcher.matches();
	    }

	    /**
	     * 是否是字母
	     * @param str
	     * @return
	     */
	    public static boolean isLetter(String str){
	        String regex = "^[A-Za-z]+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(str);
	        return matcher.matches();
	    }

	    /**
	     * 判断昵称是否符合，只能中文、字母、数字、下划线(_)、短横线(-)
	     * @param str
	     * @return
	     */
	    public static boolean checkNickname(String str){
	        String regex = "^[a-zA-Z0-9_\\-\\u4e00-\\u9fa5]+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(str);
	        return matcher.matches();
	    }
	    
	    
	    /**  
	     * 十六进制转换字符串 
	     * @param String str Byte字符串(Byte之间无分隔符 如:[616C6B]) 
	     * @return String 对应的字符串 
	     * @throws UnsupportedEncodingException 
	     */    
	    public static String hexStr2Str(String hexStr) throws UnsupportedEncodingException  
	    {    
	        String str = "0123456789abcdef";    
	        char[] hexs = hexStr.toCharArray();    
	        byte[] bytes = new byte[hexStr.length() / 2];    
	        int n;    

	        for (int i = 0; i < bytes.length; i++)  
	        {    
	            n = str.indexOf(hexs[2 * i]) * 16;    
	            n += str.indexOf(hexs[2 * i + 1]);    
	            bytes[i] = (byte) (n & 0xff);    
	        }    
	        return new String(bytes,"utf-8");    
	    } 
	    public static String str2HexStr(String str) throws UnsupportedEncodingException  
	    {    

	        char[] chars = "0123456789ABCDEF".toCharArray();    
	        StringBuilder sb = new StringBuilder("");  
	        byte[] bs = str.getBytes("utf-8");    
	        int bit;    

	        for (int i = 0; i < bs.length; i++)  
	        {    
	            bit = (bs[i] & 0x0f0) >> 4;    
	            sb.append(chars[bit]);    
	            bit = bs[i] & 0x0f;    
	            sb.append(chars[bit]);  
	          //  sb.append(' ');  
	        }    
	        return sb.toString().trim();    
	    }
	    
//	    public static void main(String[] args) throws UnsupportedEncodingException {
//	    	String str = "E59388E59388E59388E59388";
//	    	
//	    	System.out.println(hexStr2Str(str.toLowerCase()));
//	    	
//	    	String str1 = "哈哈哈哈";
//	    	
//	    	System.out.println(str2HexStr(str1));
//		}

}
