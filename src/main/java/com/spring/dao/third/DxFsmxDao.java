package com.spring.dao.third;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.spring.entity.DxFsmx;

public interface DxFsmxDao {
	
	@Select("select 1 from dual")
	public List<DxFsmx> queryFailDetail();

}
