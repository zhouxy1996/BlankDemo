package com.spring.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ServerStatus {

	
	private String hostname;
	private String ip;
	private boolean isConn;
	
	private String scriptFirst = "admin@/home/admin->top";
	private List<String> resultFirst = new ArrayList<String>();
	
	private String scriptSecond = "mount";
	private List<String> resultSecond = new ArrayList<String>();
	
	private String scriptThird = "admin@/home/admin->df -h";
	private List<String> resultThird = new ArrayList<String>();
	
	
	private List<String> tail = new ArrayList<String>();
	private List<String> diskUsageGrowthRate = new ArrayList<String>();
	
	private List<String> error = new ArrayList<String>();
	private List<String> remark = new ArrayList<String>();
	Map<Object, Object> ret = new TreeMap<>();
	private String desc;
	private boolean showPopover = false;
	@SuppressWarnings("unused")
	private int imgLength = 1000;
	private int mountCount = -1;

	public boolean isShowPopover() {
		return showPopover;
	}

	public void setShowPopover(boolean showPopover) {
		this.showPopover = showPopover;
	}

	public void isConn(boolean isconn) {
		this.isConn = isconn;
	}

	public boolean isConn() {
		return this.isConn;
	}

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}

	public void addError(String error) {
		if (this.error == null) {
			this.error = new ArrayList<String>();
		}
		this.error.add(error);
	}

	/**
	 * 
	 *
	 * Description: 使用此方法时，list不能做修改删除操作
	 * @author zxy
	 * @date 2020年10月13日
	 *
	 */
	public void addTail(String tail) {
		if (this.tail == null) {
			this.tail = new ArrayList<String>();
		}
		this.tail.add(tail);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<String> getResultFirst() {
		return resultFirst;
	}

	public void setResultFirst(List<String> resultFirst) {
		this.resultFirst = resultFirst;
	}

	public List<String> getResultThird() {
		return resultThird;
	}

	public void setResultThird(List<String> resultThird) {
		this.resultThird = resultThird;
	}

	public List<String> getTail() {
		return tail;
	}

	public void setTail(List<String> tail) {
		this.tail = tail;
	}
	
	public void addTail(List<String> tail) {
		this.tail.addAll(tail);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "\"{ip:\"" + ip + "\",isConn:" + isConn + "}\"";
	}

	public int getImgLength() {

		return 85 + 30 * 4 + (resultFirst.size() + resultThird.size() + tail.size() + error.size()) * 25;
	}

	public int getMountCount() {
		return mountCount;
	}

	public void setMountCount(int mountCount) {
		this.mountCount = mountCount;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Map<Object, Object> getRet() {
		return ret;
	}

	public void setRet(Map<Object, Object> ret) {
		this.ret = ret;
	}

	public List<String> getResultSecond() {
		return resultSecond;
	}

	public void setResultSecond(List<String> resultSecond) {
		this.resultSecond = resultSecond;
	}

	public List<String> getRemark() {
		return remark;
	}

	public void setRemark(List<String> remark) {
		this.remark = remark;
	}
	
	public void addRemark(String remark) {
		this.remark.add(remark);
	}

	public List<String> getDiskUsageGrowthRate() {
		return diskUsageGrowthRate;
	}

	public void setDiskUsageGrowthRate(List<String> diskUsageGrowthRate) {
		this.diskUsageGrowthRate = diskUsageGrowthRate;
	}
	
	public void addDiskUsageGrowthRate(String diskUsageGrowthRate) {
		this.diskUsageGrowthRate.add(diskUsageGrowthRate);
	}

	public String getScriptFirst() {
		return scriptFirst;
	}

	public void setScriptFirst(String scriptFirst) {
		this.scriptFirst = scriptFirst;
	}

	public String getScriptSecond() {
		return scriptSecond;
	}

	public void setScriptSecond(String scriptSecond) {
		this.scriptSecond = scriptSecond;
	}

	public String getScriptThird() {
		return scriptThird;
	}

	public void setScriptThird(String scriptThird) {
		this.scriptThird = scriptThird;
	}
	

}
