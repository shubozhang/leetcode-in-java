package com.leetcode.binarysearch;

/**
 https://www.lintcode.com/problem/447/
 Description
 Given a big sorted array with non-negative integers sorted by non-decreasing order.
 The array is so big so that you can not get the length of the whole array directly, and you can only access
 the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++).

 Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of
 the target number.

 Return -1, if the number doesn't exist in the array.

 If you accessed an inaccessible index (outside the array), ArrayReader.get will return 2,147,483,647.

 Example 1:
 Input: [1, 3, 6, 9, 21, ...], target = 3
 Output: 1

 Example 2:
 Input: [1, 3, 6, 9, 21, ...], target = 4
 Output: -1

 Challenge
 O(logn) time, n is the first index of the given target number.
 * */
public class M702SearchInABigSortedArray {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int k = 1;
        while (reader.get(k) < target) {
            k = 2 * k;
        }

        int start = 0, end = k;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (reader.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }

        return -1;
    }

    class ArrayReader {

        public int get(int index) {
            return 0;
        }
    }
}
