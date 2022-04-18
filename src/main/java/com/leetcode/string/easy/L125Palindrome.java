package com.leetcode.string.easy;

/**
 * Created by Shubo on 8/27/2016.
 */
public class L125Palindrome {

    public static boolean isPalindrome(String input) {
        if (null == input) {
            return false;
        }
        if (input.length() <= 1) {
            return true;
        }

        String s = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int i = 0;
        int j = s.length() -1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) { return false;}
            i++;
            j--;
        }

        return true;
    }
}
