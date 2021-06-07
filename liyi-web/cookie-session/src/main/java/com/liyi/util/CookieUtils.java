package com.liyi.util;

import javax.servlet.http.Cookie;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/7 23:14  星期一
 */
public class CookieUtils {
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
