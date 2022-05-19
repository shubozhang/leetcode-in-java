package com.leetcode.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 https://leetcode.com/problems/valid-anagram/
 Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 typically using all the original letters exactly once.



 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false


 Constraints:

 1 <= s.length, t.length <= 5 * 104
 s and t consist of lowercase English letters.


 Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to
 such a case?
 * */
public class E242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagramB(String s, String t) {
        if (s.length() != t.length()) { return false;}

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

        }

        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                int value = map.get(ch) - 1;
                if (value == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, value);
                }
                continue;
            }

            return false;
        }

        return map.size() == 0;
    }
}
