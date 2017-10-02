package com.fes.biz.impl;

import com.fes.biz.service.IClassService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.ClassPO;
import com.fes.dao.mappers.ClassMapper;
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
}
