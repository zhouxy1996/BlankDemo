package com.spring.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;



public class DsrwVO {
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	
	//序号	系统模块名称	任务名称	任务功能详细描述	任务实现方式	服务器IP	任务实现对应的脚本或代码位置	执行频率	任务是否成功检查标准
	@Excel(name = "序号")
	private String seq;
	@Excel(name = "系统模块名称")
	private String systemName;
	
	@Excel(name = "任务名称")
	private String scheduleName;
	
	@Excel(name = "任务功能详细描述")
	private String scheduleDesc;
	
	@Excel(name = "任务实现方式")
	private String implementationMode;
	
	@Excel(name = "服务器IP")
	private String serverIp;
	
	@Excel(name = "任务实现对应的脚本或代码位置")
	private String locate;
	
	@Excel(name = "执行频率")
	private String times;
	
	@Excel(name = "任务是否成功检查标准")
	private String check;
	
	@Excel(name = "检查时间")
	private String checkTime = df.format(new Date());
	
	@Excel(name = "检查结果")
	private String checkResult = "";
	
	
	// 此处注意必须要有空构造函数，否则会报错“对象创建错误”
	public DsrwVO() {
		
	}
	
	


	public DsrwVO(SimpleDateFormat df, String seq, String systemName, String scheduleName, String scheduleDesc,
			String implementationMode, String serverIp, String locate, String times, String check, String checkTime,
			String checkResult) {
		super();
		this.df = df;
		this.seq = seq;
		this.systemName = systemName;
		this.scheduleName = scheduleName;
		this.scheduleDesc = scheduleDesc;
		this.implementationMode = implementationMode;
		this.serverIp = serverIp;
		this.locate = locate;
		this.times = times;
		this.check = check;
		this.checkTime = checkTime;
		this.checkResult = checkResult;
	}




	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getSystemName() {
		return systemName;
	}


	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}


	public String getScheduleName() {
		return scheduleName;
	}


	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}


	public String getScheduleDesc() {
		return scheduleDesc;
	}


	public void setScheduleDesc(String scheduleDesc) {
		this.scheduleDesc = scheduleDesc;
	}


	public String getImplementationMode() {
		return implementationMode;
	}


	public void setImplementationMode(String implementationMode) {
		this.implementationMode = implementationMode;
	}


	public String getServerIp() {
		return serverIp;
	}


	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}


	public String getLocate() {
		return locate;
	}


	public void setLocate(String locate) {
		this.locate = locate;
	}


	public String getTimes() {
		return times;
	}


	public void setTimes(String times) {
		this.times = times;
	}


	public String getCheck() {
		return check;
	}


	public void setCheck(String check) {
		this.check = check;
	}


	public String getCheckTime() {
		return checkTime;
	}


	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}


	public String getCheckResult() {
		return checkResult;
	}


	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	
	
	
	


	
	
	
	
}
