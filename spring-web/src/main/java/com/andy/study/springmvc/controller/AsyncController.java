package com.andy.study.springmvc.controller;

import com.andy.study.springmvc.queue.DeferredResultQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @time: 2020/12/4 十二月 09:52
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Controller
@RequestMapping("/asyncmvc")
@Slf4j
public class AsyncController {


    @GetMapping("/syncTask")
    public ModelAndView syncTask(){
        log.debug("同步");
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "你好啊");
        mv.setViewName("sync");

        return mv;
    }


    @GetMapping("/asyncTasksyncTask01")
    public Callable<String> asyncTask(){
        log.debug("主线程-异步开始");
        Callable<String> callable =  ()->{
            log.info("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
            Thread.sleep(2000);
            log.info("副线程结束..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
            return "async";
        };
        log.debug("主线程-异步结束");
        return callable;
    }


    @GetMapping("/createOrder")
    @ResponseBody
    public DeferredResult<Object> createOrder(){
        log.debug("createOrder主线程-异步开始");
        DeferredResult<Object> deferredResult = new DeferredResult<>(5000L, "create fail...");
        DeferredResultQueue.save(deferredResult);

        log.debug("createOrder主线程-异步结束");
        return deferredResult;
    }



    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        log.debug("create主线程-异步开始");
        //创建订单
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success===>"+order;
    }


}
