package com.spring.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

@Data
public class EnvVO implements java.io.Serializable{
	
	@Excel(name = "应用IP")//name 属性需要与Excel中的表头保持一致，比如 姓名*中的 * 号就不能省略掉
	private String ip;

	@Excel(name = "启动domain")
	private String startDomain;
	
	@Excel(name = "ptype")
	private String ptype;
	
	@Excel(name = "启动node")
	private String startNode;
	
	@Excel(name = "停止进程")
	private String killJavaProcess;
	
	@Excel(name = "应用部署地址")
	private String deployments;
	
	@Excel(name = "模块名称")
	private String moduleName;
	
	@Excel(name = "日志地址")
	private String userlog;
	
	@Excel(name = "节点")
	private String nodeName;
	
	@Excel(name = "IP访问地址")
	private String ipUrl;


	
	
	

}
