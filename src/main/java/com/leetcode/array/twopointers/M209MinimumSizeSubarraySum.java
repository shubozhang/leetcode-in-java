package com.leetcode.array.twopointers;

/**
 https://leetcode.com/problems/minimum-size-subarray-sum/

 Given an array of positive integers nums and a positive integer target, return the minimal
 length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater
 than or equal to target. If there is no such subarray, return 0 instead.

 Example 1:
 Input: target = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: The subarray [4,3] has the minimal length under the problem constraint.

 Example 2:
 Input: target = 4, nums = [1,4,4]
 Output: 1

 Example 3:
 Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 Output: 0

 Constraints:
 1) 1 <= target <= 109
 2) 1 <= nums.length <= 105
 3) 1 <= nums[i] <= 105

 Follow up: If you have figured out the O(n) solution, try coding another solution of which the
 time complexity is O(n log(n)).
 * */
public class M209MinimumSizeSubarraySum {
    
    // double pointers
    public static int search(int target, int[] nums) {
        int curSum = 0, res = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                res = Math.min(res, right - left + 1);
                curSum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // DP approach
    public static int minSubArrayLenDP(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums[0] >= target) { return 1;}
        // f[i] is the mini length at index i
        int[] f = new int[nums.length];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int res = Integer.MAX_VALUE;


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= target) { return 1;}

            sums[i] = sums[i - 1] + nums[i];

            if (f[i - 1] == 0) {
                if (sums[i] >= target) {
                    f[i] = Math.min((i + 1), findBest(i, nums, i,target));
                }
            } else if (f[i - 1] > 0) {
                f[i] = Math.min(f[i - 1], findBest(f[i - 1], nums, i, target));
            }

            if (f[i] > 0) {
                res = Math.min(res, f[i]);
            }

        }

        return res == Integer.MAX_VALUE ? 0: res;
    }

    private static int findBest(int len, int[] nums, int pos, int target) {
        int lenPos = len + 1;
        int total = 0;
        for (int i = len; i > 0; i--) {
            total = total + nums[pos - i];
        }
        for (int i = len; i > 0; i--) {
            total = total - nums[pos - i];
            if (total + nums[pos] >= target) {
                lenPos--;
            }
        }
        return lenPos;
    }
}
