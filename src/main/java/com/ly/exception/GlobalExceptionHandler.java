package com.ly.exception;

import com.ly.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 全局异常处理
 *
 * @author xinre
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static String getThrowableStackInfo(Throwable e) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        e.printStackTrace(new java.io.PrintWriter(buf, true));
        String msg = buf.toString();
        try {
            buf.close();
        } catch (Exception t) {
            return e.getMessage();
        }
        return msg;
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public Result handleArithmetic(HttpServletRequest request, HttpServletResponse response, ArithmeticException e)
            throws IOException {
        log.info("divide error!");
        return Result.fail("456", getThrowableStackInfo(e));
    }

    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public Result handleArrayIndexOutBounds(HttpServletRequest request, HttpServletResponse response,
                                            ArrayIndexOutOfBoundsException e) throws IOException {
        log.info("array index out error!");
        return Result.fail("456789", getThrowableStackInfo(e));
    }

    @ExceptionHandler(value = PermissionException.class)
    public Result handlePermissionException(PermissionException e) {
        log.info(e.getMessage());
        return Result.fail("12345", "permissionException", e.getStackTrace());
    }
}
