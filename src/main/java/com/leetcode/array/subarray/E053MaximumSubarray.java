package com.leetcode.array.subarray;

/**
 https://leetcode.com/problems/maximum-subarray/
 Given an integer array nums, find the contiguous subarray (containing at least one number) which
 has the largest sum and return its sum.

 A subarray is a contiguous part of an array.

 Example 1:
 Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.

 Example 2:
 Input: nums = [1]
 Output: 1

 Example 3:
 Input: nums = [5,4,-1,7,8]
 Output: 23

 Constraints:
 1) 1 <= nums.length <= 105
 2) -104 <= nums[i] <= 104

 Follow up: If you have figured out the O(n) solution, try coding another solution using the
 divide and conquer approach, which is more subtle.

 Same problem: E121BestTimeToBuyAndSellStock

 NOTE: for max sub array between[i, j] is sum[j] - sum[i - 1]
 * */
public class E053MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // DP problem:
        // f[i] means the max sub array at index i
        // f[i] init value is nums[i], if (f[i - 1] + nums[i]) <= nums[i], f[i] still equals nums[i]
        // f[i] = max(nums[i], (f[i - 1] + nums[i]))
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(nums[i], (f[i - 1] + nums[i]));
            res = Math.max(res, f[i]);
        }

        return res;
    }
}
