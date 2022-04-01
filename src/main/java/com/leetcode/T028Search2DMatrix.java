package com.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example
 * Consider the following matrix:
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * @author shubozhang
 */
public class T028Search2DMatrix {


    public static boolean searchMatrix(int[][] source, int target){
        if (source == null || source.length == 0) {
            return false;
        }

        int start = 0;
        int end = source.length * source[0].length -1;
        int col = source[0].length;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midValue = source[mid/col][mid%col];

            if (midValue < target) {
                start = mid;
            } else if (midValue == target) {
                return true;
            } else {
                end = mid;
            }
        }

        if (source[start/col][start%col] ==target || source[end/col][end%col] ==target) {
            return true;
        }
        return false;
    }
}