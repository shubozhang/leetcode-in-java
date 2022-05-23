package com.leetcode.datastructure;

import java.util.*;

public class M1429FirstUniqueNumberInDataStream {
    private Map<Integer, Integer> map = new LinkedHashMap<>();
    private Set<Integer> dupSet = new HashSet<>();
    public M1429FirstUniqueNumberInDataStream(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        if (map.isEmpty()) { return -1;}

        for (Integer key : map.keySet()) {
            return key;
        }

        return -1;
    }

    public void add(int value) {
        if (dupSet.contains(value)) { return; }

        int mapValue = map.getOrDefault(value, 0) + 1;
        if (mapValue == 1) {
            map.put(value, mapValue);
        }

        if (mapValue > 1) {
            map.remove(value);
            dupSet.add(value);
        }
    }

}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
