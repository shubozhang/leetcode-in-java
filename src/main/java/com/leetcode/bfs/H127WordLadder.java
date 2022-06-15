package com.leetcode.bfs;


import java.util.*;

/**
 https://leetcode.com/problems/word-ladder/

 A transformation sequence from word beginWord to word endWord using a dictionary wordList is
 a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

 Every adjacent pair of words differs by a single letter.
 Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 sk == endWord
 Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in
 the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 Example 1:
 Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 Output: 5
 Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog",
 which is 5 words long.


 Example 2:
 Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 Output: 0
 Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


 Constraints:
 1) 1 <= beginWord.length <= 10
 2) endWord.length == beginWord.length
 3) 1 <= wordList.length <= 5000
 4) wordList[i].length == beginWord.length
 5) beginWord, endWord, and wordList[i] consist of lowercase English letters.
 6) beginWord != endWord
 7) All the words in wordList are unique.
 * */
public class H127WordLadder {
    public static int ladderLength(String start, String end, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        // convert wordList from list to set, so it has faster operation on contains(key)
        Set<String> dict = new HashSet<>(wordList);

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);

        // record visited word and its distance to root
        Map<String, Integer> distance = new HashMap<>();
        distance.put(start, 1);

        while(!queue.isEmpty()) {
            String word = queue.poll();

            if (word.equals(end)) {
                return distance.get(word);
            }

            for(String nextWord: getNextWords(word, dict)) {
                if (distance.containsKey(nextWord)) {
                    continue;
                }
                queue.offer(nextWord);
                distance.put(nextWord, distance.get(word) + 1);
            }
        }

        return 0;
    }

    // if dict is List, dict.contains(key) will be slow and trigger "Time Limit Exceeded"
    private static List<String> getNextWords(String word, Set<String> dict) {
        List<String> words = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if (word.charAt(i) == ch) {
                    continue;
                }
                String nextWord = replace(word, i, ch);
                if (dict.contains(nextWord)) {
                    words.add(nextWord);
                }
            }
        }
        return words;
    }

    private static String replace(String str, int index, char ch) {
        char[] chars = str.toCharArray();
        chars[index] = ch;
        return new String(chars);
    }

}




