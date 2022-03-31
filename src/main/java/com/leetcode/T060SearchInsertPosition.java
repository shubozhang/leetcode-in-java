package com.leetcode;

/**
 *  Given a sorted array and a target value, return the index if the target is found.
 *  If not, return the index where it would be if it were inserted in order.
 *  You may assume NO duplicates in the array.
 *
 *  Example
 *  [1,3,5,6], 5 → 2
 *  [1,3,5,6], 2 → 1
 *  [1,3,5,6], 7 → 4
 *  [1,3,5,6], 0 → 0
 *
 * @author shubozhang
 */
public class T060SearchInsertPosition {

    public static int getPosition(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                hi = mid;
            } else if (arr[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (arr[lo] > target) {
            return lo > 0 ? lo - 1 : 0;
        } else if (arr[lo] == target) {
            return lo;
        } else if (arr[lo] < target && target < arr[hi]) {
            return lo + 1;
        } else if (arr[hi] == target) {
            return hi;
        } else {
            return hi + 1;
        }
    }
}
