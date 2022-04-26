package com.leetcode.binarysearch;

import java.util.Arrays;


/**
 https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's
 (representing civilians). The soldiers are positioned in front of the civilians.
 That is, all the 1's will appear to the left of all the 0's in each row.

 A row i is weaker than a row j if one of the following is true:

 The number of soldiers in row i is less than the number of soldiers in row j.
 Both rows have the same number of soldiers and i < j.
 Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

 Example 1:
 Input: mat =
 [[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
 k = 3
 Output: [2,0,3]
 Explanation:
 The number of soldiers in each row is:
 - Row 0: 2
 - Row 1: 4
 - Row 2: 1
 - Row 3: 2
 - Row 4: 5
 The rows ordered from weakest to strongest are [2,0,3,1,4].

 Example 2:
 Input: mat =
 [[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
 k = 2
 Output: [0,2]
 Explanation:
 The number of soldiers in each row is:
 - Row 0: 1
 - Row 1: 4
 - Row 2: 1
 - Row 3: 1
 The rows ordered from weakest to strongest are [0,2,3,1].

 Constraints:
 1) m == mat.length
 2) n == mat[i].length
 3) 2 <= n, m <= 100
 4)1 <= k <= m
 5) matrix[i][j] is either 0 or 1.
 * */
public class E1337TheKWeakestRowsInAMatrix {

    public static int[] findA(int[][] mat, int k) {
        if (mat == null || mat.length == 0) {
            return null;
        }
        int row = mat.length;
        int[] nums = new int[row];

        for (int i = 0; i < row; i++) {
            nums[i] = countSolider(mat[i]) * row + i;
        }
        Arrays.sort(nums);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i] % row;
        }
        return res;
    }


    private static int countSolider(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] ==1) {
                count++;
            }
        }
        return count;
    }
}