package com.liyi.study.base.day0422;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/22 20:29  星期四
 */
public class Goods implements Comparable{
    private String name;

    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品排序的方式:价格从低到高，商品名称从低到高
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods=(Goods)o;
            if (this.price>goods.price){
                return 1;
            }else if (this.price<goods.price){
                return -1;
            }else{
                return this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
