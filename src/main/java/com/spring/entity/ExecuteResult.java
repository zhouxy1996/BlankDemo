package com.spring.entity;

import java.util.List;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExecuteResult {
	

	@Excel(name = "ip")
	private String ip;
	
	@Excel(name = "描述")
	private String desc;
	
	@Excel(name = "命令")
	private String exeCommand;
	
	@Excel(name = "结果1")
	private String exeResult;
	
	
	@Excel(name = "命令2")
	private String exeCommand2;
	
	@Excel(name = "结果2")
	private String exeResult2;
	
	
	@Excel(name = "备注")
	private String custnote;
	
	public void setExeResultList(List<String> list){
		StringBuffer sbf = new StringBuffer();
		for (String line : list) {
			sbf.append(line+"\n");
		}
		this.exeResult = sbf.toString();
	}
	
	
	public void setExeResult2List(List<String> list){
		StringBuffer sbf = new StringBuffer();
		for (String line : list) {
			sbf.append(line+"\n");
		}
		this.exeResult2 = sbf.toString();
	}
	
	

}
