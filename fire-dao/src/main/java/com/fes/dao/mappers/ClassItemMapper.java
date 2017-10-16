package com.fes.dao.mappers;

import org.apache.ibatis.annotations.Param;

import com.fes.dao.domain.ClassItemPO;

import java.util.List;

/**
 * Created by qigege on 2017/9/3.
 */
public interface ClassItemMapper {

	List<ClassItemPO> getClassItemByClassId(@Param("classId")int classId);

	List<ClassItemPO> getClassItemByClassIds(@Param("classIds")List<String> classIds);
}
