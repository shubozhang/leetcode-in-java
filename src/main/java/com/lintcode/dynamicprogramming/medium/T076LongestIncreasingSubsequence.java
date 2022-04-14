package com.lintcode.dynamicprogramming.medium;

/**
 Description
 Given a sequence of integers, find the longest increasing subsequence (LIS).

 Your code should return the length of the LIS.

 What's the definition of the longest increasing subsequence?
 The longest increasing subsequence problem is to find a subsequence of a given sequence in which
 the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence
 is as long as possible. This subsequence is not necessarily contiguous, or unique.


 Example 1:
 Input: nums = [5,4,1,2,3]
 Output: 3
 Explanation: LIS is [1,2,3]

 Example 2:
 Input: nums = [4,2,4,5,3,7]
 Output: 4
 Explanation: LIS is [2,4,5,7]

 Challenge
 Time complexity O(n^2) or O(nlogn)
 * */
public class T076LongestIncreasingSubsequence {

    // state: f[i] is the length of the LIS at index_i
    // func: f[i] = A[i] >= A[j] && max{f[i], f[j] + 1}
    // start point: any point
    // end point: any point
    public static int search(int[] A) {
        int[] f= new int[A.length];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            // LIS start point might be any index, so f[start] init value is 1
            f[i] =1;
            for (int j = 0; j < i; j++) {
                if(A[j] <= A[i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            // LIS end point might be any index too
            max = Math.max(f[i], max);
        }
        return max;
    }
}
