package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 https://leetcode.com/problems/happy-number/
 Write an algorithm to determine if a number n is happy.

 A happy number is a number defined by the following process:

 Starting with any positive integer, replace the number by the sum of the squares of its digits.
 Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in
 a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy.
 Return true if n is a happy number, and false if not.

 Example 1:
 Input: n = 19
 Output: true
 Explanation:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 Example 2:
 Input: n = 2
 Output: false

 Constraints:
 1 <= n <= 231 - 1
 * */
public class E202HappyNumber {

    // fast / slow pointers
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (true){
            slow = calSum(slow);
            fast = calSum(calSum(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
            if (slow == fast) {
                return false;
            }
        }
    }

    // use set
    public boolean isHappyB(int n) {
        int sum = n;
        Set<Integer> set = new HashSet<>();
        while(true) {
            sum = calSum(sum);
            if (sum == 1) {
                return true;
            }

            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
        }
    }

    private int calSum(int num) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (num / 10 == 0) {
                list.add(num);
                break;
            } else {
                list.add(num % 10);
                num = num / 10;
            }
        }
        int sum = 0;
        for(Integer i : list) {
            sum += i * i;
        }

        return sum;
    }
}
