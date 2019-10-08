package com.ly.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果信息
 *
 * @author xinre
 */
@Getter
@Setter
public class ReturnResult implements Serializable {

    /**
     * 处理成功的编码
     */
    private static final String CODE_SUCCESS = "200";
    /**
     * 处理失败的编码
     */
    private static final String CODE_FAIL = "500";


    /**
     * 编码
     */
    private String code;
    /**
     * 消息
     */
    private String message;
    /**
     * 成功：true / 失败：false
     */
    private boolean success;
    /**
     * 结果数据
     */
    private Object resultData;


    private ReturnResult(boolean success) {
        this.success = success;
        if (success) {
            this.code = CODE_SUCCESS;
        } else {
            this.code = CODE_FAIL;
        }
    }

    private ReturnResult(boolean success, String code) {
        this.success = success;
        this.code = code;
    }

    public static ReturnResult success() {
        return new ReturnResult(true);
    }

    public static ReturnResult success(Object resultData) {
        ReturnResult rr = new ReturnResult(true);
        rr.setResultData(resultData);
        return rr;
    }

    public static ReturnResult success(String message) {
        ReturnResult rr = new ReturnResult(true);
        rr.setMessage(message);
        return rr;
    }

    public static ReturnResult success(String code, String message) {
        ReturnResult rr = new ReturnResult(true, code);
        rr.setMessage(message);
        return rr;
    }

    public static ReturnResult success(Object resultData, String message) {
        ReturnResult rr = new ReturnResult(true);
        rr.setResultData(resultData);
        rr.setMessage(message);
        return rr;
    }

    public static ReturnResult success(Object resultData, String code, String message) {
        ReturnResult rr = new ReturnResult(true, code);
        rr.setResultData(resultData);
        rr.setMessage(message);
        return rr;
    }

    public static ReturnResult fail() {
        return new ReturnResult(false);
    }

    public static ReturnResult fail(String message) {
        ReturnResult rr = new ReturnResult(false);
        rr.setMessage(message);
        return rr;
    }

    public static ReturnResult fail(Object resultData) {
        ReturnResult rr = new ReturnResult(false);
        rr.setResultData(resultData);
        return rr;
    }

    public static ReturnResult fail(String code, String message) {
        ReturnResult rr = new ReturnResult(false, code);
        rr.setMessage(message);
        return rr;
    }

    public static ReturnResult fail(Object resultData, String message) {
        ReturnResult rr = new ReturnResult(false);
        rr.setResultData(resultData);
        rr.setMessage(message);
        return rr;
    }

    public static ReturnResult fail(Object resultData, String code, String message) {
        ReturnResult rr = new ReturnResult(false, code);
        rr.setResultData(resultData);
        rr.setMessage(message);
        return rr;
    }

    Map<String,Object> toMap() {
        Map<String, Object> r = new HashMap<String, Object>();
        r.put("code", this.getCode());
        r.put("message", this.getMessage());
        r.put("success", this.isSuccess());
        r.put("resultData", this.getResultData());
        return r;
    }


}
