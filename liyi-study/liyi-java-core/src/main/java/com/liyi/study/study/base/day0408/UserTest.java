package com.liyi.study.study.base.day0408;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/8 16:12  星期四
 */
public class UserTest {


    class User{
        //属性(成员变量)
        String name;
        int age;
        boolean isMale;

        public  void talk(String language){//形参，也是局部变量
            System.out.println("我们使用"+language+"进行交流");
        }

        public void eat(){
            String food="烙饼";//局部变量
            System.out.println("北方人喜欢吃"+food);
        }

    }

}
