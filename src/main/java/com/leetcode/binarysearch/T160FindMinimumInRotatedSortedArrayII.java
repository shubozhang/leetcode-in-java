package com.leetcode.binarysearch;

/**
 It is similar to T159. The only difference is that this question may contain duplicates.

 Analysis: when it contains duplicates, binary search is not able to know which direction it should
 move in the next step. So O(n) is the solution.
 @author shubozhang
 */
public class T160FindMinimumInRotatedSortedArrayII {

    public static int find(int[] nums){
        if (nums == null || nums.length ==0) {
            return -1;
        }

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
