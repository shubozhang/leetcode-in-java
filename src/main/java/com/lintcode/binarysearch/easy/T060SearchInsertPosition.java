package com.lintcode.binarysearch.easy;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.

 * Example
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class T060SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target1 = 5;
        int pos1 = searchInsertPosition(nums, target1);
        System.out.println(target1 + "->" + pos1);

        int target2 = 2;
        int pos2 = searchInsertPosition(nums, target2);
        System.out.println(target2 + "->" + pos2);

        int target3 = 7;
        int pos3 = searchInsertPosition(nums, target3);
        System.out.println(target3 + "->" + pos3);

        int target4 = 0;
        int pos4 = searchInsertPosition(nums, target4);
        System.out.println(target4 + "->" + pos4);
    }

    private static int searchInsertPosition(int[] nums, int target) {
        
        int start =0;
        int end = nums.length - 1;
        int mid;

        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[end]) {
            return nums.length;
        }
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else if (nums[start] < target && target < nums[end]) {
            return start + 1;
        }
        
        return -1;
    }
}
