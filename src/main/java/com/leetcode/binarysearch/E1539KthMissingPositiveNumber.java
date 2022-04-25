package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
https://leetcode.com/problems/kth-missing-positive-number/

 Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 Find the kth positive integer that is missing from this array.

 Example 1:
 Input: arr = [2,3,4,7,11], k = 5
 Output: 9
 Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

 Example 2:
 Input: arr = [1,2,3,4], k = 2
 Output: 6
 Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

 Constraints:
 1) 1 <= arr.length <= 1000
 2) 1 <= arr[i] <= 1000
 3) 1 <= k <= 1000
 4) arr[i] < arr[j] for 1 <= i < j <= arr.length


 * */
public class E1539KthMissingPositiveNumber {

    public static int findB(int[] arr, int k) {
        int start = 0, N = arr.length, end = N-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] - mid < k){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return k + start;
    }

    public static int findA(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return k;
        }

        int len = arr.length;
        if (arr[len - 1] == len) {
            return len + k;
        }

        int missingCount = arr[len - 1] - len;
        if (missingCount < k) {
            return arr[len - 1] + (k - missingCount);
        }

        List<Integer> miss = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= arr[len - 1]; i++) {
            if (miss.size() == k) {
                break;
            }
            if (arr[index] != i ) {
                miss.add(i);
            } else {
                index++;
            }
        }

        return miss.get(k - 1);
    }
}
