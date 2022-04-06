package com.leetcode.string.easy;


/**
 * @author shubozhang
 */
public class L028StrStr {
    /**
     * @param sourceStr
     * @param subStr
     * @return the index of the first occurrence of subStr in sourceStr, or -1 if subStr is not part of sourceStr.
     */
    public static int strStr(String sourceStr, String subStr) {
        if (null == sourceStr || null == subStr) {
            return -1;
        }
        if (subStr.equals(sourceStr) || "".equals(subStr)) {
            return 0;
        }

        int sourceLen = sourceStr.length();
        int subLen = subStr.length();

        if (subLen > sourceLen) {
            return -1;
        }

        for (int i = 0; i < sourceLen; i++) {
            if (sourceStr.charAt(i) == subStr.charAt(0) && (i + subLen <= sourceLen)) {
                if (sourceStr.substring(i, (i + subLen)).equals(subStr)) {
                    return i;
                }
            }
        }
        return -1;
    }
}