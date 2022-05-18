package com.leetcode.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 Given an array nums of size n, return the majority element.

 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that
 the majority element always exists in the array.



 Example 1:

 Input: nums = [3,2,3]
 Output: 3
 Example 2:

 Input: nums = [2,2,1,1,1,2,2]
 Output: 2


 Constraints:

 n == nums.length
 1 <= n <= 5 * 104
 -109 <= nums[i] <= 109
 * */
public class E169MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    public int majorityElementB(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }

            if (map.get(i) > len / 2) {
                return i;
            }
        }

        return -1;
    }
}
