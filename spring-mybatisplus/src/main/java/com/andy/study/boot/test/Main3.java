package com.andy.study.boot.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @time: 2021/2/21 二月 11:12
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public class Main3 {
    private static String team      = "we are a team";
    private static String notteam   = "we are not a team";
    private static String dapianxi  = "da pian zi";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str==null){
            throw new RuntimeException("请输入N M 数字");
        }
        int n = 0 ;//n个人
        int m = 0 ;//m条消息
        String[] s = str.split(" ");
        n = Integer.parseInt(s[0].trim());
        m = Integer.parseInt(s[1].trim());
        if(n<1||n>100000 || m<1||m>100000 ){
            System.out.println("NULL");
        }
        int a = 0;
        int b = 0;
        int c = 0;
        List<Set<Integer>> teams = new ArrayList<>();
        for(int i=0;i<m;i++){
            str = sc.nextLine();
            s = str.split(" ");
            a = Integer.parseInt(s[0].trim());
            b = Integer.parseInt(s[1].trim());
            c = Integer.parseInt(s[2].trim());



            if(a<1||a>n ||b<1||b>n || c<0|| c>1){
                System.out.println(dapianxi);
                continue;
            }
            if(c==0){
                Set<Integer> set = new HashSet<>();
                set.add(a);
                set.add(b);
                if(teams.size()==0){
                    teams.add(set);
                }else{
                    boolean f = false;

                    for(Set<Integer> t:teams){
                        if(t.stream().anyMatch(s1->set.contains(s1))){
                            t.addAll(set);
                            f = true;
                            break;
                        }
                    }
                    if( !f ){
                        teams.add(set);
                    }
                }

            }else if(c==1){
                boolean f1 = false;
                for(Set<Integer> t:teams){
                    if(t.contains(a) && t.contains(b)){
                        f1 = true;
                        break;
                    }
                }
                if(f1){
                    System.out.println(team);
                }else{
                    System.out.println(notteam);
                }
            }else{
                System.out.println(dapianxi);
            }

        }

    }


}
