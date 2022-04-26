package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/problems/intersection-of-two-arrays-ii/
 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element
 in the result must appear as many times as it shows in both arrays and you may return the result
 in any order.

 Example 1:
 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2,2]

 Example 2:
 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [4,9]
 Explanation: [9,4] is also accepted.

 Constraints:
 1) 1 <= nums1.length, nums2.length <= 1000
 2) 0 <= nums1[i], nums2[i] <= 1000

 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot
 load all elements into the memory at once?
 * */
public class E350IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> res = new ArrayList<>();

        if (len1 <= len2) {
            search(nums1, nums2, res);
        } else {
            search(nums2, nums1, res);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // assume len_arr1 <= len_arr2
    private static void search(int[] arr1, int[] arr2, List<Integer> res) {
        for (int i = 0; i < arr1.length; i++) {
            if (find(arr1[i], arr2)) {
                res.add(arr1[i]);
                Arrays.sort(arr2);
            }
        }
    }

    private static boolean find(int target, int[] nums) {
        int start = 0, end = nums.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                nums[mid] = Integer.MAX_VALUE;
                return true;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            nums[start] = Integer.MAX_VALUE;
            return true;
        }
        if (nums[end] == target) {
            nums[end] = Integer.MAX_VALUE;
            return true;
        }

        return false;
    }

}
