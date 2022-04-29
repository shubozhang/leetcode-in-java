package com.leetcode.binarysearch;


/**
 * https://leetcode.com/problems/binary-search/
 * <p>
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

    public static int searchA(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        return recursiveSearch(arr, left, right, target);
    }

    private static int recursiveSearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            return recursiveSearch(arr, left, mid - 1, target);
        }

        return recursiveSearch(arr, mid + 1, right, target);

    }


    // double pointers
    public static int searchB(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
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
