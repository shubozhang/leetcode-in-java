package com.leetcode.dynamicprogramming.easy;

/**
 Description
 Given a m∗n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 the sum of all numbers along its path.

 The robot can only move either down or right at any point in time.

 Example 1:
 Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 Output: 7
 Explanation: Path is: 1 -> 3 -> 1 -> 1 -> 1

 Example 2:
 Input: grid = [[1,3,2]]
 Output: 6
 Explanation: Path is: 1 -> 3 -> 2

 *
 * */
public class L064MinimumPathSum {
    // res.size() = m + n -1;
    public static int search(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        // f[x][y] is the minimum value from point[x,y] to [0,0]
        int [][] f = new int[m][n];
        f[0][0] = grid[0][0];

        // initializting row_0 and column_0 since there is only one way to move from [0,0] to them
        // column_0
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i-1][0] + grid[i][0];
        }
        // row_0
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j-1] + grid[0][j];
        }

        // traverse the remaining grids
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i][j-1], f[i-1][j]) + grid[i][j];
            }
        }

        return f[m-1][n-1];
    }
}
