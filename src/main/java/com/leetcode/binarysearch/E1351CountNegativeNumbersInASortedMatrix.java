package com.leetcode.binarysearch;

/**
 https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

 Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 return the number of negative numbers in grid.

 Example 1:
 Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 Output: 8
 Explanation: There are 8 negatives number in the matrix.

 Example 2:
 Input: grid = [[3,2],[1,0]]
 Output: 0

 Constraints:
 1) m == grid.length
 2) n == grid[i].length
 3) 1 <= m, n <= 100
 4) -100 <= grid[i][j] <= 100

 Follow up: Could you find an O(n + m) solution?

 *
 * */
public class E1351CountNegativeNumbersInASortedMatrix {

    public static int countA(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int[] ints : grid) {
            int index = binarySearch(ints);
            if (index != -1) {
                count += (col - index);
                System.out.println(col - index);
            }
        }
        return count;
    }

    private static int binarySearch(int[] nums) {
        int start = 0, end = nums.length - 1;
        if (nums[start] < 0) { return start;}
        if (nums[end] >= 0) { return -1;}

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= 0) {
                start = mid;
            } else {
                end = mid;
            }
        }


        if (nums[start] < 0) {
            return start;
        }
        if (nums[end] < 0) {
            return end;
        }

        return -1;
    }

    public static int countB(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int count = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid [i][j] < 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
