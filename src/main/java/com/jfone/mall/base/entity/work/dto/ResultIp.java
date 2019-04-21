package com.jfone.mall.base.entity.work.dto;
/**
 * 封装json对象，所有返回结果都使用它
 */
public class ResultIp<T> {
    private String code;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultIp{" +
                "code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
