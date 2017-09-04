package com.fes.common.domain;

public class SimpleHttpResult<T> extends AbstractHttpResult<T> {

    private static final long serialVersionUID = -905245025464889692L;

    public SimpleHttpResult() {
        this.error = new ErrorMessage(true);
    }

    public SimpleHttpResult(T t) {
        this.error = new ErrorMessage(true);
        this.data  = t;
    }

    public SimpleHttpResult(boolean success, String returnMessage) {
        this.error = new ErrorMessage(success, returnMessage);
    }

    public SimpleHttpResult(boolean success) {
        this.error = new ErrorMessage(success);
    }

    /**
     * 默认赋值
     */
    public void setSuccess(boolean success) {
        this.error.setSuccess(success);
    }

    /**
     * 手动赋值
     */
    public void setSuccess(boolean success, String returnMessage) {
        this.error.setSuccess(success, returnMessage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("返回消息[");
        sb.append(this.error.toString());
        sb.append(']');
        sb.append("数据信息[");
        if (data != null) {
            sb.append(this.data.toString());
        }else{
            sb.append("null");
        }
        sb.append(']');
        return sb.toString();
    }
}