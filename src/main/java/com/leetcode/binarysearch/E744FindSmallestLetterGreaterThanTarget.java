package com.leetcode.binarysearch;


/**
 * Bad Question.
 *
 * Given a characters array letters that is sorted in non-decreasing order and a character target,
 * return the smallest character in the array that is larger than target.
 *
 * Note that the letters wrap around.
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 *
 * Example 1:
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 *
 * Example 2:
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 *
 * Example 3:
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 *
 * Constraints:
 * 2 <= letters.length <= 104
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 *
 * @author shubozhang
 */
public class E744FindSmallestLetterGreaterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;
        String t = String.valueOf(target);

        if (String.valueOf(letters[start]).compareTo(t) > 0) {
            return letters[start];
        }
        if (String.valueOf(letters[end]).compareTo(t) <= 0) {
            return letters[start];
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (String.valueOf(letters[mid]).compareTo(t) <= 0) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return String.valueOf(letters[start]).compareTo(t) > 0 ? letters[start] : letters[end];
    }
}
