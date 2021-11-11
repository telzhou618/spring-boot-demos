package com.example.config;

import com.example.common.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一封装返回对象
 * @author zhougaojun
 */
@RestControllerAdvice
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果已经是 Result 类型，则直接返回
        if (body instanceof Result) {
            return body;
        }
        // 如果不是，包装成Result数据类型
        return Result.success(body);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }
}
