package com.leetcode.datastructure;

import java.util.*;


/**
 An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

 Given an integer n, return the nth ugly number.



 Example 1:

 Input: n = 10
 Output: 12
 Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 Example 2:

 Input: n = 1
 Output: 1
 Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.


 Constraints:

 1 <= n <= 1690
 * */
public class M264UglyNumberII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);
        int[] factors = {2, 3, 5};

        long curr = 1L;

        for (int i = 1; i <= n; i++) {
            curr = pq.poll();
            for (int factor : factors) {
                Long num = curr * factor;
                if (!set.contains(num)) {
                    set.add(num);
                    pq.add(num);
                }
            }
        }

        return (int)curr;
    }
}
