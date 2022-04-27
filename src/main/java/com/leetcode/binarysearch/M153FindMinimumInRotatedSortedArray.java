package com.leetcode.binarysearch;

/**
 * Description
 * Suppose a sorted array (no duplicate) in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * *You can assume no duplicate exists in the array.**
 * <p>
 * Example 1:
 * Input：[4, 5, 6, 7, 0, 1, 2]
 * Output：0
 * Explanation：The minimum value in an array is 0.
 * <p>
 * Example 2:
 * Input：[2,1]
 * Output：1
 * Explanation：The minimum value in an array is 1.
 * <p>
 * Analysis:
 * three cases
 * 1. slope_start_mid > 0 and slope_mid_end > 0: no rotation
 * 2. slope_start_mid > 0 and slope_mid_end < 0: mid is in the line with start
 * 3. slope_start_mid < 0 and slope_mid_end > 0: mid is in the line with end
 *
 * @author shubozhang
 */
public class M153FindMinimumInRotatedSortedArray {

    public static int find(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // case 1:  slope_start_mid > 0 and slope_mid_end > 0
            if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
                return nums[start];
            }

            // case 2: slope_start_mid > 0 and slope_mid_end < 0: mid is in the line with start
            if (nums[start] < nums[mid] && nums[mid] > nums[end]) {
                start = mid;
            }
            // case 3: slope_start_mid < 0 and slope_mid_end > 0: mid is in the line with end
            if (nums[start] > nums[mid] && nums[mid] < nums[end]) {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
