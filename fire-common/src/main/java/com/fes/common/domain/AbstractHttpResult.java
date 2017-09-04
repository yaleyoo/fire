package com.fes.common.domain;

import java.io.Serializable;

public abstract class AbstractHttpResult<T> implements Serializable {

    private static final long serialVersionUID = 1567157987735787433L;

    /** 返回消息 */
    protected ErrorMessage    error;

    /** 返回数据 */
    protected T               data;

    public ErrorMessage getError() {
        return error;
    }

    public void setError(ErrorMessage error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}