package com.leetcode.binarysearch;

import java.util.Arrays;

public class WoodCut {

    /**
     * @param l: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public static int cut(int[] l, int k) {
        if (l == null || l.length == 0) {
            return 0;
        }

        if (countPiece(l, 1) < k) {
            return 0;
        }

        // end might be over Integer.MAX_VALUE.
        int start = 1, end = Arrays.stream(l).max().getAsInt();

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countPiece(l, mid) >= k) {
                start = mid;
            }
            if (countPiece(l, mid) < k) {
                end = mid;
            }
        }

        if (countPiece(l, end) >= k) {
            return end;
        }

        if (countPiece(l, start) >= k) {
            return start;
        }
        return 0;
    }

    private static int countPiece(int[] l, int unit) {
        // count might be over Integer.MAX_VALUE
        long count = 0L;
        for (int i : l) {
            count += i / unit;
        }

        return count > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) count;
    }

}



