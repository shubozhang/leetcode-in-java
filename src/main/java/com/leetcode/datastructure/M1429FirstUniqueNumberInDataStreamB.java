package com.leetcode.datastructure;

import java.util.*;

public class M1429FirstUniqueNumberInDataStreamB {
    private Map<Integer, Integer> map = new HashMap<>();
    //
    private Set<Integer> uniqueSet = new LinkedHashSet<>();
    public M1429FirstUniqueNumberInDataStreamB(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        if (uniqueSet.isEmpty()) { return -1;}

        return uniqueSet.iterator().next();
    }

    public void add(int value) {
        int mapValue = map.getOrDefault(value, 0) + 1;
        if (mapValue == 1) {
            map.put(value, mapValue);
            uniqueSet.add(value);
        }

        if (mapValue > 1) {
            uniqueSet.remove(value);
        }
    }

}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
