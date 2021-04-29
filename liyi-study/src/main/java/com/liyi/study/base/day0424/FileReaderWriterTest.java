package com.liyi.study.base.day0424;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 19:54  星期六
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file=new File("hi.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1=new File("day0424\\hi.txt");
        System.out.println(file1.getAbsolutePath());


        System.out.println(file);
    }

    @Test
    public void testFileReader() {

        FileReader fr= null;
        try {
            File file=new File("hh.txt");//相较于当前Module
//        System.out.println(file);
            fr = new FileReader(file);

//        int data=fr.read();
//        while(data!=-1){
//            System.out.print((char)data);
//            data= fr.read();
//        }

            int data;
            while((data=fr.read())!=-1){
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null){
                    fr.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader1(){
        FileReader fr= null;
        try {
            File file=new File("hi.txt");

            fr = new FileReader(file);

            char[] ch=new char[5];
            int len;
            while ((len=fr.read(ch))!=-1){
                for (int i=0;i<len;i++){
                    System.out.println(ch[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileWriter() throws IOException {

        File file=new File("hi.txt");

        FileWriter fw=new FileWriter(file,false);

        fw.write("我笑了");
        fw.write("?????");



        fw.close();
    }


    @Test
    public void testFileReaderFileWriter() {
        FileReader fr= null;
        FileWriter fw= null;
        try {
            File srcFile=new File("hi.txt");
            File desFile=new File("hello1.txt");

            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile);

            char[] cbuf=new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw!=null){
                fw.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr!=null){
                    fr.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }




}
