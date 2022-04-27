package com.leetcode.doublepointers;


/**
 https://leetcode.com/problems/valid-palindrome-ii/
 Given a string s, return true if the s can be palindrome after deleting at most one
 character from it.

 Example 1:
 Input: s = "aba"
 Output: true

 Example 2:
 Input: s = "abca"
 Output: true
 Explanation: You could delete the character 'c'.

 Example 3:
 Input: s = "abc"
 Output: false

 Constraints:
 1) 1 <= s.length <= 105
 2) s consists of lowercase English letters.
 * */
public class E680ValidPalindromeII {

    public static boolean checkA(String str){
        if (null == str) {
            return false;
        }
        if (str.length() <= 1) {
            return true;
        }

        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                if (i + 1 == j) { return true;}

                if (isPartialValid(str, i + 1, j) || isPartialValid(str, i, j - 1)){
                    return true;
                }

                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPartialValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
