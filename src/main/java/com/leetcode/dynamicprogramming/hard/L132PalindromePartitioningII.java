package com.leetcode.dynamicprogramming.hard;

/**
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.



 Example 1:

 Input: s = "aab"
 Output: 1
 Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 Example 2:

 Input: s = "a"
 Output: 0
 Example 3:

 Input: s = "ab"
 Output: 1


 Constraints:

 1 <= s.length <= 2000
 s consists of lowercase English letters only.
 * */
public class L132PalindromePartitioningII {

    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // preparation
        boolean[][] isPalindrome = getPalindrome(s);
        
        // initialization
        int[] f = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            f[i] = i - 1;
        }

        // main
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        
        return f[s.length()];
    }
    
    private static boolean[][] getPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                        = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }
}
