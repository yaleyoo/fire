package com.fes.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fes.common.constants.EnvironmentConstant;
import com.fes.common.constants.UserType;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * Created by qigege on 2017/10/11.
 */
public class MailCodeManager {

    private static final long EXPIRE_TIME = 30;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
    public  String createVerifyToken(String username, int userType) {

        String code = VerifyCodeUtil.generateVerifyCode(6);
        stringRedisTemplate.opsForValue().set(username+userType+"verifycode",code,EXPIRE_TIME, TimeUnit.MINUTES);
        return code;
    }
    public boolean verifyCode(String srcCode, String username, int usertype) {
        if (srcCode == null){
            return false;
        }
        String code = stringRedisTemplate.opsForValue().get(username+usertype+"verifycode");
        if(code == null){
            return false;
        }
        return code.equals(srcCode);
    }
    public void deleteToken(String username, int userType){
        stringRedisTemplate.delete(username+userType+"verifycode");
    }
    public static void main(String[] args){
        Algorithm hc256 = null;
        try {
            hc256 = Algorithm.HMAC256("abc");
            JWTVerifier jwtVerifier = JWT.require(hc256).build();
            DecodedJWT decodedJWT = jwtVerifier.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InRlc3QxIiwiaXNzIjoiZmVzIiwiYXVkIjoiZmVzIGNsaWVudCIsInVzZXJUeXBlIjoyfQ.NRauVBMcbG76wTYhj8HoVbmWkgIiqBLC2xDFbAovspQ");
            String username = decodedJWT.getClaim("username").asString();
            System.out.println(username);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }



}


