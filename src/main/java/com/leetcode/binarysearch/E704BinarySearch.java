package com.leetcode.binarysearch;


/**
 * For a given sorted array (ascending order) and a target number,
 * find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * <p>
 * Example
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 *
 * @author shubozhang
 */
public class E704BinarySearch {

    public static int search(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo + 1 < hi) {
            // avoid mid exceeding the max of int
            mid = (hi - lo) / 2 + lo;
            if (arr[mid] == target) {
                hi = mid;
            } else if (arr[mid] < target) {
                lo = mid;
            } else if (arr[mid] > target) {
                hi = mid;
            }
        }
        if (arr[lo] == target) {
            return lo;
        }
        if (arr[hi] == target) {
            return hi;
        }

        return -1;
    }
}
