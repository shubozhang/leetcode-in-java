package com.leetcode.divideandconquer;

/**
 * Created by shubo.zhang on 9/21/2016.
 */
public class T006MergerTwoSortedArrays {

    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int lenA = A.length;
        int lenB = B.length;

        int[] res = new int[lenA + lenB];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < lenA && j < lenB) {
            if (A[i] <= B[j]) {
                res[index] = A[i];
                index++;
                i++;
            } else {
                res[index] = B[j];
                index++;
                j++;
            }
        }

        while (i < lenA) {
            res[index] = A[i];
            index++;
            i++;
        }

        while (j < lenB) {
            res[index] = B[j];
            index++;
            j++;
        }

        return res;
    }
}
