package com.leetcode.binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 *
 * @author shubozhang
 */
public class E035SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

    public static int getPosition(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                hi = mid;
            } else if (arr[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (arr[lo] > target) {
            return lo > 0 ? lo - 1 : 0;
        } else if (arr[lo] == target) {
            return lo;
        } else if (arr[lo] < target && target < arr[hi]) {
            return lo + 1;
        } else if (arr[hi] == target) {
            return hi;
        } else {
            return hi + 1;
        }
    }
}
