package com.leetcode;

/**
 Write an efficient algorithm that searches for a value target in an m x n integer matrix.
 This matrix has the following properties:
 1. Integers in each row are sorted in ascending from left to right.
 2. Integers in each column are sorted in ascending from top to bottom.

 Example 1:
 Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 target = 5
 Output: true

 Example 2:
 Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 target = 20
 Output: false


 Constraints:
 m == matrix.length
 n == matrix[i].length
 1 <= n, m <= 300
 -109 <= matrix[i][j] <= 109
 All the integers in each row are sorted in ascending order.
 All the integers in each column are sorted in ascending order.
 -109 <= target <= 109

 @author shubozhang
 */
public class L240Search2DMarixII {

    public static boolean search(int[][] source, int target){
        if (source == null || source.length == 0) {
            return false;
        }

        int m = source.length;
        int n = source[0].length;

        // start from left bottom position(m - 1, 0)
        int i = m - 1;
        int j = 0;

        while(i >= 0 && j <= n - 1) {
            if (source[i][j] == target) {
                return true;
            } else if (source[i][j] > target) {
                // move up one step
                i--;
            } else if (source[i][j] < target)  {
                // move right one step
                j++;
            }
        }

        return false;
    }
}
