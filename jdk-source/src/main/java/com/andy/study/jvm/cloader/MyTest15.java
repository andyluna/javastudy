package com.andy.study.jvm.cloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @time: 2020/10/22 十月 17:25
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class MyTest15 extends ClassLoader{
    private String classLoaderName;
    private String path;
    public static final String fileExtension = ".class";
    public MyTest15(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest15(ClassLoader parentLoader,String classLoaderName){
        super(parentLoader);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "classloader:"+classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("myfindClass:"+name);
        byte[] data = getBytesByName(name);
        Class<?> aClass = super.defineClass(name, data, 0, data.length);
        return aClass;
    }

    private byte[] getBytesByName(String name){
        InputStream in = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            in = new FileInputStream(new File(path+name.replace(".", "/") + fileExtension));
            baos = new ByteArrayOutputStream();
            int c = 0;

            while( -1 !=(c=in.read())){
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                baos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void main(String[] args) throws Exception {

        MyTest15 myTest15 = new MyTest15("hello");
        myTest15.setPath("/Users/xiangdan/IdeaProjects/javastudy/target/classes2/");
        Class<?> aClass = myTest15.loadClass("com.andy.study.jvm.cloader.MyTest1");
        System.out.println(aClass);

    }
}
