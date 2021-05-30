package com.liyi.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/30 21:50  星期日
 */
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1.获取要下载的文件名

        String downloadFileName="1.jpg";
        //2.读取要下载的文件内容(通过ServletContext对象读取)

        ServletContext servletContext=getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        //4.在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //5.还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        if (req.getHeader("User-Agent").contains("Firefox")) {
            // 如果是火狐浏览器使用Base64编码
            resp.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) + "?=");
        } else {
            // 如果不是火狐，是IE或谷歌，使用URL编码操作
            resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("中国.jpg", "UTF-8"));
        }



        //3.把下载的文件内容回传给客户端

        InputStream resourceAsStream=servletContext.getResourceAsStream("/file/"+downloadFileName);
        //获取响应的输出流
        OutputStream outputStream=resp.getOutputStream();
        //读取流中全部的数据。复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);

    }


}
