package com.fes.dao.mappers;

import java.sql.Date;
import java.util.List;

import com.fes.dao.domain.UserTrainer;
import org.apache.ibatis.annotations.Param;

import com.fes.dao.domain.ClassPO;

/**
 * Created by qigege on 2017/9/3.
 */
public interface ClassMapper {
	List<ClassPO> filter(@Param("courseID")int courseID, @Param("classAddr")String classAddr, @Param("classStartTime")Date classStartTime, @Param("minPrice")int minPrice, @Param("maxPrice")int maxPrice);
	
	List<ClassPO> getAll();
	
	List<ClassPO> getClassListByCourseId(@Param("courseId")int courseId);
	
	ClassPO getClassById(@Param("id")int id);
	
	List<ClassPO> getClassByDate(@Param("classStartTime")Date classStartTime);

	List<ClassPO> getClassByIds(@Param("ids") List<String> ids);
	
	boolean deleteClass(@Param("courseId")int courseId, @Param("classId")int classId);
	
	boolean createClass(ClassPO classPO);

	boolean updateTutorInfo(UserTrainer userTrainer);
	
	boolean modifyClass(@Param("courseId")int courseId, @Param("classId")int classId, ClassPO classPO);

}
