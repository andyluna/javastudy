package com.liyi.study.base.day0424;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 22:49  星期六
 */
public class InputStreamReaderTest {
    @Test
    public void test1(){

        FileInputStream fis= null;
        try {
            fis = new FileInputStream("hi.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

            char[] cbuf=new char[20];
            int len;
            while((len=isr.read(cbuf))!=-1){
                String str=new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }





}
