package com.spring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetMsgCountVO {
	
	private String retmsg;
	private int mcount;
	
	public String getLineSplitByTab(){
		return mcount+"	"+retmsg;
	}

}
