package com.leetcode.doublepointers;

/**
 https://leetcode.com/problems/valid-palindrome/
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 and removing all non-alphanumeric characters, it reads the same forward and backward.
 Alphanumeric characters include letters and numbers.

 Given a string s, return true if it is a palindrome, or false otherwise.

 Example 1:
 Input: s = "A man, a plan, a canal: Panama"
 Output: true
 Explanation: "amanaplanacanalpanama" is a palindrome.

 Example 2:
 Input: s = "race a car"
 Output: false
 Explanation: "raceacar" is not a palindrome.

 Example 3:
 Input: s = " "
 Output: true
 Explanation: s is an empty string "" after removing non-alphanumeric characters.
 Since an empty string reads the same forward and backward, it is a palindrome.

 Constraints:
 1) 1 <= s.length <= 2 * 105
 2) s consists only of printable ASCII characters.
 */
public class E125ValidatePalindrome {

    // in-place check without extra space
    public static boolean checkB(String str) {
        if (null == str) {
            return false;
        }
        if (str.length() <= 1) {
            return true;
        }

        int start = 0, end = str.length() - 1;
        while (start < end) {
            while (start < end && isLetter(str.charAt(end))) {
                end--;
            }
            while (start < end && isLetter(str.charAt(start))) {
                start++;
            }
            if (start < end && str.toLowerCase().charAt(start) != str.toLowerCase().charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private static boolean isLetter(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')) {
            return false;
        }
        return true;
    }

    // this solution uses extra space
    public static boolean checkA(String input) {
        if (null == input) {
            return false;
        }
        if (input.length() <= 1) {
            return true;
        }

        String s = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int i = 0;
        int j = s.length() -1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) { return false;}
            i++;
            j--;
        }

        return true;
    }
}
