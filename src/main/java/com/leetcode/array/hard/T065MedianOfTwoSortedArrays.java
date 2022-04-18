package com.leetcode.array.hard;

/**
 There are two sorted arrays A and B of size m and n respectively. Find the median of the two
 sorted arrays.
 Example
 Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 Given A=[1,2,3] and B=[4,5], the median is 3.
 */
public class T065MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        int[] B = {2,3,4,5};

        System.out.println(findMedian(A, B));
    }

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
