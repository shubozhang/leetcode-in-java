package com.leetcode.binarysearch.medium;


/**
 Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 position of a given target value.

 If target is not found in the array, return [-1, -1].

 You must write an algorithm with O(log n) runtime complexity.

 Example 1:
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]

 Example 2:
 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]

 Example 3:
 Input: nums = [], target = 0
 Output: [-1,-1]


 Constraints:
 1) 0 <= nums.length <= 105
 2) -109 <= nums[i] <= 109
 3) nums is a non-decreasing array.
 4) -109 <= target <= 109
 * */
public class L034FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int first = -1;
        int last = -1;
        res[0] = first;
        res[1] = last;

        if (nums == null || nums.length == 0) {
            return res;
        }


        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                first = mid;
                last = mid;
                break;
            }
        }

        // from break
        if (first > 0) {
            int split = first;
            for (int i = split; i >= 0; i--) {
                if (nums[i] == target) {
                    first = i;
                } else {
                    break;
                }
            }
            for (int i = split; i < nums.length; i++) {
                if (nums[i] == target) {
                    last = i;
                } else {
                    break;
                }
            }

        } else {
            if (nums[start] == target && nums[end] == target) {
                first = start;
                last = end;
            }
            if ( nums[start] == target && nums[end] != target) {
                first = start;
                last = start;
            }
            if ( nums[start] != target && nums[end] == target) {
                first = end;
                last = end;
            }
        }

        res[0] = first;
        res[1] = last;
        return res;
    }
}