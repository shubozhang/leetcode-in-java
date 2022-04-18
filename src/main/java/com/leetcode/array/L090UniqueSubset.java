package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shubo on 8/28/2016.
 */
public class L090UniqueSubset {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        List<List<Integer>> res = subsetsB(nums);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    /**
     * Remember the start position and do backtracking
     */
    public static List<List<Integer>> subsetsB(int[] source) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(source); // unnecessary
        subsetsB(source, 0, new ArrayList<>(), res);
        return res;
    }

    public static void subsetsB(int[] source, int pos, List<Integer> set, List<List<Integer>> result) {
        result.add(new ArrayList<>(set));
        for (int i = pos; i < source.length; i++) {
            if (i != pos && source[i] == source[i - 1]) {
                continue;
            }
            set.add(source[i]); // with i
            subsetsB(source, i + 1, set, result); // DFS
            set.remove(set.size() - 1); // remove last element
        }
    }
}
