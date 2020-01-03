package com.selonsy.study;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Arrays;

/**
 * 学习基础的输入输出操作
 */
public class IO {
    public static void main(String[] args){
//        System.out.println("Hello Selonsy");
//        int i3 = 2_000_000_000; // 加下划线更容易识别
//        int i4 = i3+1;
//        System.out.println(i3);
//        System.out.println(i4);
//        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
//        System.out.print("Input your name: "); // 打印提示
//        String name = scanner.nextLine(); // 读取一行输入并获取字符串
//        System.out.print("Input your age: "); // 打印提示
//        int age = scanner.nextInt(); // 读取一行输入并获取整数
//        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出

//        int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
//        // 排序前:
//        System.out.println(Arrays.toString(ns));
//        for (int i = 0; i < ns.length - 1; i++) {
//            for (int j = 0; j < ns.length - i - 1; j++) {
//                if (ns[j] > ns[j+1]) {
//                    // 交换ns[j]和ns[j+1]:
//                    int tmp = ns[j];
//                    ns[j] = ns[j+1];
//                    ns[j+1] = tmp;
//                }
//            }
//        }
//        // 排序后:
//        System.out.println(Arrays.toString(ns));
        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(d4.scale()); // -2
        System.out.println(d4); // -2
    }
}
