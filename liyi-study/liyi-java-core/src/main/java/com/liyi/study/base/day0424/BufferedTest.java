package com.liyi.study.base.day0424;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 22:08  星期六
 */
public class BufferedTest {

    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream(new File("穿越火线2.png"));
            File file;
            fos = new FileOutputStream("穿越火线121.png");

            byte[] buffer=new byte[20];
            int len;
            while ((len=fis.read(buffer))!=-1){
                for (int i=0;i<len;i++){
                    buffer[i]=(byte) (buffer[i]^5);//图片的加密
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
