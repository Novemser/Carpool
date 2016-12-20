package com.carpool.website.service;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deado on 2016/12/19.
 */
public class RememberMeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //filterChain.doFilter(request,response);





        boolean  loginRequest = false;
        boolean  resourceRequest = false;
        boolean  rememberCookieExist = false;
        boolean  cookiesExist = false;
        String uri = request.getRequestURI();

        if(0==uri.compareTo("/")){
            filterChain.doFilter(request,response);
            return;
        }

        //check if login request
        loginRequest =  uri.contains("login");
        resourceRequest = (uri.contains("static") || uri.contains("ico"));
        //check cookies
        Cookie[] cookies = request.getCookies();
        if(null != cookies){
            cookiesExist = true;
            for(Cookie cookie: cookies){
                if(0 == cookie.getName().compareTo("remember-me")){
                    rememberCookieExist = true; break;
                }
            }

        }

        //do filter
        if( resourceRequest ||(loginRequest&&!rememberCookieExist) || (!loginRequest&&cookiesExist&&rememberCookieExist) ){
            filterChain.doFilter(request,response);
        }else if( !loginRequest && !rememberCookieExist ){
            response.sendRedirect("/login");
        }
        else{
            response.sendRedirect("/home/main");
        }



    }
}
