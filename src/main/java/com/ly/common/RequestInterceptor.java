package com.ly.common;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xinre
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    /**
     * 请求进入后台服务前监听的方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestHolder.setRequest(request);
        return super.preHandle(request, response, handler);
    }

    /**
     * 请求成功返回后监听的方法
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        RequestHolder.remove();
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 无论请求是正常返回还是异常返回都会监听的方法
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHolder.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
