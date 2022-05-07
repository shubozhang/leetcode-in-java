package com.leetcode.doublepointers;


import java.util.Arrays;

/**
 https://www.lintcode.com/problem/382/
 Description
 Given an array of integers, how many three numbers can be found in the array, so that we
 can build a triangle whose three edges length is the three numbers that we find?

 Example 1:
 Input: [3, 4, 6, 7]
 Output: 3
 Explanation:
 They are (3, 4, 6),
 (3, 6, 7),
 (4, 6, 7)

 Example 2:
 Input: [4, 4, 4, 4]
 Output: 4
 Explanation:
 Any three numbers can form a triangle.
 So the answer is C(3, 4) = 4
 * */
public class MT382TriangleCount {
    /**
     * @param nums: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;

        for (int i = 2; i < len; i++) {
            int left = 0;
            int right = i - 1;
            int target = nums[i];

            while (left < right && right < i) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    res += (right - left);
                    right--;
                } else if (sum <= target) {
                    left++;
                }
            }
        }
        return res;
    }
}
