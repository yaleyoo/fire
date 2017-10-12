package com.fes.web.resolver;

import com.fes.common.annotation.CurrentUser;
import com.fes.common.constants.UserType;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;
import com.fes.dao.domain.UserStaff;
import com.fes.dao.domain.UserTrainer;
import com.fes.dao.mappers.UserCustomerMapper;
import com.fes.dao.mappers.UserOrganizationMapper;
import com.fes.dao.mappers.UserStaffMapper;
import com.fes.dao.mappers.UserTrainerMapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * Created by qigege on 2017/10/2.
 */
public class UserInjectResolver implements HandlerMethodArgumentResolver {

    @Resource
    private UserStaffMapper userStaffMapper;

    @Resource
    private UserCustomerMapper userCustomerMapper;

    @Resource
    private UserTrainerMapper userTrainerMapper;

    @Resource
    private UserOrganizationMapper userOrganizationMapper;

    private  final String USERNAME = "username";

    private final String USERTYPE = "usertype";

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.getParameterType().isAssignableFrom(UserCustomer.class)
                ||methodParameter.getParameterType().isAssignableFrom(UserOrganization.class)
                ||methodParameter.getParameterType().isAssignableFrom(UserStaff.class)
                ||methodParameter.getParameterType().isAssignableFrom(UserTrainer.class)){
            if (methodParameter.hasParameterAnnotation(CurrentUser.class)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        if (methodParameter.getParameterType().isAssignableFrom(UserCustomer.class)){
           String userName = (String) nativeWebRequest.getAttribute(USERNAME, RequestAttributes.SCOPE_REQUEST);
           int userType = (int) nativeWebRequest.getAttribute(USERTYPE, RequestAttributes.SCOPE_REQUEST);
           if (userType != UserType.CUSTOMER.getUserType()){
               return null;
           }
           return userCustomerMapper.selectByName(userName);
        }

        if (methodParameter.getParameterType().isAssignableFrom(UserStaff.class)){
            String userName = (String) nativeWebRequest.getAttribute(USERNAME, RequestAttributes.SCOPE_REQUEST);
            int userType = (int) nativeWebRequest.getAttribute(USERTYPE, RequestAttributes.SCOPE_REQUEST);
            if (userType != UserType.STAFF.getUserType()){
                return null;
            }
            return userStaffMapper.getStaff(userName);
        }

        if (methodParameter.getParameterType().isAssignableFrom(UserTrainer.class)){
            String userName = (String) nativeWebRequest.getAttribute(USERNAME, RequestAttributes.SCOPE_REQUEST);
            int userType = (int) nativeWebRequest.getAttribute(USERTYPE, RequestAttributes.SCOPE_REQUEST);
            if (userType != UserType.TRAINER.getUserType()){
                return null;
            }
            return userTrainerMapper.getTrainer(userName);
        }

        if (methodParameter.getParameterType().isAssignableFrom(UserOrganization.class)){
            String userName = (String) nativeWebRequest.getAttribute(USERNAME, RequestAttributes.SCOPE_REQUEST);
            int userType = (int) nativeWebRequest.getAttribute(USERTYPE, RequestAttributes.SCOPE_REQUEST);
            if (userType != UserType.ORGANIZATION.getUserType()){
                return null;
            }
            return userOrganizationMapper.getOrganization(userName);
        }

        return null;
    }
}
