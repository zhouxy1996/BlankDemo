package com.spring.dao.second;

import org.apache.ibatis.annotations.Select;

import com.spring.entity.Dsrw;

public interface NgdbDsrwrzDao {
	
	
	
	@Select("select 1 from dual  where rwmc = #{rwmc}  and rownum<=1 ORDER BY KSSJ DESC")
	Dsrw selectGDZHXX(String scheduleName);
	
	

}
