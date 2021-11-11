package com.example.config;


import com.example.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 统一处理异常
 *
 * @author zhougaojun
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {


    /**
     * 参数校验错误异常 400
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        log.error("参数校验异常", ex);
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        String message = allErrors.size() > 0 ? allErrors.get(0).getDefaultMessage() : "";
        return Result.failure(400, message);
    }

    /**
     * 服务器不能处理的异常，返回500
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(HttpServletRequest request, Exception ex) {
        log.error("系统内部错误", ex);
        return Result.failure(ex.getMessage());
    }

}
