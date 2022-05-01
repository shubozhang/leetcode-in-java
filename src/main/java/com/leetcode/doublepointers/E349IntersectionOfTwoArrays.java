package com.leetcode.doublepointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 https://leetcode.com/problems/intersection-of-two-arrays/

 Given two integer arrays nums1 and nums2, return an array of their intersection.
 Each element in the result must be unique and you may return the result in any order.

 Example 1:
 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]

 Example 2:
 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Explanation: [4,9] is also accepted.

 Constraints:
 1) 1 <= nums1.length, nums2.length <= 1000
 2) 0 <= nums1[i], nums2[i] <= 1000

 */
public class E349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }

        if (nums1.length >= nums2.length) {
            return find(nums1, nums2);
        } else {
            return find(nums2, nums1);
        }
    }

    private int[] find(int[] arr1, int[] arr2) {
        // len1 >= len2
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Set<Integer> res = new HashSet<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                res.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            }

            if (res.size() == arr2.length) {
                break;
            }
        }


        return res.stream().mapToInt(Integer::intValue).toArray();
    }


}
