package com.案例练习;

import java.util.Scanner;

//买飞机票
/*需求
机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱
机票最终优惠价格的计算方案如下：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折
 */
public class Demo1 {
    public static void main(String[] args) {
        //1.让用户输入机票原价、月份、仓型
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票原价:");
        double money = sc.nextDouble();

        System.out.println("请输入机票的月份（1-12）:");
        int month = sc.nextInt();

        System.out.println("请输入仓位类型:");
        String type = sc.next();

        //4.调用
        System.out.println(calc(money, month, type));
    }

    //2.定义方法接收信息，统计优惠价格后返回
    public static double calc(double money, int month, String type) {
        //3.让用户选择信息
        if (month >= 5 && month <= 10) {
            //旺季
            switch (type) {
                case "头等舱":
                    money *= 0.9;
                    break;
                case "经济舱":
                    money *= 0.85;
                    break;
                default:
                    System.out.println("你输入的仓型有误。");
            }
        } else if (month == 11 || month == 12 || month >= 1 && month <= 4) {
            //淡季
            switch (type) {
                case "头等舱":
                    money *= 0.7;
                    break;
                case "经济舱":
                    money *= 0.65;
                    break;
                default:
                    System.out.println("你输入的仓型有误。");
            }
        } else {
            System.out.println("你输入的月份有误。");
        }
        return money;
    }
}
