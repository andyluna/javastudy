package com.andy.study.springmvc.original;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @time: 2020/12/4 十二月 09:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@WebServlet(urlPatterns = {"/async/myasync"},name = "MyAsyncServlet",loadOnStartup = 1,asyncSupported = true)
@Slf4j
public class MyAsyncServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log.debug("主程序-异步servlet 初始化成功");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("主程序-进入异步请求");
        AsyncContext context = req.startAsync();
        context.setTimeout(5*1000L);

        MyRunnable runnable = new MyRunnable(context);
        log.debug("主程序-准备开启一个异步线程");
        log.debug("主程序-req :{}",req);
        log.debug("主程序-resp:{}",resp);
        ServletInputStream inputStream = req.getInputStream();
        inputStream.setReadListener(new ReadListener() {
            @Override
            public void onDataAvailable() throws IOException {

            }

            @Override
            public void onAllDataRead() throws IOException {

            }

            @Override
            public void onError(Throwable t) {

            }
        });
        context.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                log.debug("监听器监听到 onComplete:{} ",event);
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                log.debug("监听器监听到 onTimeout:{} ",event);
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                log.debug("监听器监听到 onError:{} ",event);

            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                log.debug("监听器监听到 onStartAsync:{} ",event);

            }
        });

        context.start(runnable);
        log.debug("主程序-异步线程开启完成");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        PrintWriter writer = resp.getWriter();
        writer.println("异步servlet执行完成");
        writer.flush();
    }


    public static class MyRunnable implements Runnable{
        private Logger log1 = LoggerFactory.getLogger(getClass());
        private AsyncContext context;
        public MyRunnable(AsyncContext context) {
            this.context = context;
        }

        @Override
        public void run() {
            log1.debug("开始执行异步耗时的操作");
            ServletRequest request   = this.context.getRequest();
            ServletResponse response = this.context.getResponse();
            Long timeout = this.context.getTimeout();
            boolean b = this.context.hasOriginalRequestAndResponse();
            log.debug("request:{}",request);
            log.debug("response:{}",response);
            log.debug("timeout:{}",timeout);
            log.debug("b:{}",b);
            try {
                Thread.sleep(2000L);
                PrintWriter writer = response.getWriter();
                writer.println("异步请求结果 再返回");
            } catch (Exception e) {
                e.printStackTrace();
            }
            log1.debug("异步耗时的操作执行完成");
            context.complete();
        }
    }


}
