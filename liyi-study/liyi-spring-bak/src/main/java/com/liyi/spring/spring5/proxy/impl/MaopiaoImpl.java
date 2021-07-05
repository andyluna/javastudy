package com.liyi.spring.spring5.proxy.impl;

import com.liyi.spring.spring5.proxy.Maipiao;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/7/4 23:26  星期日
 */
public class MaopiaoImpl implements Maipiao {
    @Override
    public String train1() {
        return "从12306官网买了一张火车票";
    }

    @Override
    public String fly1() {
        return "从机场候车厅买了一张飞机票";
    }
}
