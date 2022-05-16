package com.leetcode.string;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * For a given source string and a target string, you should output the first
 * index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 * */
public class T013strStr {

    public static void main(String[] args) {
        System.out.println(strStr("source", "target"));
        System.out.println(strStr("abcdabcdefg", "bcd"));
    }

    private static int strStr(String source, String target) {
        if (null == source || null == target) {
            return -1;
        }

        if (target.length() > source.length()) {
            return -1;
        }

        if ("".equals(target)) {
            return 0;
        }

        if (target.equals(source)) {
            return 0;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            for (int j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
                if (j == target.length() - 1) {
                    return i;
                }
            }

        }
        return -1;
    }
}
