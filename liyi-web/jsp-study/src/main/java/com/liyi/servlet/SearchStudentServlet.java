package com.liyi.servlet;

import com.liyi.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/5/21 20:44  星期五
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> stuList=new ArrayList<Student>();
        for (int i=0;i<10;i++){
            int t=i+1;
            stuList.add(new Student(t,"name"+t, 18+t,"phone"+t));
        }

        // 保存查询到的结果（学生信息）到request域中
        req.setAttribute("stuList",stuList);
        // 请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);

    }
}
