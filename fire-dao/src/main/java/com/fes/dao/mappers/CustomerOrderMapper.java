package com.fes.dao.mappers;

import org.apache.ibatis.annotations.Param;

import com.fes.dao.domain.CustomerOrder;

public interface CustomerOrderMapper {
	
	boolean deleteOrderById(@Param("id")int id);
	
	CustomerOrder selectById(@Param("id")int id);
}
