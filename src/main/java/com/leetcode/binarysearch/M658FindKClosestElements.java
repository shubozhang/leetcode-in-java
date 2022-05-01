package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * <p>
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 * <p>
 * Constraints:
 * 1) 1 <= k <= arr.length
 * 2) 1 <= arr.length <= 104
 * 3) arr is sorted in ascending order.
 * 4) -104 <= arr[i], x <= 104
 */
public class M658FindKClosestElements {

    public List<Integer> findA(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (r - l + 1 > k) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }
        return res;
    }


    public static List<Integer> findB(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int start = 0, end = arr.length - 1;
        // step 1: find the index of the element which is cloest to x
        int index = findIndex(arr, start, end, x);

        List<Integer> res = new ArrayList<>();
        int i = index - 1, j = index + 1;
        res.add(arr[index]);

        // step 2: start from index and search k elements via double pointers.
        while (i >= 0 || j <= arr.length - 1) {
            if (res.size() == k) {
                break;
            }
            if (i >= 0 && j <= arr.length - 1) {
                if (arr[j] - x >= x - arr[i]) {
                    res.add(arr[i--]);
                } else {
                    res.add(arr[j++]);
                }
                continue;
            }

            if (i >= 0) {
                res.add(arr[i--]);
            }
            if (j <= arr.length - 1) {
                res.add(arr[j++]);
            }
        }

        Collections.sort(res);
        return res;
    }

    private static int findIndex(int [] arr, int start, int end, int x) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (arr[end] - x >= x - arr[start]) {
            return start;
        } else {
            return end;
        }
    }
}
