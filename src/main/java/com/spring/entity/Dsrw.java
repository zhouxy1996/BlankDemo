package com.spring.entity;

public class Dsrw {
	
	private String RWMC;
	private String KSSJ;
	private String JSSJ;
	private String YXJG;
	
	
	public String getJSSJ() {
		return JSSJ;
	}
	public void setJSSJ(String jSSJ) {
		JSSJ = jSSJ;
	}
	public String getRWMC() {
		return RWMC;
	}
	public void setRWMC(String rWMC) {
		RWMC = rWMC;
	}
	public String getKSSJ() {
		return KSSJ;
	}
	public void setKSSJ(String kSSJ) {
		KSSJ = kSSJ;
	}
	public String getYXJG() {
		return YXJG;
	}
	public void setYXJG(String yXJG) {
		YXJG = yXJG;
	}
	public Dsrw(String rWMC, String kSSJ, String yXJG) {
		super();
		RWMC = rWMC;
		KSSJ = kSSJ;
		YXJG = yXJG;
	}
	public Dsrw() {
		super();
	}
	

}
