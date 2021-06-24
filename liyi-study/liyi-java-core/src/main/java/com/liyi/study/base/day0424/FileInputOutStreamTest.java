package com.liyi.study.base.day0424;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 21:25  星期六
 */
public class FileInputOutStreamTest {

    @Test
    public void testFileInputSteam() {
        FileInputStream fis=null;

        try {
            File file=new File("hi.txt");

            fis=new FileInputStream(file);

            byte[] buffer=new byte[5];
            int len;
            while ((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
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


    @Test
    public void testFileInputOutputSteam(){
        FileInputStream fis=null;
        FileOutputStream fos = null;


        try {
            File srcFile=new File("穿越火线121.png");
            File desFile=new File("穿越火线2.png");
            fis=new FileInputStream(srcFile);
            fos=new FileOutputStream(desFile);
            int len;
            byte[] buffer=new byte[5];
            while ((len=fis.read(buffer))!=-1){
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
                System.out.println("复制成功");
            }
        }


    }
}
