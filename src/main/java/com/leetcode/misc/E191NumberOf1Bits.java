package com.leetcode.misc;

public class E191NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);

        int counter = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                counter++;
            }
        }

        return counter;
    }


    public int hammingWeightB(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public int hammingWeightC(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
