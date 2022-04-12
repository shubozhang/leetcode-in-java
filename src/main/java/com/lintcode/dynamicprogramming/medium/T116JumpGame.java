package com.lintcode.dynamicprogramming.medium;

/**
 * Description
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * The array A contains 𝑛 integers 𝑎1, 𝑎2, …, 𝑎𝑛 (1≤𝑎𝑖≤5000) (1≤n≤5000 )
 * <p>
 * Example 1:
 * Input: A = [2,3,1,1,4]
 * Output: true
 * Explanation: 0 -> 1 -> 4 (the number here is subscript) is a reasonable scheme.
 * <p>
 * Example 2:
 * Input: A = [3,2,1,0,4]
 * Output: false
 * Explanation: There is no solution that can reach the end.
 * <p>
 * Challenge
 * 1) This problem have two method which is Greedy and Dynamic Programming.
 * 2) The time complexity of Greedy method is O(n).
 * 3) The time complexity of Dynamic Programming method is O(n^2).
 * <p>
 * We manually set the small data set to allow you pass the test in both ways.
 * This is just to let you learn how to use this problem in dynamic programming ways.
 * If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 */
public class T116JumpGame {

//    state: f[i]代表我能否跳到第i个位置
//    function: f[i] = OR(f[j], j < i && j能够跳到i)
//    initialize: f[0] = true;
//    answer: f[n-1]

    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public static boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;

        int maxJump = A[0];
        for (int i = 1; i < n; i++) {
            f[i] = (i <= maxJump);
            if (f[i]) {
                maxJump = Math.max((i + A[i]), maxJump);
            } else {
                return false;
            }
        }
        return f[n - 1];
    }
}