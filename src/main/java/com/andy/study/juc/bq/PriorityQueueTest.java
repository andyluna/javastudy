package com.andy.study.juc.bq;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * TODO:
 *
 * @time: 2020/10/14 十月 15:54
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
//        int k = 1024;
//        while (k > 0) {
//            int parent = (k - 1) >>> 1;
//
//            k = parent;
//            System.out.println(k);
//        }
//        queue[k] = key;
//
        Random rand = new Random();
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);

        for(int i=0;i<10;i++){
            pq.add(rand.nextInt(100));
        }



        System.out.println(pq);

        pq.add(39);
        System.out.println(pq);

        for(int i=0;i<11;i++){

            //Integer in2 = pq.peek();
            Integer in = pq.poll();

            System.out.println("Processing Integer:"+in);

        }



    }
}
