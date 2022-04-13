package com.lintcode.dynamicprogramming.medium;

/**
 Description
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 The array A contains 𝑛 integers 𝑎1, 𝑎2, …, 𝑎𝑛 (1 <= a_i <= 20000)(1≤n≤20000)

 Example 1:
 Input: A = [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
 (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * */
public class T117JumpGameII {

    private static final int MAX_N = 30_000;

    public static int calculateStepsA(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return 0;
        }

        int n = A.length;
        // f[x] is the number of steps from index_x to index_end
        int[] f = new int[n];

        // initialization index_end
        f[n - 1] = 0;

        for (int i = n - 2; i >=0 ; i--) {
            if (A[i] == 0) {
                f[i] = MAX_N;
            } else {
                f[i] = A[i] >= (n - 1 -i)? 1: 1 + findMin(f, A, i);
            }
        }

        return f[0];
    }

    private static int findMin(int[] f, int[] A, int i) {
        int res = MAX_N;
        for (int j = i + 1; j <= i + A[i]; j++) {
            res = Math.min(res, f[j]);
        }
        return res;
    }


//    public static int calculateStepsB(int[] A) {
//        if (A == null || A.length == 0) { return -1;}
//        if (A.length == 1) { return 0;}
//
//        int n = A.length;
//        // f[x] is the number of steps from index_0 to index_x
//        int[] f = new int[n];
//
//        f[0] = 1;
//
//        for (int i = 0; i < n; i++) {
//
//        }
//    }
}
