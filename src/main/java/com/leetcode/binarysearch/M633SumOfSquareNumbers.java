package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class M633SumOfSquareNumbers {

    public static boolean isSquareSumB(int c) {
        long start = 0;
        long end = (long)Math.sqrt(c);

        while (start <= end) {
            if (sum(start, end) == c) {
                return true;
            } else if (sum(start, end) > c) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }

    private static long sum(long m , long n) {
        return m * m + n * n;
    }



}
