package com.irving.springbootelasticsearch.common.http;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-elasticsearch
 * @description:
 * @author: Irving
 * @create: 2020-01-09
 **/
@Data
public class ApiResult<T> {


    private Integer code;
    private String msg;
    private T data;
    private boolean isError;

    private static Map emptyJson = new HashMap();

    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.isError = !this.code.equals(CommonResponseCode.SUCCESS.getCode());
    }

    private ApiResult(ResponseCode commonResponseCode) {
        this.code = commonResponseCode.getCode();
        this.msg = commonResponseCode.getMsg();
        this.isError = !this.code.equals(CommonResponseCode.SUCCESS.getCode());
    }

    private ApiResult(ResponseCode commonResponseCode, T object) {
        this.code = commonResponseCode.getCode();
        this.msg = commonResponseCode.getMsg();
        this.data = object;
        this.isError = !this.code.equals(CommonResponseCode.SUCCESS.getCode());
    }

    public static ApiResult success() {
        return new ApiResult(CommonResponseCode.SUCCESS);
    }

    public static <T>ApiResult <T>success(T data) {
        return new ApiResult<>(CommonResponseCode.SUCCESS, data);
    }

    public static ApiResult error() {
        return new ApiResult(CommonResponseCode.INNER_ERROR);
    }

    public static <T>ApiResult error(T data) {
        return new ApiResult<>(CommonResponseCode.INNER_ERROR, data);
    }

    public static ApiResult custom(ResponseCode responseCode) {
        return new ApiResult(responseCode);
    }

}
