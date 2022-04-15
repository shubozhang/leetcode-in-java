package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* Given an array of integers, find two numbers such that they add up to a
* specific target number.

The function twoSum should return indices of the two numbers such that they
add up to the target, where index1 must be less than index2.
Please note that your returned answers (both index1 and index2) are zero-based.


Challenge
Either of the following solutions are acceptable:

O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time

Example
numbers=[2, 7, 11, 15], target=9

return [0, 1]
Assumption: You may assume that each input would have exactly one solution
* */
public class T056TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);

        Arrays.stream(twoSum2(nums, target)).forEach(System.out::println);
    }

    private static int[] twoSum(int[] nums, int target) {
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

    private static int[] twoSum2(int[] nums, int target){
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
