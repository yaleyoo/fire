package com.fes.web.exception;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.fes.common.domain.SimpleHttpResult;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

/**
 * Created by qigege on 2017/10/5.
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public SimpleHttpResult handleBindException(BindException e) {

        return new SimpleHttpResult(false, "param error!");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public SimpleHttpResult handleValidationException(MissingServletRequestParameterException e) {

        return new SimpleHttpResult(false, "param error!");
    }


    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public SimpleHttpResult handleException(Exception e) {
        System.out.println(e);
        return new SimpleHttpResult(false, "Service Wrong! Please try again later!");
    }

    /**
     * 503 - Service Unavailable
     */
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(PayPalRESTException.class)
    public SimpleHttpResult handlePaypalException(PayPalRESTException e) {
        System.out.println(e);
        return new SimpleHttpResult(false, "Paypal Service Wrong! Please try again later!");
    }

    /**
     * 401 - UNAUTHORIZED
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JWTDecodeException.class)
    public SimpleHttpResult handlePaypalException(JWTDecodeException e) {
        System.out.println(e);
        return new SimpleHttpResult(false, "Please login first!");
    }

}
