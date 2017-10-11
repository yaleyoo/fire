package com.fes.dao.mappers;

import org.apache.ibatis.annotations.Param;

import com.fes.dao.domain.Order;

public interface OrderMapper {
	
	boolean deleteOrderById(@Param("id")int id);
	
	Order selectById(@Param("id")int id);
}
