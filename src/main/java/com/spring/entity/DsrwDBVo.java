package com.spring.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DsrwDBVo {
	
	@Excel(name = "模块")
	private String moduledesc;
	@Excel(name = "任务号")
	private String rwh;
	@Excel(name = "任务名称")
	private String rwmc;
	@Excel(name = "任务描述")
	private String rwms;
	@Excel(name = "Cron表达式")
	private String cbds;
	@Excel(name = "启用标志")
	private String qybz;
	@Excel(name = "任务状态")
	private String rwzt;
	@Excel(name = "最近成功一条的开始时间")
	private String kssj;
	@Excel(name = "最近成功一条的结束时间")
	private String jssj;
	@Excel(name = "运行结果")
	private String yxjg;
	
	
	

}
