package com.lintcode.binarysearch.medium;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * Example
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 */
public class T062SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 3};

        System.out.println(1 + " -> " + searchI(nums, 1));
        System.out.println(0 + " -> " + searchI(nums, 0));
    }

    private static int searchI(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    // Use two binary search: first binary search gets min value; Second binary search find target
    private static  int searchII(int[] nums, int target) {
        return -1;
    }
}
