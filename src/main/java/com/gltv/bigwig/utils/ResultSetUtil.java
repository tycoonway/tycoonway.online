package com.gltv.bigwig.utils;

import java.util.Hashtable;


/**
 * json工具类
 * @author Administrator
 *
 */
public final class ResultSetUtil{
	/**返回状态标识*/
	private Long code;
	/**返回结果【成功失败】*/
	private String status;
	/**数据集合[data:...]*/
	private Hashtable<String,Object> data;
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Hashtable<String, Object> getData() {
		return data;
	}
	public void setData(Hashtable<String, Object> data) {
		this.data = data;
	}
	
	private ResultSetUtil(Long code, String status, Hashtable<String, Object> data) {
		this.code = code;
		this.status = status;
		this.data = data;
	}
	private static ResultSetUtil  result = null;
	public  static final ResultSetUtil resultSet(Long code, String status, Hashtable<String, Object> data){
		synchronized (ResultSetUtil.class) {
				result = new ResultSetUtil(code, status, data);
			return result;
		}
	}
}
