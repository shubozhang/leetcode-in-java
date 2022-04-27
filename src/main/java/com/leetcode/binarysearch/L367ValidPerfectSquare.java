package com.leetcode.binarysearch;

/**
 * @author shubozhang
 */
public class L367ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }

        int start = 2;
        int end = num;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // mid * mid will exceed Integer.max
            if ((num % mid == 0) && (num / mid == mid)) {
                return true;
            } else if (num / mid <= mid) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (start * start == num || end * end == num) {
            return true;
        } else {
            return false;
        }
    }
}
