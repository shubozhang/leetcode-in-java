package com.leetcode.array.sortedarray;

/**
 https://leetcode.com/problems/median-of-two-sorted-arrays/
 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of
 the two sorted arrays.

 The overall run time complexity should be O(log (m+n)).

 Example 1:
 Input: nums1 = [1,3], nums2 = [2]
 Output: 2.00000
 Explanation: merged array = [1,2,3] and median is 2.

 Example 2:
 Input: nums1 = [1,2], nums2 = [3,4]
 Output: 2.50000
 Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

 Constraints:
 1) nums1.length == m
 2) nums2.length == n
 3) 0 <= m <= 1000
 4) 0 <= n <= 1000
 5) 1 <= m + n <= 2000
 6) -106 <= nums1[i], nums2[i] <= 106
 * */
public class H004MedianOfTwoSortedArrays {

    public static double findMedian(int[] A, int[] B) {
        int len = A.length + B.length;

        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0,len / 2) + findKth(A, 0, B, 0,len / 2+ 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0,len / 2+ 1);
        }
    }

    private static int findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length) {
            return B[bStart + k - 1];
        }
        if (bStart >= B.length) {
            return A[aStart + k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aKey = aStart + k / 2 - 1 < A.length ? A[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int bKey = bStart + k / 2 - 1 < B.length ? B[bStart + k / 2 - 1] : Integer.MAX_VALUE;

        if (aKey < bKey) {
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
        } else {
            return findKth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
    }
}

