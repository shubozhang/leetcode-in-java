package com.leetcode.misc;

public class M1201UglyNumberIII {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (atLeastK(mid, a, b, c, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }


        return left;
    }

    public boolean atLeastK(long num, long a, long b, long c, int k) {
        return (int) (num / a + num / b + num / c
                - num / lcm(a, b)
                - num / lcm(b, c)
                - num / lcm(a, c)
                + num / (lcm(a, lcm(b, c)))) >= k;
    }

    public long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
