package com.leetcode.binarysearch;

/**
 * Description
 * Suppose a sorted array (no duplicate) is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * Example 1:
 * Input: array = [4, 5, 1, 2, 3] target = 1
 * Output: 2
 * Explanation: 1 is indexed at 2 in the array.
 * <p>
 * Example 2:
 * Input: array = [4, 5, 1, 2, 3] target = 0
 * Output: -1
 * Explanation: 0 is not in the array. Returns -1.
 * <p>
 * Challenge: O(logN) time
 * <p>
 * Analysis:
 three cases
 1. slope_start_mid > 0 and slope_mid_end > 0: no rotation
 2. slope_start_mid > 0 and slope_mid_end < 0: mid is in the line with start
 3. slope_start_mid < 0 and slope_mid_end > 0: mid is in the line with end
 *
 * @author shubozhang
 */
public class M033SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // case 1:  slope_start_mid > 0 and slope_mid_end > 0
            if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
                if (nums[mid] == target) {
                    return mid;
                } else if(nums[mid] < target){
                    start = mid;
                } else {
                    end = mid;
                }
            }

            // case 2: slope_start_mid > 0 and slope_mid_end < 0: mid is in the line with start
            if (nums[start] < nums[mid] && nums[mid] > nums[end]) {
                if (nums[start] <= target && target <= nums[mid]){
                    end = mid;
                } else {
                    start = mid;
                }
            }
            // case 3: slope_start_mid < 0 and slope_mid_end > 0: mid is in the line with end
            if (nums[start] > nums[mid] && nums[mid] < nums[end]) {
                if (nums[mid] <= target && target <= nums[end]){
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
}
