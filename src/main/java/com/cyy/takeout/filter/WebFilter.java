package com.cyy.takeout.filter;

import com.alibaba.fastjson.JSON;
import com.cyy.takeout.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@javax.servlet.annotation.WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class WebFilter implements Filter {

    //路径匹配器
    public static final AntPathMatcher PATH_MATCHER=new AntPathMatcher();
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        
        String requestUrl=request.getRequestURI();
        
        String urls[]={
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs"
        };

        log.info("捕获路径："+requestUrl);
        
        //2.匹配放行

        if(check(requestUrl,urls))
        {
            log.info("本次请求无需处理");
            filterChain.doFilter(request,response);
            return;
        }
        
        if(request.getSession().getAttribute("employee")!= null)
        {
            log.info("用户已登陆，用户id为：{}", request.getSession().getAttribute("employee"));
            filterChain.doFilter(request,response);
            return;
        }
        
        if(request.getSession().getAttribute("user") != null)
        {
            log.info("用户已登陆，用户id为：{}", request.getSession().getAttribute("user"));
            filterChain.doFilter(request,response);
            return;
        }
        log.info("用户未登录");

        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
        
    }


    boolean check(String http,String[] urls)
    {
        for (String url : urls) {
            if(PATH_MATCHER.match(url,http))
                return true;
        }
        return false;
    }
}
