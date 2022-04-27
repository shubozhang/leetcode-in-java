package com.leetcode.binarysearch;

/**
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 *
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class T061SearchForARange {

    public static void main(String[] args) {
        int[] source = {5, 7, 7, 8, 8, 10};

        int[] range = searchForRange(source, 8);
        System.out.println(range[0] + " : " + range[1] );
    }


    private static int[] searchForRange(int[] source, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (source.length == 0) {
            return result;
        }

        // search for left bound
        int start = 0;
        int end = source.length - 1;
        int mid;

        // search for left bound
        while (start + 1 < end) {
            // if start and end are approaching Integer.MAX_VALUE (2^31 about 2 billion), (start+end)/ 2 will overflow.
            mid = start + (end - start) / 2;
            if (source[mid] == target) {
                end = mid;
            } else if (source[mid] < target) {
                start = mid;
            } else if (source[mid] > target) {
                end = mid;
            }
        }

        if (source[start] == target) {
            result[0] = start;
        } else if (source[end] == target) {
            result[0] = end;
        } else {
            return result;
        }

        // search for right bound
        start = 0;
        end = source.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (source[mid] == target) {
                start = mid;
            } else if (source[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (source[end] == target) {
            result[1] = end;
        } else if (source[start] == target) {
            result[1] = start;
        }  else {
            result[0] = result[1] = -1;
            return result;
        }

        return result;
    }
}
