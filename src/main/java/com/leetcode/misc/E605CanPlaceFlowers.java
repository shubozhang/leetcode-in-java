package com.leetcode.misc;


import java.util.*;

/**
 You have a long flowerbed in which some of the plots are planted, and some are not. However,
 flowers cannot be planted in adjacent plots.

 Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not
 empty, and an integer n, return if n new flowers can be planted in the flowerbed without
 violating the no-adjacent-flowers rule.



 Example 1:

 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: true
 Example 2:

 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: false


 Constraints:

 1 <= flowerbed.length <= 2 * 104
 flowerbed[i] is 0 or 1.
 There are no two adjacent flowers in flowerbed.
 0 <= n <= flowerbed.length
 * */
public class E605CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;
        if (len == 1) {
            if (flowerbed[0] == 0 && n == 1) {
                return true;
            }
            return false;
        }
        int numPlant = 0;
        for (int j = 0; j < len; j++) {
            if (j == 0) {
                if (flowerbed[j] == 0 && flowerbed[1] == 0) {
                    numPlant++;
                    flowerbed[0] = 1;
                }
                continue;
            }

            if (j == len - 1) {
                if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
                    numPlant++;
                    flowerbed[len - 1] = 1;
                }
                continue;
            }

            if (flowerbed[j] == 0 && flowerbed[j - 1] == 0 && flowerbed[j + 1] == 0 ) {
                flowerbed[j] = 1;
                numPlant++;
            }
        }
        if (numPlant >= n) {
            return true;
        }

        return false;
    }
}
