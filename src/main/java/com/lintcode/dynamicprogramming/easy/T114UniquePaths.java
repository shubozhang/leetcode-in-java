package com.lintcode.dynamicprogramming.easy;


/**
 Description
 A robot is located in the top-left corner of a m x n grid.

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 corner of the grid.

 How many possible unique paths are there?

 1) m and n will be at most 100.
 2) The answer is guaranteed to be in the range of 32-bit integers

 Example 1:
 Input: n = 1 m = 3
 Output: 1
 Explanation: Only one path to target position.

 Example 2:
 Input: n = 3 m = 3
 Output: 6
 Explanation: D : Down R : Right
 DDRR
 DRDR
 DRRD
 RRDD
 RDRD
 RDDR

 * */
public class T114UniquePaths {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public static int search(int m, int n) {
        // write your code here
        if (m < 1 || m > 100 || n < 1 || n > 100) {
            return -1;
        }

        // f[x][y] if the number of paths from [0, 0] to [x, y]
        int [][] f = new int[m][n];
        f[0][0] = 1;

        // initializing column_0
        for (int i = 1; i < m; i++){
            f[i][0] = 1;
        }
        // initializing row_0
        for (int j = 1; j < n; j++){
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j-1] + f[i-1][j];
            }
        }

        return f[m-1][n-1];
    }
}
