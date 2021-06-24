package com.liyi.study.base.day0420.exe2;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/20 9:21  星期二
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
        int i=Integer.parseInt(args[0]);
        int j=Integer.parseInt(args[1]);
        int result= 0;

            result = ecm(i,j);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println("除0");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }


    }


    public static int ecm(int i,int j) throws EcDef {
        if(i<0||j<0){
            throw new EcDef("分子或分母为负数了");

        }
        return i/j;
    }
}
