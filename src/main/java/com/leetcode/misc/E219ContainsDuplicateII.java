package com.leetcode.misc;


import java.util.HashMap;
import java.util.Map;

/**
 Given an integer array nums and an integer k, return true if there are two distinct indices i
 and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



 Example 1:

 Input: nums = [1,2,3,1], k = 3
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1
 Output: true
 Example 3:

 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false


 Constraints:

 1 <= nums.length <= 105
 -109 <= nums[i] <= 109
 0 <= k <= 105
 * */
public class E219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return false;
        }
        int len = nums.length;
        // <value, index>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< len; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateB(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        for (int i = 0; i< len - 1; i++) {
            for (int j = i + 1; j < len && j <= k + i; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }

            }
        }
        return false;
    }
}
