package com.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



 Example 1:

 Input: s = "leetcode"
 Output: 0
 Example 2:

 Input: s = "loveleetcode"
 Output: 2
 Example 3:

 Input: s = "aabb"
 Output: -1


 Constraints:

 1 <= s.length <= 105
 s consists of only lowercase English letters.
 * */
public class E387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.remove(ch);
                set.add(ch);
            } else if (!set.contains(ch)) {
                map.put(ch, i);
            }
        }

        if (map.isEmpty()) {
            return -1;
        }
        int min = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            min = Math.min(map.get(entry.getKey()),  min);
        }

        return min;
    }
}
