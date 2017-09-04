package com.fes.common.domain;

import java.io.Serializable;

/**
 * 借贷宝Http接口返回的状态信息
 * @author guozj
 *
 */
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 7603699336471626318L;

    /** 状态码 0：成功  1：失败 */
    private String            returnCode;
        
    /** 消息内容 */
    private String            returnMessage;
    
    /** 用户消息内容 */
    private String            returnUserMessage;

    public ErrorMessage(){
        
    }
    // 手动赋值
    public ErrorMessage(boolean success, String returnMessage) {
        this.returnCode = success ? "0" : "1";
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnMessage;
    }

    // 默认赋值
    public ErrorMessage(boolean success) {
        if (success) {
            this.returnCode = "0";
            this.returnMessage = "success";
            this.returnUserMessage = "操作成功!";
        } else {
            this.returnCode = "1";
            this.returnMessage = "failure";
            this.returnUserMessage = "操作失败!";
        }
    }
    
    // 默认赋值
    public void setSuccess(boolean success) {
        if (success) {
            this.returnCode = "0";
            this.returnMessage = "success";
            this.returnUserMessage = "操作成功!";
        } else {
            this.returnCode = "1";
            this.returnMessage = "failure";
            this.returnUserMessage = "操作失败!";
        }
    }
    
    // 手动赋值
    public void setSuccess(boolean success, String returnMessage) {
        this.returnCode = success ? "0" : "1";
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnMessage;
    }

    /** 判断当前状态是否是成功 */
    public boolean success() {
        return "0".equals(this.returnCode);
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getReturnUserMessage() {
        return returnUserMessage;
    }
    public void setReturnUserMessage(String returnUserMessage) {
        this.returnUserMessage = returnUserMessage;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("returnCode: ").append(this.returnCode).append(';');
        sb.append("returnMessage: ").append(this.returnMessage).append(';');
        sb.append("returnUserMessage: ").append(this.returnUserMessage).append(';');
        return sb.toString();
    }

}
