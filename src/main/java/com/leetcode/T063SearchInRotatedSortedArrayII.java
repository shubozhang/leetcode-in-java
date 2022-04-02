package com.leetcode;

/**
 This question is similar to T062. The only difference is sorted array with duplicates.

 Solution: O(n)

 @author shubozhang
 */
public class T063SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }

        return false;
    }
}
