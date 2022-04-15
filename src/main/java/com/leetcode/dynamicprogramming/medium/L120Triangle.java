package com.leetcode.dynamicprogramming.medium;

/**
 * Description
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * <p>
 * Example 1:
 * Input: triangle = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
 * Output: 11
 * Explanation: The minimum path sum from top to bottom is 11 (2 + 3 + 5 + 1 = 11).
 * <p>
 * Example 2:
 * Input: triangle = [[2], [3, 2], [6, 5, 7], [4, 4, 8, 1]]
 * Output: 12
 * Explanation: The minimum path sum from top to bottom is 12 (2 + 2 + 7 + 1 = 12).
 */
public class L120Triangle {

    // version 0: top-down
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotalA(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize triangle's left and right sides: they only have one father node.
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }

        // top down: find f[x][y] value for all nodes
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }

        // answer
        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }


    //Version 1: Bottom-Up
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotalB(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        // state: f[x][y] = minimum path value from x,y to bottom
        int n = triangle.length;
        int[][] f = new int[n][n];

        // initialize the nodes in the bottom layer
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }

        // bottom up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
            }
        }

        // answer
        return f[0][0];
    }


    //Version 2 : Memorize Search
    private int n;
    private int[][] minSum;
    private int[][] triangle;

    private int search(int x, int y) {
        if (x >= n) {
            return 0;
        }

        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }

        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1))
                + triangle[x][y];
        return minSum[x][y];
    }

    public int minimumTotalC(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return search(0, 0);
    }

    // version 3: DFS
    public static void traverse(int x, int y, int sum){


    }


}
