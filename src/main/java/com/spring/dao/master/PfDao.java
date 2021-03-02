package com.spring.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spring.entity.PF023VO;
import com.spring.entity.Pf023ByRetmsg;
import com.spring.entity.RetMsgCountVO;

public interface PfDao {
	
	
	@Select("select 1 from dual")
	List<PF023VO> findYwl();
	
	
	
	
	

}
