package com.bwhome.common.exception;

import com.bwhome.common.core.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public AjaxResult exception(Exception e){
        return AjaxResult.error(e.getMessage());
    }
}
