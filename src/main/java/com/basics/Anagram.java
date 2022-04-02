package com.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static  boolean isAnagram(String a, String b) {
        // Complete the function
        if (a == null || b == null) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }

        boolean ans = true;
        a = a.toUpperCase();
        b = b.toUpperCase();
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            String c1 = String.valueOf(a.charAt(i));
            String c2 = String.valueOf(b.charAt(i));
            if (mapA.get(c1) == null) {
                mapA.put(c1, 1);
            } else {
                int value1 = mapA.get(c1) + 1;
                mapA.put(c1, value1);
            }

            if (mapB.get(c2) == null) {
                mapB.put(c2, 1);
            } else {
                int value2 = mapB.get(c2) + 1;
                mapB.put(c2, value2);
            }
        }

        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            if (mapB.containsKey(entry.getKey()) == false) {
                ans = false;
            } else if (mapB.get(entry.getKey()) != entry.getValue()) {
                ans = false;
            }
        }

        return ans;
    }

    static boolean isAnagram2(String firstWord, String secondWord) {
        char[] word1 = firstWord
                .toLowerCase()
                .replaceAll("[\\s]", "")
                .toCharArray();
        char[] word2 = secondWord
                .toLowerCase()
                .replaceAll("[\\s]", "")
                .toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}
