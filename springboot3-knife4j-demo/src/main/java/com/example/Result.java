package com.example;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * * @author telzhou618
 **/
@Data
@Schema(name = "Result",description = "响应对象")
public class Result<T> {

    @Schema(description = "状态码")
    private int code;
    @Schema(description = "请求状态")
    private boolean success;
    @Schema(description = "消息")
    private String message;
    @Schema(description = "响应数据")
    private T data;
    @Schema(description = "扩展数据")
    private Map<String,Object> extData = new LinkedHashMap<>();

    public static Result ok(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result error(String message){
       return error(500,message);
    }

    public static Result error(int code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }
}
