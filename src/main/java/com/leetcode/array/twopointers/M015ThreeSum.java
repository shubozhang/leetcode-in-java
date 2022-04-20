package com.leetcode.array.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/problems/3sum/
 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such
 that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

 Notice that the solution set must not contain duplicate triplets.

 Example 1:
 Input: nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]

 Example 2:
 Input: nums = []
 Output: []

 Example 3:
 Input: nums = [0]
 Output: []

 Constraints:
 1) 0 <= nums.length <= 3000
 2) -105 <= nums[i] <= 105

 Analysis:
 1) sort array
 2) assume a < b < c, start to loop a from 0 to length - 2
 3) find two sum: b+c = -a ==> find target -a from nums[] in two sum
 4) only return the values, not index
 5) no duplicates

 * */
public class M015ThreeSum {

    public static List<List<Integer>> find(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);

        // a < b < c, iterate from a
        for(int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                // skip duplicates
                continue;
            }

            int left = i + 1, right = nums.length -1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    right--;
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        // skip duplicates
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        // skip duplicates
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }
}