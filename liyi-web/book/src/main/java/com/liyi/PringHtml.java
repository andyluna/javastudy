package com.liyi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/17 22:43  星期一
 */
public class PringHtml extends HttpServlet {


    public void init() throws ServletException {
        System.out.println("PrintHtml启动成功");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"en\">\r\n");
        writer.write("<head>\r\n");
        writer.write("<meta charset=\"UTF-8\">\r\n");
        writer.write("<title>Title</title>\r\n");
        writer.write("</head>\r\n");
        writer.write("<body>\r\n");
        writer.write("这是1.html的数据\r\n");
        writer.write("</body>\r\n");
        writer.write("</html>\r\n");

        writer.close();

//
//<html lang="en">
//<head>
//    <meta charset="UTF-8">
//    <title>Title</title>
//</head>
//<body>
//                这是1.html的数据
//                </body>
//</html>
    }
}
