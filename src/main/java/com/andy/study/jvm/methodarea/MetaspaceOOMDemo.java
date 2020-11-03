//package com.andy.study.jvm.methodarea;
//
//
//import jdk.internal.org.objectweb.asm.ClassWriter;
//import jdk.internal.org.objectweb.asm.Opcodes;
//
///**
// * TODO:MetaspaceOOMDemo
// * jdk6/7: -XX:PermSize=10m -XX:MaxPermSize=10m
// * jdk8: -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
// * @time: 2020/10/1 十月 22:23
// * @author: xiangdan/xiangdan@dtxytech.com
// */
//public class MetaspaceOOMDemo extends ClassLoader {
//
//    public static void main(String[] args) {
//        MetaspaceOOMDemo metaspaceOOMDemo = new MetaspaceOOMDemo();
//        int j = 0;
//        try{
//
//
//            for(int i=0;i<10000;i++){
//                //二进制字节码类生成器
//                ClassWriter classWriter = new ClassWriter(0);
//                //指明版本号,修饰符,类名,包名,父类,接口
//                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class"+i, null, "java/lang/Object", null);
//
//                byte[] code = classWriter.toByteArray();
//
//                metaspaceOOMDemo.defineClass("Class"+i, code, 0, code.length);
//                j++;
//
//            }
//        }finally {
//            System.out.println("总共创建了 "+j+" 个类");
//        }
//
//
//    }
//
//
//}
