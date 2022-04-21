package com.leetcode.array;

/**
 https://www.lintcode.com/problem/80/

 Description
 Given an unsorted array with integers, find the median of it.

 A median is the middle number of the ascending array after it is sorted.

 If there are even numbers in the array, return the N/2-th number after sorted.

 The size of array is not exceed 10000

 Example 1:
 Input: array = [4, 5, 1, 2, 3]
 Output: 3
 Explanation: After sorting，[1,2,3,4,5]，the middle number is 3

 Example 2:
 Input: array = [7, 9, 4, 5]
 Output: 5
 Explanation: After sorting，[4,5,7,9]，the second(4/2) number is 5

 Challenge
 O(n) time.
* */
public class ET080MedianOfUnsortedArray {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public static int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int k = n % 2 == 0 ? n / 2 : n / 2 + 1;
        return quickSelect(nums, 0, n - 1, k - 1);
    }

    private static int quickSelect(int[] A, int start, int end, int k) {
        if (start == end) {
            return A[start];
        }
        int left = start, right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }
        if (k >= start && k <= right) {
            return quickSelect(A, start, right, k);
        }
        if (k >= left && k <= end) {
            return quickSelect(A, left, end, k);
        }
        return A[right + 1];
    }
}
