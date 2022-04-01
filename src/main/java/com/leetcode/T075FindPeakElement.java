package com.leetcode;

/**
 Description
 There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peak if: A[P] > A[P-1] && A[P] > A[P+1]

Find a peak element in this array. Return the index of the peak.

It's guaranteed the array has at least one peak.
The array may contain multiple peeks, find any of them.
The array has at least 3 numbers in it.

Example 1:
Input: A = [1, 2, 1, 3, 4, 5, 7, 6]
Output (index): 1
Explanation: Returns the index of any peak element. 6 is also correct.

Example 2:
Input: A = [1,2,3,4,1]
Output (index): 3
Explanation: return the index of peek.

Challenge
Time complexity O(logN)O(logN): binary search

 @author shubozhang
*/
public class T075FindPeakElement {

    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        int start = 0;
        int end = A.length - 1;

        // each time check three points (mid-1), mid, (mid+1)
        // if slope > 1, that means the peak is on the right.
        // if slope < 1, that means the peak is on the left.
        while (start + 2 <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                end = mid;
            }
        }
        return -1;
    }
}
