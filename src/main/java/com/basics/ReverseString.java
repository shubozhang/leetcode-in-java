package com.basics;

/**
 *
 * @author Shubo
 * @date 9/28/2016
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseStr("abc"));

        System.out.println(reverseStr2("abcde"));
    }



    // 1. Use a StringBuilder
    public static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >=0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // 2. Recursive way to reverse a string
    public static String reverseStr2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseStr2(str.substring(1)) + str.charAt(0);
    }
}
