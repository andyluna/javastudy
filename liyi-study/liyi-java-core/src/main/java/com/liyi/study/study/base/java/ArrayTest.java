package com.liyi.study.study.base.java;

import java.util.Arrays;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/7 10:11  星期三
 */
public class ArrayTest {
    public static void main(String[] args) {
//        //数组的初始化
//        int[] ids;//声明
//        //1.静态初始化：数组的初始化和数组元素的赋值操作同时进行
//        ids=new int[]{1001,1002,1003,1004,1005};
//        //2.动态初始化：数组的初始化和数组元素的赋值操作分开进行；
//        String[] name=new String[5];
//        //数组一旦初始化完成，长度就确定了
//
//        //调用数组指定位置的元素：通过角标的方式调用（角标从0开始到数组长度-1结束）
//        name[0]="张三";
//        name[1]="李四";
//        name[2]="王五";
//        name[3]="赵六";
//        name[4]="小七";
//
//        //调用数组的长度:length
//        System.out.println(name.length);
//        System.out.println(ids.length);
//
//        //遍历数组
//        for (int i=0;i<name.length;i++){
//            System.out.println(name[i]);
//        }
//
//        //数组元素的默认初始值
//        //数组元素是整型：0
//        //数组元素是浮点型：0.0
//        //数组元素是char型：0或'\u0000',而不是'0'
//        //数组元素是boolean：false
//
//        //数组元素是引用数据类型（String）：null,而不是"null"

//        int[] arr=new int[]{8,2,1,0,3};
//        int[] index=new int[]{2,0,3,2,4,0,1,3,2,3,3};
//        String tel="";
//        for (int i=0;i<index.length;i++){
//            tel+=arr[index[i]];
//
//        }
//        System.out.println("联系方式："+tel);

//
//        //使用Scanner读取学生个数
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入学生人数：");
//        int number=scanner.nextInt();
//        //创建数组、存储学生成绩。动态初始化
//        int[] scores=new int[number];
//        //给数组中的元素赋值
//        System.out.println("请输入"+number+"个学生成绩:");
//        for (int i=0;i<scores.length;i++){
//            scores[i]=scanner.nextInt();
//
//        }
//
//
//        //获取数组中元素的最大值：最高分
//        int maxScore=0;
//        for (int i=0;i<scores.length;i++){
//            if (maxScore<scores[i]){、

//                maxScore=scores[i];
//            }
//        }
//
//        //根据每个学生成绩与最高分的差值，得到每个学生的等级，并输出学生的等级和成绩
//        char level;
//        for (int i=0;i<scores.length;i++){
//            if (maxScore-scores[i]<=10){
//                level='A';
//            }else if (maxScore-scores[i]<=20){
//                level='B';
//            }else if (maxScore-scores[i]<=30){
//                level='C';
//            }else {
//                level='D';
//            }
//            System.out.println("student"+i+"score is"+scores[i]+",grads is"+level);
//        }

//        //1.二维数组的声明和初始化
//        int [] arr=new int[]{1,2,3};//一维数组
//        //静态初始化
//        int [][] arr1=new int[][]{{1,2,3},{4,5},{6,7,8}};
//        //动态初始化
//        String[][] arr2=new String[3][2];
//
//
//        //2.调用数组指定位置的元素
//        System.out.println(arr1[0][1]);//2
//        System.out.println(arr2[1][1]);//null
//
//        //3.获取数组的长度
//        System.out.println(arr1.length);//3
//        System.out.println(arr1[1].length);//2
//
//        //4.如何遍历二维数组
//        for (int i=0;i<arr1.length;i++){
//            for (int j=0;j<arr1[i].length;j++){
//                System.out.print(arr1[i][j]+"  ");
//            }
//            System.out.println();
//        }

//        //1.声明并初始化二维数组
//        int[][] yangHui=new int[10][];
//
//        //2.给数组元素赋值
//        for (int i=0;i< yangHui.length;i++){
//            yangHui[i]=new int[i+1];
//
//            //2.1给首末元素赋值
//            yangHui[i][0]=yangHui[i][i]=1;
//
//            //2.2给每行的非首末元素赋值
//            if (i>1){
//                for (int j=1;j< yangHui[i].length-1;j++){
//                    yangHui[i][j]=yangHui[i-1][j-1]+yangHui[i-1][j];
//                }
//            }
//        }
//
//        //遍历二维数组
//        for (int i=0;i< yangHui.length;i++){
//            for (int j=0;j<yangHui[i].length;j++){
//                System.out.print(yangHui[i][j]+"  ");
//            }
//            System.out.println();
//        }


//        int[] arr=new int[10];
//
//        for (int i=0;i<arr.length;i++){
//            arr[i]=(int)(Math.random()*(99-10+1)+10);
//        }
//
//        //数组元素的最大值
//        //int max=0;
//        int max=arr[0];
//        for (int i=0;i<arr.length;i++){
//            if(max<arr[i]){
//                max=arr[i];
//            }
//            System.out.print(arr[i]+"  ");
//        }
//        System.out.println("\n"+"最大值为"+max);
//
//        //数组元素的最小值
//        int min=arr[0];
//        for (int i=0;i<arr.length;i++){
//            if(min>arr[i]){
//                min=arr[i];
//            }
//        }
//        System.out.println("\n"+"最小值为"+min);
//
//        //数组元素的总和
//        int sum=0;
//        for (int i=0;i< arr.length;i++){
//            sum+=arr[i];
//        }
//        System.out.println("总和为："+sum);
//
//        //数组元素的平均数
//        double avg=sum/arr.length;
//        System.out.println("平均数为："+avg);


        //线性查找
//        String[] arr=new String[]{"jj","dd","mm","gg","aa"};
//
//        String dest="bb";
//        boolean isFlag=true;//标识
//
//        for (int i=0;i< arr.length;i++){
//            if (dest.equals(arr[i])){
//                System.out.println("找到了指定的元素，位置为："+i);
//                isFlag=false;
//                break;
//            }
//        }
//        if (isFlag){
//            System.out.println("没有找到指定元素");
//        }

        //二分法查找(数组必须有序)
//        int[] arr2=new int[]{-10,10,15,20,30,62,65,85,87,99};
//
//        int dest1=87;
//        int head=0;//初始首索引
//        int end= arr2.length-1;//初始末索引
//        Boolean isFlag1=true;//标识
//
//        while(head<=end){
//
//            int middle=(head+end)/2;
//
//            if (dest1==arr2[middle]){
//                System.out.println("找到了指定的元素，位置为："+middle);
//                isFlag1=false;
//                break;
//            }else if (arr2[middle]>dest1){
//                end=middle-1;
//            }else {
//                head=middle+1;
//            }
//        }
//        if (isFlag1){
//            System.out.println("没有找到指定元素");
//        }

        //冒泡排序的实现
//        int[] arr=new int[]{54,-85,-65,20,65,21,74,98,65,32};
//
//        for (int i=0;i< arr.length-1;i++){
//
//            for (int j=0;j< arr.length-1-i;j++){
//
//                if(arr[j]>arr[j+1]){
//                    int temp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//                }
//            }
//        }
//
//
//        for (int i=0;i< arr.length;i++){
//            System.out.println(arr[i]+"\t");
//        }

        //判断两个数组是否相等
        int[] arr1=new int[]{6,5,4,3};
        int[] arr2=new int[]{1,3,2,4};
        boolean isEquals= Arrays.equals(arr1,arr2);
        System.out.println(isEquals);//false

        //输出数组的信息
       // System.out.println(arr1.toString());//输出的是地址
        System.out.println(Arrays.toString(arr1));

        //将指定的值填充到数组当中
//        Arrays.fill(arr1,10);
//        System.out.println(Arrays.toString(arr1));

        //对数组进行排序
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        //二分查找
        int[] arr3=new int[]{-10,10,15,20,30,62,65,85,87,99};
        int index=Arrays.binarySearch(arr3,87);
        if (index>=0){
            System.out.println("找到了在"+index+"位置");
        }else{
            System.out.println("未找到");
        }


































    }



}
