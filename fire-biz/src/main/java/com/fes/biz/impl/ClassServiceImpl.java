package com.fes.biz.impl;

import com.fes.biz.service.IClassService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.ClassItemPO;
import com.fes.dao.domain.ClassPO;
import com.fes.dao.mappers.ClassItemMapper;
import com.fes.dao.mappers.ClassMapper;
import com.fes.dao.mappers.UserTrainerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigege on 2017/10/2.
 */
public class ClassServiceImpl implements IClassService {

    @Resource
    private ClassMapper classMapper;

    @Resource
	private UserTrainerMapper userTrainerMapper;
    
    @Resource
    private ClassItemMapper classItemMapper;

    @Override
    public ResponseEntity filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice ) throws ParseException {
        SimpleHttpResult<List<ClassPO>> httpResult = new SimpleHttpResult<>();
        List<ClassPO> result = new ArrayList();
        try {
            Date classTime = null;
            if (!"".equals(classStartTime.toString())) {
                SimpleDateFormat format =  new SimpleDateFormat("yyyy-mm-dd");
                classTime = new Date(format.parse(classStartTime).getTime());
            }

            result = classMapper.filter(courseID, classAddr, classTime, minPrice, maxPrice);

        } catch(ParseException e) {
            throw e;
        }


        if (result == null) {
            httpResult.setSuccess(false, "The class does not exist.");
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }

        httpResult.setData(result);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }
    @Override
    public ResponseEntity getAll() {
    		SimpleHttpResult<List<ClassPO>> httpResult = new SimpleHttpResult<List<ClassPO>>();
    		List<ClassPO> list = classMapper.getAll();
    		if(list == null) {
    			httpResult.setSuccess(false, "no any classes available now");
    			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
    		}
    		httpResult.setData(list);
    		return new ResponseEntity(httpResult, HttpStatus.OK);
    		
    }
    @Override
    public ResponseEntity getClassByCourseId(int courseId) {
    		SimpleHttpResult<List<ClassPO>> httpResult = new SimpleHttpResult<List<ClassPO>>();
    		List<ClassPO> list = classMapper.getClassListByCourseId(courseId);
    		if(list == null) {
    			httpResult.setSuccess(false, "no any classes available for this course");
    			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
    		}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    		for(ClassPO result: list){
				Date startTime = result.getClassStartTime();
				String strTime = simpleDateFormat.format(startTime);
				result.setStrTime(strTime);
			}
    		httpResult.setData(list);
    		return new ResponseEntity(httpResult, HttpStatus.OK);
    }
    @Override
    public ResponseEntity getClassById(int id) {
		SimpleHttpResult<ClassPO> httpResult = new SimpleHttpResult();
		ClassPO result = classMapper.getClassById(id);
		if(result == null) {
			httpResult.setSuccess(false, "no results");
			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date startTime = result.getClassStartTime();
		String strTime = simpleDateFormat.format(startTime);
		result.setStrTime(strTime);
		httpResult.setData(result);
		return new ResponseEntity(httpResult, HttpStatus.OK);
    }
    @Override
    public ResponseEntity getClassByDate(String date) {
    		SimpleHttpResult<List<ClassPO>> httpResult  = new SimpleHttpResult<List<ClassPO>>();
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    		java.util.Date d = null;
    		try {
    			d = format.parse(date);
    		} catch (Exception e) {
    			httpResult.setSuccess(false, "invalid date format");
    			return new ResponseEntity(httpResult, HttpStatus.UNPROCESSABLE_ENTITY);
    		}
    		Date classDate = new Date(d.getTime());
    		List<ClassPO> list = classMapper.getClassByDate(classDate);
    		if(list == null) {
    			httpResult.setSuccess(false, "no results");
    			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
    		}
    		httpResult.setData(list);
    		return new ResponseEntity(httpResult, HttpStatus.OK);
    		
    }
    @Override
    public ResponseEntity deleteClass(int courseId, int classId) {
    		SimpleHttpResult httpResult = new SimpleHttpResult();
    		if(classMapper.deleteClass(courseId, classId)) {
    			httpResult.setSuccess(true);
    			return new ResponseEntity(httpResult, HttpStatus.OK);
    		}
    		httpResult.setSuccess(false, "delete failed!");
    	    return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }
    
    @Override
    public ResponseEntity createClass(ClassPO classPO) {
    		SimpleHttpResult httpResult = new SimpleHttpResult();
    		if(classMapper.createClass(classPO)) {
    			httpResult.setSuccess(true);
    			return new ResponseEntity(httpResult, HttpStatus.OK);
    		}
    		httpResult.setSuccess(false, "create failed!");
    	    return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }
    
    @Override
    public ResponseEntity modifyClass(int courseId, int classId, ClassPO classPO) {
    		SimpleHttpResult httpResult = new SimpleHttpResult();
    		if(classMapper.modifyClass(courseId, classId, classPO)) {
    			httpResult.setSuccess(true);
    			return new ResponseEntity(httpResult, HttpStatus.OK);
    		}
    		httpResult.setSuccess(false, "modify failed");
    		return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public ResponseEntity getClassItem(int classId) {

		SimpleHttpResult<List<ClassItemPO>> httpResult = new SimpleHttpResult();
		List<ClassItemPO> classItemPO = classItemMapper.getClassItemByClassId(classId);
		if(classItemPO==null || classItemPO.isEmpty()) {
			httpResult.setSuccess(false, "no results");
			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (ClassItemPO classItemPO1: classItemPO){
			String strTime = sdf.format(classItemPO1.getClassDate());
			classItemPO1.setStrDate(strTime);
		}
		httpResult.setData(classItemPO);
		return new ResponseEntity(httpResult, HttpStatus.OK);
    }
}
