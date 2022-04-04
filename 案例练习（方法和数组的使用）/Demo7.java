package com.案例练习;

import java.util.Random;
import java.util.Scanner;

//模拟双色球
//随机6个红球号码（1-33，不能重复），随机1个蓝球号码（1-16），可以采用数组装起来作为中奖号码。
public class Demo7 {
    public static void main(String[] args) {
        int[] luckNumbers = createLuckNumber();
        int[] userNumbers = getUserNumbers();
        judge(luckNumbers, userNumbers);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //1.随机一组中将号码
    public static int[] createLuckNumber() {
        //定义一个动态初始化的数组，存储7个数字。
        int[] numbers = new int[7];
        //遍历数组，为每个位置生成对应的号码
        Random r = new Random();
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                int date = r.nextInt(1, 33);//(1-33)

                //必须判断当前随机的号码之前是否出现过，出现要重新随机，直到不重复为止，才可以存储
                //定义一个flag变量。默认date没有重复。
                boolean flag = true;
                for (int j = 0; j < i; j++) {
                    if (numbers[j] == date) {
                        //date当前这个数据之前出现过
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    //date这个数据之前没有出现过
                    numbers[i] = date;
                    break;
                }
            }
        }
        //为第7个位置生成蓝球号码
        numbers[numbers.length - 1] = r.nextInt(1, 16);
        return numbers;
    }

    //2.用户输入一组号码返回
    public static int[] getUserNumbers() {
        //定义一个动态初始化的数组，存储7个数字。
        int[] numbers = new int[7];
        //让用户输入7个号码
        Scanner sc = new Scanner(System.in);
        //遍历数组，为每个位置生成对应的号码
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                System.out.print("请输入第" + (i + 1) + "个红球号码(1-33、不重复)：");
                int date = sc.nextInt();
                //判断输入数据是否符合要求
                if (date >= 1 && date <= 33) {
                    //必须判断当前输入的号码之前是否出现过，出现要重新输入，直到不重复为止，才可以存储
                    //定义一个flag变量。默认date没有重复。
                    boolean flag = true;
                    for (int j = 0; j < i; j++) {
                        if (numbers[j] == date) {
                            //date当前这个数据之前出现过
                            flag = false;
                            System.out.println("号码重复，请重新输入！");
                            break;
                        }
                    }
                    if (flag) {
                        //date这个数据之前没有出现过
                        numbers[i] = date;
                        break;
                    }
                } else {
                    System.out.println("号码超出范围，请重新输入！");
                }
            }
        }
        //为第7个位置生成蓝球号码
        while (true) {
            System.out.print("请输入第" + (numbers.length) + "个蓝球号码(1-16)：");
            int d = sc.nextInt();
            if (d >= 1 && d <= 16) {
                numbers[numbers.length - 1] = d;
                break;
            } else {
                System.out.println("号码超出范围，请重新输入！");
            }
        }

        return numbers;
    }

    //3.判断随即号码和用户输入号码是否相同，是否中奖
    public static void judge(int[] luckNumbers, int[] userNumbers) {
        //1.定义两个变量分别储存红球猜中的个数，蓝球猜中的个数。
        int redHitNumbers = 0;
        int blueHitNumbers;

        //2.判断红球猜中几个，开始统计
        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = 0; j < luckNumbers.length - 1; j++) {
                //如果相等，则猜中数字
                if (userNumbers[i] == luckNumbers[j]) {
                    redHitNumbers++;
                    break;
                }
            }
        }
        //蓝球猜中个数
        blueHitNumbers = luckNumbers[6] == userNumbers[6] ? 1 : 0;
        System.out.print("中奖的号码是:");
        printArray(luckNumbers);
        System.out.print("你输入的号码是:");
        printArray(userNumbers);
        System.out.println("你猜中了" + redHitNumbers + "个红球");
        System.out.println("你是否猜中蓝球:" + (blueHitNumbers == 1 ? "是" : "否"));
        if (blueHitNumbers == 1 && redHitNumbers < 3) {
            System.out.println("恭喜你中了5元小奖");
        } else if (blueHitNumbers == 1 && redHitNumbers == 3 ||
                blueHitNumbers == 0 && redHitNumbers == 4) {
            System.out.println("恭喜你中了10元中奖");
        } else if (blueHitNumbers == 1 && redHitNumbers == 4 ||
                blueHitNumbers == 0 && redHitNumbers == 5) {
            System.out.println("恭喜你中了200元大奖");
        } else if (blueHitNumbers == 1 && redHitNumbers == 5) {
            System.out.println("恭喜你中了3000元超大奖");
        } else if (blueHitNumbers == 0 && redHitNumbers == 6) {
            System.out.println("恭喜你中了500万元超级大奖");
        } else if (blueHitNumbers == 1 && redHitNumbers == 6) {
            System.out.println("恭喜你中了1000万元巨奖");
        } else {
            System.out.println("很遗憾，你没有中奖。");
        }

    }

}
