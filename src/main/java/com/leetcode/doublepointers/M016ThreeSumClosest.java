package com.leetcode.doublepointers;

import java.util.Arrays;

/**
 https://leetcode.com/problems/3sum-closest/

 Given an integer array nums of length n and an integer target, find three integers in nums such
 that the sum is closest to target.

 Return the sum of the three integers.

 You may assume that each input would have exactly one solution.

 Example 1:
 Input: nums = [-1,2,1,-4], target = 1
 Output: 2
 Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 Example 2:
 Input: nums = [0,0,0], target = 1
 Output: 0

 Constraints:
 1) 3 <= nums.length <= 1000
 2) -1000 <= nums[i] <= 1000
 3) -104 <= target <= 104

 * */
public class M016ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int len = nums.length;

        for (int i = 0; i < len - 2 && diff != 0; i++) {
            int lo = i + 1;
            int hi = len - 1;

            // improve performance a little bit
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }

                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }

        }
        return target - diff;
    }

}
