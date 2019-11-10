package com.selonsy.demo;

/**
 * Copyright：Sichen International Co. Ltd.
 *
 * @author selonsy
 * Created on 2019/11/10.
 * Desc : none
 */
public class CommonTools {
    public static void main(String[] args){
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

    }
}
