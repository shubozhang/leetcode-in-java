package com.leetcode.doublepointers;


/**
 https://leetcode.com/problems/valid-word-abbreviation/
 A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings
 with their lengths. The lengths should not have leading zeros.

 For example, a string such as "substitution" could be abbreviated as (but not limited to):

 "s10n" ("s ubstitutio n")
 "sub4u4" ("sub stit u tion")
 "12" ("substitution")
 "su3i1u2on" ("su bst i t u ti on")
 "substitution" (no substrings replaced)
 The following are not valid abbreviations:

 "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 "s010n" (has leading zeros)
 "s0ubstitution" (replaces an empty substring)
 Given a string word and an abbreviation abbr, return whether the string matches the given
 abbreviation.

 A substring is a contiguous non-empty sequence of characters within a string.

 Example 1:
 Input: word = "internationalization", abbr = "i12iz4n"
 Output: true
 Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").

 Example 2:
 Input: word = "apple", abbr = "a2e"
 Output: false
 Explanation: The word "apple" cannot be abbreviated as "a2e".


 Constraints:
 1 <= word.length <= 20
 word consists of only lowercase English letters.
 1 <= abbr.length <= 10
 abbr consists of lowercase English letters and digits.
 All the integers in abbr will fit in a 32-bit integer.
 * */
public class E408ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();
        int pointerWord = 0;
        int pointerAbbr = 0;

        while (pointerWord < n && pointerAbbr < m) {
            StringBuilder number = new StringBuilder();
            while (!(abbr.charAt(pointerAbbr) >= 'a' && abbr.charAt(pointerAbbr) <= 'z')) {
                char abbrChar = abbr.charAt(pointerAbbr);
                number.append(abbrChar);
                pointerAbbr += 1;
                if (pointerAbbr >= m) {
                    break;
                }
            }

            if (number.length() > 0) {
                // leading 0
                if (number.charAt(0) == '0') {
                    return false;
                }
                // number in abbr is bigger than the length of the rest of the word
                int num = Integer.valueOf(number.toString());
                if (n - (pointerWord + num) < 0) {
                    return false;
                }
                pointerWord += num;
            } else {
                char wordChar = word.charAt(pointerWord);
                char abbrChar = abbr.charAt(pointerAbbr);
                if (wordChar != abbrChar) {
                    return false;
                }
                pointerAbbr += 1;
                pointerWord += 1;
            }
        }
        return pointerAbbr == m && pointerWord == n;
    }
}