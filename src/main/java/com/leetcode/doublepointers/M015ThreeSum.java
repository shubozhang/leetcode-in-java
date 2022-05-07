package com.leetcode.doublepointers;

import java.util.*;

/**
 https://leetcode.com/problems/3sum/
 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such
 that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

 Notice that the solution set must not contain duplicate triplets.

 Example 1:
 Input: nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]

 Example 2:
 Input: nums = []
 Output: []

 Example 3:
 Input: nums = [0]
 Output: []

 Constraints:
 1) 0 <= nums.length <= 3000
 2) -105 <= nums[i] <= 105

 Analysis:
 1) sort array
 2) assume a < b < c, start to loop a from 0 to length - 2
 3) find two sum: b+c = -a ==> find target -a from nums[] in two sum
 4) only return the values, not index
 5) no duplicates

 * */
public class M015ThreeSum {

    // version A: two pointers approach
    // reduce the dimension and re-use twoSum
    public List<List<Integer>> versionA(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);
        int len = nums.length;

        // a < b < c, iterate from a and find twoSum b, c in range [i, len - 1]
        for(int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                // skip duplicates
                continue;
            }

            int left = i + 1, right = len -1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    right--;
                    left++;

                    // skip duplicates in left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // skip duplicates in right
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }


    // version B: extract twoSum method out
    public List<List<Integer>> versionB(int[] A) {
        List<List<Integer>> results = new ArrayList<>();
        if (A == null || A.length < 3) {
            return results;
        }

        Arrays.sort(A);
        int len = A.length;
        for (int i = 0; i < len - 2; i++) {
            // skip duplicates
            if (i != 0 && A[i] == A[i - 1]) {
                continue;
            }

            twoSum(A, i , results);
        }
        return results;
    }

    private void twoSum(int[] A, int index, List<List<Integer>> results) {
        int left = index + 1;
        int right = A.length - 1;
        int target = -A[index];

        while (left < right) {
            int sum = A[left] + A[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                list.add(index);
                results.add(list);

                left++;
                right--;
                // skip dups
                if (left < right && A[left] == A[left - 1]){
                    left++;
                }
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

}