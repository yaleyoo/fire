package com.fes.dao.mappers;

import org.apache.ibatis.annotations.Param;

public interface CustomerOrderMapper {
	
	boolean deleteOrderById(@Param("id")int id);
}
