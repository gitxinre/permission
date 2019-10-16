package com.ly.filter;

import com.ly.common.ThreadHolder;
import com.ly.util.IpUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xinre
 */
@Slf4j
public class LoginFilter implements Filter {

    public static void main(String[] args) {
        String str ="232ljsfsf.sdfl23.ljsdfsdfsdfss.23423.sdfsdfsfd";
        //获得第一个点的位置
        //int index=str.indexOf(".");
        //System.out.println(index);
        //根据第一个点的位置 获得第二个点的位置
        //index=str.indexOf(".", index+1);
        //根据第二个点的位置，截取 字符串。得到结果 result
        String result=str.substring(0,str.indexOf("."));
        //输出结果
        System.out.println(result);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        StringBuffer requestURL = request.getRequestURL();
        String servletPath = request.getServletPath();

        String ipAddress = IpUtils.getIpAddress(request);
        System.out.println("ipAddress = " + ipAddress);

        System.out.println("URL = " + requestURL.toString() + servletPath);
        log.info("url is : [{}]", requestURL.toString() + servletPath);
        ThreadHolder.setRequest(request);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
