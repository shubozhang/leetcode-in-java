package com.leetcode.doublepointers;

/**
 https://leetcode.com/problems/reverse-string/
 Write a function that reverses a string. The input string is given as an array of characters s.

 You must do this by modifying the input array in-place with O(1) extra memory.

 Example 1:
 Input: s = ["h","e","l","l","o"]
 Output: ["o","l","l","e","h"]

 Example 2:
 Input: s = ["H","a","n","n","a","h"]
 Output: ["h","a","n","n","a","H"]

 Constraints:
 1) 1 <= s.length <= 105
 2) s[i] is a printable ascii character.

 */
public class E344ReverseString {

    public static char[] reverse(char[] s) {
        if (s == null || s.length == 0 || s.length == 1){
            return s;
        }

        int start = 0, end = s.length - 1;
        while (start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
        return s;
    }
}
