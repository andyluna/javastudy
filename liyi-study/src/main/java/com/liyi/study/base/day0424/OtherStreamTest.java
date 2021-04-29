package com.liyi.study.base.day0424;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 23:17  星期六
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        BufferedReader br= null;
        try {
            InputStream in;
            InputStreamReader isr=new InputStreamReader(System.in);

            br = new BufferedReader(isr);

            while (true){
                System.out.println("请输入字符串：");
                String data=br.readLine();
                if ("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase=data.toUpperCase();
                System.out.println(upperCase);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1(){

        BufferedReader br= null;
        try {
            InputStream in;
            InputStreamReader isr=new InputStreamReader(System.in);

            br = new BufferedReader(isr);

            while (true){
                System.out.println("请输入字符串：");
                String data=br.readLine();
                if ("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase=data.toUpperCase();
                System.out.println(upperCase);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }
}
