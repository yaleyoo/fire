package com.fes.dao.mappers;

import org.apache.ibatis.annotations.Param;

import com.fes.dao.domain.Order;

import java.util.List;

public interface OrderMapper {
	
	boolean deleteOrderById(@Param("id")int id);
	
	Order selectById(@Param("id")int id);

	boolean insert(Order order);

	List<Order> selectByUserNameAndUserType(@Param("username")String username,@Param("usertype")int usertype);
}
