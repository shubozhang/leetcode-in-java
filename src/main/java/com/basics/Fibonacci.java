package com.basics;

/**
 * @author szhang
 */
public class Fibonacci {

    public static void main(String[] args) {

        int n = 45;

        System.out.println(calculate(n));

        System.out.println(calculateByRecursive(n));
    }

    public static int calculate(int n) {
        if (n <= 1) { return 0;}
        if (n == 2) { return 1;}

        int[] temp = {0,1};
        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = temp[0] + temp[1];
            temp[0] = temp[1];
            temp[1] = res;
        }
        return res;
    }

    public static int calculateByRecursive(int n) {
        if (n <= 1) { return 0;}
        if (n == 2) { return 1;}

        return calculateByRecursive(n - 1) + calculateByRecursive(n - 2);
    }
}
