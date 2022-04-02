package com.leetcode;

/**
Description
    Suppose a sorted array in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    You can assume no duplicate exists in the array.

    Example 1:
    Input：[4, 5, 6, 7, 0, 1, 2]
    Output：0
    Explanation：The minimum value in an array is 0.

    Example 2:
    Input：[2,1]
    Output：1
    Explanation：The minimum value in an array is 1.

 @author shubozhang
*/
public class T159FindMinimumInRotatedSortedArray {

    public static int find(int[] arr){
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[end]) {
                // slope_mid_end < 1, so min index is between mid and end
                start = mid;
            } else if (arr[mid] < arr[end]){
                // slope_mid_end < 1, so min index is between start and mid
                end = mid;
            }
        }
        return Math.min(arr[start], arr[end]);
    }
}
