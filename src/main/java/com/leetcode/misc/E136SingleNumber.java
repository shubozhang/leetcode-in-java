package com.leetcode.misc;

import java.util.HashSet;
import java.util.Set;


/**
 Given a non-empty array of integers nums, every element appears twice except for one.
 Find that single one.

 You must implement a solution with a linear runtime complexity and use only constant extra space.



 Example 1:

 Input: nums = [2,2,1]
 Output: 1
 Example 2:

 Input: nums = [4,1,2,1,2]
 Output: 4
 Example 3:

 Input: nums = [1]
 Output: 1


 Constraints:

 1 <= nums.length <= 3 * 104
 -3 * 104 <= nums[i] <= 3 * 104
 Each element in the array appears twice except for one element which appears only once.


 Approach 4: Bit Manipulation
 Concept

 If we take XOR of zero and some bit, it will return that bit
 a \oplus 0 = aa⊕0=a
 If we take XOR of two same bits, it will return 0
 a \oplus a = 0a⊕a=0
 a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
 So we can XOR all bits together to find the unique number.
 * */
public class E136SingleNumber {

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }


    public int singleNumberB(int[] nums) {
        if (nums.length == 1) { return nums[0];}
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        Integer res = null;
        for(int i : set){
            res = i;
        }
        return res;
    }
}
