package com.leetcode.binarysearch;


/**
 https://leetcode.com/problems/longest-common-prefix/
 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:
 Input: strs = ["flower","flow","flight"]
 Output: "fl"

 Example 2:
 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.


 Constraints:
 1 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] consists of only lower-case English letters.


 * */
public class E014LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();
        if (len == 0) { return "";}
        int left = 0, right = len -1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            boolean match = isMatch(strs, mid);
            if (match) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (isMatch(strs, right)) {
            return strs[0].substring(0, right + 1);
        }

        if (isMatch(strs, left)) {
            return strs[0].substring(0, left + 1);
        }

        return "";

    }

    private boolean isMatch(String[] strs, int index) {
        String target = strs[0].substring(0, index + 1);
        for (String str: strs) {
            if (str.length() < index + 1) {
                return false;
            }
            if (!target.equals(str.substring(0, index + 1))) {
                return false;
            }
        }

        return true;
    }
}
