package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 https://leetcode.com/problems/number-of-islands/
 Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 return the number of islands.

 An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:
 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1

 Example 2:
 Input: grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 Output: 3

 Constraints:
 1) m == grid.length
 2) n == grid[i].length
 3) 1 <= m, n <= 300
 4) grid[i][j] is '0' or '1'.


 坐标变换数组
 int[] deltaX = {1,0,0,-1};
 int[] deltaY = {0,1,-1,0}; DIRECTIONS = [(1, 0), (0, -1), (-1, 0), (0, 1)] 问:写出八个方向的坐标变换数组?

 * */
public class M200NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int islands = 0;

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == LAND && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void bfs (char[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int newX = coor.x + deltaX[direction];
                int newY = coor.y + deltaY[direction];
                if (isValid(grid, newX, newY, visited)) {
                    queue.offer(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private static boolean isValid(char[][] grid, int x, int y, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        return grid[x][y] == LAND;
    }

    private static final char LAND = '1';
    private static final int[] deltaX = {0, 1, -1, 0};
    private static final int[] deltaY = {1, 0, 0, -1};
    static class Coordinate{
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
