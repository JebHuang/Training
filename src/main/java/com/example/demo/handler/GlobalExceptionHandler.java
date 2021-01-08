package com.example.demo.handler;

import com.example.demo.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Lance
 * @date 2021/1/8 11:48
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {Throwable.class})
    public Result<Object> handleOtherExceptions(final Throwable e) {
        logger.error(e.getMessage(), e);
        Result result = new Result();
        result.setCode(10001);
        StringBuilder sb = new StringBuilder();
        sb.append(e.getMessage());
        sb.append(". Please try again later");
        result.setDesc(sb.toString());
        return result;
    }

}
