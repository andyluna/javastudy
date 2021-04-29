package com.liyi.study.base.day0424;

import org.junit.Test;

import java.io.File;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/24 17:49  星期六
 */
public class FileTest {
    @Test
    public void test1(){
        File f=new File("Hello.txt");
        File f1=new File("D:\\IdeaProjects\\javastudy\\liyi-study\\src\\main\\java\\com\\liyi\\study\\study001\\day0424\\he.txt");

        System.out.println(f1);
        System.out.println(f);

        File f2=new File("D:\\IdeaProjects\\javastudy\\liyi-study\\src\\main\\java\\com\\liyi\\study\\study001\\day0424","Java");
        System.out.println(f2);

        File f3=new File(f2,"hi.txt");
        System.out.println(f3);

    }

    @Test
    public void test2(){
        File file1=new File("hello.txt");
        File file2=new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
    @Test
    public void test3(){
        File file=new File("D:\\IdeaProjects\\javastudy\\liyi-study\\src\\main\\java\\com\\liyi\\study\\study001\\day0424");
        String[] list = file.list();
        for (String s:list){
            System.out.println(s);

        }

        File[] files = file.listFiles();
        for (File f:files){
            System.out.println(f);
        }
    }

    @Test
    public void test5(){
        File file=new File("Hell.txt");
        File file1=new File("D:\\IdeaProjects\\javastudy\\liyi-study\\src\\main\\java\\com\\liyi\\study\\study001\\day0424\\hi.txt");

        boolean b = file1.renameTo(file);
        System.out.println(b);

        boolean bb=file.renameTo(file1);
        System.out.println(bb);
    }


    @Test
    public void test4(){
        File file=new File("hi.txt");


        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }

    @Test
    public void test6() throws Exception {
        File file=new File("Ah.txt");

        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }else{
            file.delete();
            System.out.println("删除成功 ");
        }
    }


}
