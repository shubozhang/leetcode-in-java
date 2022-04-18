package com.leetcode.array;

/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 *
 * For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 *
 * Challenge
 * In-place, O(1) extra space and O(n) time.
 *
 * Tips: reverse-in-3-steps ( reverse is in-place operation)
 * 1) 4, 5   and 1,2,3
 * 2) 5,4    and 3,2,1
 * 3) 5 4 3 2 1 -> 1 2 3 4 5
 *
 * Similar questions: reverse string
 */
public class T039RecoverRotatedSortedArray {
}
