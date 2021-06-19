package com.study.cms.comm.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/19 23:57  星期六
 */
public class ResponseUtils {

    //往 浏览器 写入json数据
    public static void writeJson(HttpServletResponse resp, AjaxRes res ) throws IOException {
        resp.setContentType("appliction/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(res.toString());
        writer.close();
    }



}
