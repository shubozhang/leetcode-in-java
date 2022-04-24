package com.leetcode.graphsearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 https://leetcode.com/problems/subsets/
 Given an integer array nums of unique elements, return all possible subsets (the power set).

 The solution set must not contain duplicate subsets. Return the solution in any order.

 Example 1:
 Input: nums = [1,2,3]
 Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

 Example 2:
 Input: nums = [0]
 Output: [[],[0]]

 Constraints:
 1) 1 <= nums.length <= 10
 2) -10 <= nums[i] <= 10
 3) All the numbers of nums are unique.
 * */
public class M78Subsets {

    // recursive
    public static List<List<Integer>> findA(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }

        List<Integer> list = new ArrayList<Integer>();

        helper(res, list, nums, 0);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        res.add(new ArrayList<Integer>(list));


        for (int i = pos; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    // non-recursive
    public static List<List<Integer>> findB(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to a binary integer between 0 and 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 002 -> [2]
        // ...
        // 7 -> 111 -> [1, 2, 3]
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // check wheather the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0){
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        return res;
    }
}

