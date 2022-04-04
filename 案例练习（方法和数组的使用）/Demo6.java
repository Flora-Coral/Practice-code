package com.案例练习;

import java.util.Scanner;

//数字加密
public class Demo6 {
    public static void main(String[] args) {
        //1.定义一个数组存放需要加密的数字
        System.out.println("请输入需要加密的数字个数：");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];

        //2.录入需要加密的数字
        for (int i = 0; i < arr.length; i++) {  //循环输入
            System.out.println("请输入第" + (i + 1) + "个数字：");
            int num = sc.nextInt();
            arr[i] = num;
        }
        //3.打印数组
        System.out.print("加密前的数组：");
        printArray(arr);
        //4.加密
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] += 5) % 10;
        }
        //5.对加密后的数据反转
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //6.打印加密后的数组
        System.out.print("加密后的数组：");
        printArray(arr);

    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }
}