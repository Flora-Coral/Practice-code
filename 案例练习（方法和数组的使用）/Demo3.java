package com.案例练习;

import java.util.Random;

//开发验证码
public class Demo3 {
    public static void main(String[] args) {
        //5.调用方法，生成验证码
        String code = createCode(5);
        System.out.println("验证码为:" + code);
    }

    //1.定义一个方法，返回一个字符串
    public static String createCode(int n) {
        //4.定义一个字符串变量记录验证码
        String code = "";
        Random r = new Random();
        //2.定义一个for循环，循环n次，随机生成字符
        for (int i = 0; i < n; i++) {
            //3.随机生成一个字符
            int type = r.nextInt(3);//0-2
            switch (type) {
                case 0:
                    //大写字母 (A 65 - Z 90 (25+65))
                    char ch = (char) (r.nextInt(26) + 65);
                    code += ch;
                    break;
                case 1:
                    //小写字母 (a 97 - z 122 (25+97))
                    char ch1 = (char) (r.nextInt(26) + 97);
                    code += ch1;
                    break;
                case 2:
                    //数字  (0 - 9)
                    code += r.nextInt(10);
                    break;
                default:
                    break;

            }
        }
        return code;
    }
}

