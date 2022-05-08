package com.leetcode.doublepointers;


import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/4sum-ii/

 Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of
 tuples (i, j, k, l) such that:

 0 <= i, j, k, l < n
 nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


 Example 1:
 Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 Output: 2
 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

 Example 2:
 Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 Output: 1

 Constraints:
 1) n == nums1.length
 2) n == nums2.length
 3) n == nums3.length
 4) n == nums4.length
 5) 1 <= n <= 200
 6) -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 * */
public class M454FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int k : nums1) {
            for (int i : nums2) {
                int key = k + i;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int count = 0;
        for (int k : nums3) {
            for (int i : nums4) {
                int key = -(k + i);
                if (map.get(key) != null) {
                    count += map.get(key);
                }
            }
        }

        return count;
    }
}