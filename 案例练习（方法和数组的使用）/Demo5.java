package com.案例练习;

import java.util.Scanner;

//评委打分
public class Demo5 {
    public static void main(String[] args) {
        //1.定义一个动态初始化的数组，用于后期录入6个评委的分数
        int[] scores = new int[6];
        //2.录入6个评委的分数
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的分数：");
            int score = sc.nextInt();
            //3.把分数存入到数组对应位置
            scores[i] = score;
        }

        //4.遍历数组，找出最高分和最小值 总分
        int max = scores[0];
        int min = scores[0];
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];//替换最大值
            }

            if (scores[i] < min) {
                min = scores[i];//替换最小值
            }

            sum += scores[i];//累加总分
        }

        //5.统计平均分
        double result = (sum - max - min) / (scores.length - 2);
        System.out.println("最高分：" + max + "\n最低分：" + min + "\n总分：" + sum + "\n平均分：" + result);
    }
}
