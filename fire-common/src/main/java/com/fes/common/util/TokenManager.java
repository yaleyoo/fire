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
 * Created by qigege on 2017/9/19.
 */
public class TokenManager {

    private static final long EXPIRE_TIME = 30;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public  String createToken(String username, int userType, int userId) throws UnsupportedEncodingException {
        try {
            Algorithm hc256 = Algorithm.HMAC256(EnvironmentConstant.getAppSecret());
            String token = JWT.create().withIssuer("fes").withAudience("fes client")
                    .withClaim("username",username).withClaim("userType",userType).withClaim("userId", userId)
                    .withClaim("timestamp", System.currentTimeMillis()).sign(hc256);
            stringRedisTemplate.opsForValue().set(username+userType,token,EXPIRE_TIME,TimeUnit.MINUTES);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean verifyToken(String token, UserType[] userTypes, HttpServletRequest httpServletRequest) throws Exception {
        try {
            if (token == null){
                return false;
            }
            Algorithm hc256 = Algorithm.HMAC256(EnvironmentConstant.getAppSecret());
            JWTVerifier jwtVerifier = JWT.require(hc256).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            String username = decodedJWT.getClaim("username").asString();
            int userType = decodedJWT.getClaim("userType").asInt();
            int userId = decodedJWT.getClaim("userId").asInt();
            boolean hasAuthority = false;
            if (username == null){
                return false;
            }
            for (UserType uType : userTypes){
                if (uType.userType == userType || uType == UserType.ALL){
                    hasAuthority = true;
                    break;
                }
            }
            if (!hasAuthority){
                return false;
            }
            String redisToken = stringRedisTemplate.opsForValue().get(username+userType);
            if(redisToken == null){
                return false;
            }
            stringRedisTemplate.boundValueOps(username).expire(EXPIRE_TIME, TimeUnit.MINUTES);
            httpServletRequest.setAttribute("username", username);
            httpServletRequest.setAttribute("usertype", userType);
            httpServletRequest.setAttribute("userId", userId);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw e;
        } catch (JWTVerificationException e){
            throw e;
        }

    }

    public void deleteToken(String username, int userType){
        stringRedisTemplate.delete(username+userType);
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
