package com.selonsy.learnjava;

/**
 * Copyright：Sichen International Co. Ltd.
 * 实现加减乘除的简单的计算类，此类仅用来示例JUnit单元测试。
 *
 * @author selonsy
 * Created on 2019/11/28.
 * Desc : none
 */
public class StudyJunit {

    public static void main(String[] args) {
        System.out.println("Junit Study~");
    }

    public static int staticAdd(int a, int b) {
        return a + b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    public static String capitalize(String s) {
        // 把字符串的第一个字母变成大写，后面的变成小写
        if (s.length() == 0) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

}
