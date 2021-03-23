package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

//org.zerock.mapper.TimeMapper.getTime2

public interface TimeMapper {
	
	// ; 세미콜론 없어야 한다
	@Select("select sysdate from dual")
	String getTime();
	
	String getTime2();
}
