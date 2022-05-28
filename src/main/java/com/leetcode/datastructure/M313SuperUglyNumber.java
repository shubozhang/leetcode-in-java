package com.leetcode.datastructure;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class M313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);
        long curr = 1L;
        for (int i = 1; i <= n; i++) {
            curr = pq.poll();
            for (int prime : primes) {
                Long num = curr * prime;
                if (set.add(num)) {
                    pq.add(num);
                }
            }

        }

        return (int)curr;
    }
}

