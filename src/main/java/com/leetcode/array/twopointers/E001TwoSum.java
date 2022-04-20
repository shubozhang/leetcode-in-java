package com.leetcode.array.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/two-sum/
 Given an array of integers nums and an integer target, return indices of the two numbers such
 that they add up to target.

 You may assume that each input would have exactly one solution, and you may not use the same
 element twice.

 You can return the answer in any order.

 Example 1:
 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 Example 2:
 Input: nums = [3,2,4], target = 6
 Output: [1,2]

 Example 3:
 Input: nums = [3,3], target = 6
 Output: [0,1]

 Constraints:
 1) 2 <= nums.length <= 104
 2) -109 <= nums[i] <= 109
 3) -109 <= target <= 109
 4) Only one valid answer exists.

 Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
* */
public class E001TwoSum {

    public static int[] twoPointers(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // use copyNums to find original indexs of left and right
        int[] copyNums = Arrays.copyOf(nums, nums.length);

        // Sort nums, so it can use two pointers approach
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];

        while(left < right) {
            int twoSum = nums[left] + nums[right];
            if (twoSum == target) {
                break;
            } else if (twoSum > target) {
                right--;
            } else {
                left++;
            }
        }

        // find original indexes
        boolean findRes1 = false, findRes2 = false;
        for (int i = 0; i < copyNums.length; i++) {
            if (copyNums[i] == nums[left] && !findRes1) {
                res[0] = i;
                findRes1 = true;
            } else if (copyNums[i] == nums[right] && !findRes2) {
                res[1] = i;
                findRes2 = true;
            } else if (findRes1 && findRes2) {
                break;
            }
        }
        // make sure left index is smaller than right one
        Arrays.sort(res);
        return res;
    }


    public static int[] twoSumN2(int[] nums, int target) {
        int[] res = {-1,-1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] twoSumByHashMap(int[] nums, int target){
        if(nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
