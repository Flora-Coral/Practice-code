package com.案例练习;
//找素数
public class Demo2 {
    public static void main(String[] args) {
        //1.定义一个循环，找到101-200之间的素数
        for (int i = 101; i <= 200; i++) {
            //2.定义一个变量，用来判断是否是素数

            boolean flag = true; //true表示是素数
            //3.定义一个循环，判断是否是素数
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;//跳出循环
                }
            }
            //4.如果是素数，打印
            if (flag) {
                System.out.println(i);
            }
        }
    }
}
