package com.lintcode.dynamicprogramming.easy;

/**
 Description
 You are climbing a staircase. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps.
 In how many distinct ways can you climb to the top?

 Example 1:
 Input: n = 3
 Output: 3
 Explanation:
 1, 1, 1
 1, 2
 2, 1
 total 3.

 Example 2:
 Input: n = 1
 Output: 1
 Explanation: only 1 way.
 * */
public class T111ClimbingStairs {
    // works like fibonacci

    // non-recursive
    public static int searchA(int n) {
        if (n == 0) { return 0;}
        if (n == 1) { return 1;}
        if (n == 2) { return 2;}

        int res1 = 1;
        int res2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = res1 + res2;
            res1 = res2;
            res2 = res;
        }

        return res;
    }


    // recursive
    public static int searchB(int n) {
        if (n == 0) { return 0;}
        if (n == 1) { return 1;}
        if (n == 2) { return 2;}

        return searchB(n - 1) + searchB(n -2);

    }
}
