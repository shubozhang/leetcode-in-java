package com.leetcode.datastructure;


import java.util.*;

/**
 Description
 Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the
 same probability of being returned.

 Example
 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 2 is the only number in the set, getRandom always return 2.
 randomSet.getRandom();

 Analysis:
 Two hashMaps method
 * */
public class L657InsertDeleteGetRandomB {
    private Map<Integer, Integer> valIndex = new HashMap<>();
    private Map<Integer, Integer> indexVal = new HashMap<>();
    private Random rand = new Random();
    public L657InsertDeleteGetRandomB() {
        // do intialization if necessary
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (valIndex.containsKey(val)) {
            return false;
        }

        valIndex.put(val, valIndex.size());
        indexVal.put(indexVal.size(), val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!valIndex.containsKey(val)) {
            return false;
        }
        int index = valIndex.get(val);
        int lastNum = indexVal.get(indexVal.size() - 1);
        valIndex.remove(val);
        indexVal.remove(indexVal.size() - 1);

        valIndex.put(lastNum, index);
        indexVal.put(index, lastNum);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        return indexVal.get(rand.nextInt(indexVal.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */