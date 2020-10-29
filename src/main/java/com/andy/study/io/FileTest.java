package com.andy.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @time: 2020/10/27 十月 20:25
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        FileTest ft = new FileTest();
        ft.testFileOs();
    }


    public void testFileOs() throws IOException {
        File file = new File("file/a.txt");
        FileInputStream input = null;
        FileOutputStream fos = null;
        try{
            input = new FileInputStream(file);
            fos = new FileOutputStream(file);

            int a = 12;


            for(int i=Byte.MIN_VALUE;i<Byte.MAX_VALUE;i++){
                fos.write((i+" = ").getBytes());
                fos.write(i);
                fos.write("\n".getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(input!=null)input.close();
            if(fos!=null)fos.close();
        }


    }
}
