package com.ly.common;

import com.ly.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理（尽量使用exception包下的全局异常处理）
 *
 * @author xinre
 */
@Slf4j
@Component
public class GlobalExceptionProcessor implements HandlerExceptionResolver {

    private class RequestSuffix {

        //application/json;charset=UTF-8
        private static final String SUFFIX_JSON = ".json";
        //text/html;charset=UTF-8
        private static final String SUFFIX_PAGE = ".page";

    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv;
        String defaultMsg = "system error";
        String url = request.getRequestURL().toString();
        // .json  .page
        if (url.endsWith(RequestSuffix.SUFFIX_JSON)) {
            if (ex instanceof PermissionException) {
                log.error("unknow Permission exception, url:[{}]", url, ex);
                Result rr = Result.fail(ex.getMessage());
                mv = new ModelAndView("fileapi", rr.toMap());
            } else {
                log.error("unknow other json exception, url:[{}]", url, ex);
                Result rr = Result.fail(defaultMsg);
                mv = new ModelAndView("jsonView", rr.toMap());
            }
        } else if (url.endsWith(RequestSuffix.SUFFIX_PAGE)) {
            log.error("unknow page exception, url:[{}]", url, ex);
            Result rr = Result.fail(defaultMsg);
            mv = new ModelAndView("exception", rr.toMap());
        } else {
            log.error("unknow other exception, url:[{}]", url, ex);
            Result rr = Result.fail(defaultMsg);
            mv = new ModelAndView("jsonView", rr.toMap());
        }

        return mv;
    }
}
