package com.leetcode.doublepointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/problems/4sum/
 Given an array nums of n integers, return an array of all the unique quadruplets
 [nums[a], nums[b], nums[c], nums[d]] such that:

 0 <= a, b, c, d < n
 a, b, c, and d are distinct.
 nums[a] + nums[b] + nums[c] + nums[d] == target
 You may return the answer in any order.

 Example 1:
 Input: nums = [1,0,-1,0,-2,2], target = 0
 Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

 Example 2:
 Input: nums = [2,2,2,2,2], target = 8
 Output: [[2,2,2,2]]

 Constraints:
 1) 1 <= nums.length <= 200
 2) -109 <= nums[i] <= 109
 3) -109 <= target <= 109
* */
public class M018FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i <= len - 4; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= len - 3; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int a = nums[i], b = nums[j];
                int subTarget = target - (a + b);

                int left = j + 1, right = len - 1;
                while (left < right) {
                    int cd = nums[left] + nums[right];
                    if (cd == subTarget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (cd > subTarget) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
