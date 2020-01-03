package com.selonsy.study;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class CommonTools {
    public static void main(String[] args) {
//        求绝对值：
        System.out.println(Math.abs(-100)); // 100
        System.out.println(Math.abs(-7.8)); // 7.8

//        取最大或最小值：
        System.out.println(Math.max(100, 99)); // 100
        System.out.println(Math.min(1.2, 2.3)); // 1.2

//        计算x的y次方：
        System.out.println(Math.pow(2, 10)); // 2的10次方=1024

//        计算根号x：
        System.out.println(Math.sqrt(2)); // 1.414...

//        计算e的x次方：
        System.out.println(Math.exp(2)); // 7.389...

//        计算以e为底的对数：
        System.out.println(Math.log(4)); // 1.386...

//        计算以10为底的对数：
        System.out.println(Math.log10(100)); // 2

//        三角函数：
        System.out.println(Math.sin(3.14)); // 0.00159...
        System.out.println(Math.cos(3.14)); // -0.9999...
        System.out.println(Math.tan(3.14)); // -0.0015...
        System.out.println(Math.asin(1.0)); // 1.57079...
        System.out.println(Math.acos(1.0)); // 0.0

//        数学常量：
        double pi = Math.PI; // 3.14159...
        double e = Math.E; // 2.7182818...
        System.out.println(Math.sin(Math.PI / 6)); // sin(π/6) = 0.5

//        生成一个随机数x，x的范围是0 <= x < 1：
        System.out.println(Math.random()); // 0.53907... 每次都不一样
//        生成一个区间在[MIN, MAX)的随机数
        double x = Math.random(); // x的范围是[0,1)
        double min = 10;
        double max = 50;
        double y = x * (max - min) + min; // y的范围是[10,50)
        long n = (long) y; // n的范围是[10,50)的整数
        System.out.println(y);
        System.out.println(n);
//        要生成一个随机数，可以使用nextInt()、nextLong()、nextFloat()、nextDouble()：
        Random r = new Random();//不指定随机数种子，以系统时间戳为种子
        Random r1 = new Random(12345); //指定随机数seed种子，导致每次随机结果一样
        System.out.println(r.nextInt()); // 2071575453,每次都不一样
        System.out.println(r.nextInt(10)); // 5,生成一个[0,10)之间的int
        System.out.println(r.nextLong()); // 8811649292570369305,每次都不一样
        System.out.println(r.nextFloat()); // 0.54335...生成一个[0,1)之间的float
        System.out.println(r.nextDouble()); // 0.3716...生成一个[0,1)之间的double
//        真随机数
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException ee) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
    }
}
