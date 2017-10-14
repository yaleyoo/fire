package com.fes.dao.mappers;

import org.apache.ibatis.annotations.Param;

import com.fes.dao.domain.ClassItemPO;

/**
 * Created by qigege on 2017/9/3.
 */
public interface ClassItemMapper {
	ClassItemPO getClassItemPO(@Param("classId")int classId);
}
