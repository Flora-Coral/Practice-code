package com.案例练习;

//数组元素复制
public class Demo4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[arr1.length];
        //复制arr1的元素到arr2
        copy(arr1, arr2);
        //打印arr1
        printArray(arr1);
        //打印arr2
        printArray(arr2);

    }

    public static void printArray(int[] arr) {
        //打印数组
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }

    public static void copy(int[] arr1, int[] arr2) {
        //复制arr1的元素到arr2
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }
}
