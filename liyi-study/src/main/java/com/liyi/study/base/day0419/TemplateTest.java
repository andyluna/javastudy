package com.liyi.study.base.day0419;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/19 16:11  星期一
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template t=new SubTemplate();
        t.spendTime();
    }

}

abstract class Template{
    public void spendTime(){
        long start=System.currentTimeMillis();
        code();//不确定的部分
        long end=System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start));
    }

    public abstract void code();
}

class SubTemplate extends Template{

    @Override
    public void code() {
        for (int i=0;i<=1000;i++){
            boolean isFlag=true;
            for (int j=2;j<=Math.sqrt(i);j++){
                if (i%j==0){
                    isFlag=false;
                    break;
                }
            }
            if (isFlag){
                System.out.println(i);
            }
        }
    }
}
