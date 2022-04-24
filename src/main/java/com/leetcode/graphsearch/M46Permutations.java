package com.leetcode.graphsearch;


import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/problems/permutations/
 Given an array nums of distinct integers, return all the possible permutations. You can return the
 answer in any order.

 Example 1:
 Input: nums = [1,2,3]
 Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 Example 2:
 Input: nums = [0,1]
 Output: [[0,1],[1,0]]

 Example 3:
 Input: nums = [1]
 Output: [[1]]

 Constraints:
 1) 1 <= nums.length <= 6
 2) -10 <= nums[i] <= 10
 3) All the integers of nums are unique.
 * */
public class M46Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }

        List<Integer> list = new ArrayList<Integer>();

        helper(res, list, nums);

        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
