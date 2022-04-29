package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 https://leetcode.com/problems/find-k-closest-elements/
 Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 The result should also be sorted in ascending order.

 An integer a is closer to x than an integer b if:
 |a - x| < |b - x|, or
 |a - x| == |b - x| and a < b

 Example 1:
 Input: arr = [1,2,3,4,5], k = 4, x = 3
 Output: [1,2,3,4]

 Example 2:
 Input: arr = [1,2,3,4,5], k = 4, x = -1
 Output: [1,2,3,4]

 Constraints:
 1) 1 <= k <= arr.length
 2) 1 <= arr.length <= 104
 3) arr is sorted in ascending order.
 4) -104 <= arr[i], x <= 104
 * */
public class M658FindKClosestElements {


    public static List<Integer> findB(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int start = 0, end = arr.length - 1;
        int index = -1;
        // step 1: find the index of the element which is cloest to x
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                index = mid;
                break;
            }
            if (arr[mid] > x){
                end = mid;
            } else {
                start = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (index == -1) {
            if (arr[end] - x >= x - arr[start]) {
                index = start;
            } else {
                index = end;
            }
        }
        int i = index - 1, j = index + 1;
        res.add(arr[index]);
        boolean leftPick = true;
        boolean rightPick = true;

        // step 2: start from index and search k elements via double pointers.
        while (leftPick || rightPick) {
            if (i == -1) { leftPick = false;}
            if (j == arr.length) { rightPick = false;}

            if (res.size() == k) {
                break;
            }
            if (leftPick && rightPick) {
                if (arr[j] - x >= x - arr[i]) {
                    res.add(arr[i--]);
                } else {
                    res.add(arr[j++]);
                }
                continue;
            }

            if (leftPick) {
                res.add(arr[i--]);
            }
            if (rightPick) {
                res.add(arr[j++]);
            }
        }

        Collections.sort(res);
        return res;
    }
}
