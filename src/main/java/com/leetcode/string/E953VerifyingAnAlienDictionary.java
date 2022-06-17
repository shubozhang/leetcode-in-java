package com.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and
 * only if the given words are sorted lexicographically in this alien language.
 * <p>
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * <p>
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * <p>
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * <p>
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
public class E953VerifyingAnAlienDictionary {

    public boolean isAlienSortedC(String[] words, String order) {
        final int lenWord = 20;
        // create an order lookup
        int[] values = new int[26];
        for (int i = 0; i < order.length(); i++) {
            values[order.charAt(i) - 'a'] = i;
        }
        boolean hasEqual = false;
        // compare index by index, not word by word
        // ex: return true if words[0][i] < words[1][i] .. < words[n][i]
        for (int i = 0; i < lenWord; i++) {
            // compare index i for all words
            for (int j = 0; j < words.length - 1; j++) {
                int value1 = i < words[j].length() ? values[words[j].charAt(i) - 'a'] : -1;
                int value2 = i < words[j + 1].length() ? values[words[j + 1].charAt(i) - 'a'] : -1;
                if (value1 > value2) { return false; }
                if (value1 == value2) { hasEqual = true;}
            }
            // when there is one equal in index i comparison at least, it has to compare index i + 1
            if (hasEqual) {
                hasEqual = false;
                continue;
            }
            return true;
        }
        return true;
    }

    // less time and space complexity
    // compare index by index
    // true: words[0][i] < words[1][i] < words[2][i]... < words[n][i]
    public boolean isAlienSortedA(String[] words, String order) {
        final int lenWord = 20;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        boolean hasEqual = false;
        for (int i = 0; i < lenWord; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                int index1 = i < words[j].length() ? map.get(words[j].charAt(i)) : -1;
                int index2 = i < words[j + 1].length() ? map.get(words[j + 1].charAt(i)) : -1;
                if (index1 > index2) { return false; }

                if (index1 == index2) { hasEqual = true;}
            }

            if (hasEqual) {
                hasEqual = false;
                continue;
            }

            return true;
        }

        return true;

    }

    // compare word by word
    public boolean isAlienSortedB(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!compareWords(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean compareWords(String w1, String w2, Map<Character, Integer> map) {
        int len = Math.min(w1.length(), w2.length());
        for (int i = 0; i < len; i++) {
            int index1 = map.get(w1.charAt(i));
            int index2 = map.get(w2.charAt(i));
            if (index1 < index2) { return true;}
            if (index1 == index2) { continue;}

            return false;
        }

        return w1.length() <= w2.length();
    }
}
