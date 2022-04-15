package com.leetcode.string;

public class T008RotateString {

    public static void main(String[] args) {
        char[] str = "abcdefg".toCharArray();
        char[] str2 = "abccba".toCharArray();
        rotateString01(str, 2);
        System.out.println(str);

        rotateString02(str2, 3);
        System.out.println(str2);

    }

    private static void rotateString01(char[] str, int offset) {
        final int len = str.length;
        final int k = offset % len;
        char[] res = new char[len];

        if (k == 0) {
            return;
        } else {
            for (int i = 0; i < len; i++) {
                if ((i + k) < len) {
                    res[i + k] = str[i];
                } else {
                    res[i + k - len] = str[i];
                }
            }

        }
    }

    private static void rotateString02(char[] str, int offset) {
        if(str == null || str.length == 0 || offset % str.length ==0){
            return;
        }
        int len = str.length;
        offset = offset % len;
        reverse(str, 0, len - offset - 1);
        reverse(str, len - offset, len - 1);
        reverse(str, 0, len - 1);
    }

    private static void reverse(char[] str, int start, int end){
        for (int i = start, j = end; i < j; i++, j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
