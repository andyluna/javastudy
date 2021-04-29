package com.liyi.study.base.day0414;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/14 20:06  星期三
 */
public class OrderTest {
    public static void main(String[] args) {
        Order o1=new Order(1001,"AA");
        Order o2=new Order(1001,"BB");

        System.out.println(o1.equals(o2));

        Order o3=new Order(1001,"AA");
        System.out.println(o3.equals(o1));
    }
}


class Order{
    private int orderId;
    private String orderName;

    public int getOrderId(){
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }


    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj instanceof Order){
            Order order=(Order)obj;
            return  this.orderId==order.orderId&&this.orderName.equals(order.orderName);
        }
        return false;


    }


}
