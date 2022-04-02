package com.leetcode.string.easy;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author shubozhang
 */
public class L028StrStr {


    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr01(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        if (needle.equals(haystack) || "".equals(needle)) {
            return 0;
        }

        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen > hLen) {
            return -1;
        }

        for (int i = 0; i < hLen; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && (i + nLen <= hLen)) {
                if (haystack.substring(i, (i + nLen)). equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
