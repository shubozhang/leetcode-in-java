package com.leetcode.datastructure;

import java.util.Stack;


/**
 https://leetcode.com/problems/largest-rectangle-in-histogram/

 Given an array of integers heights representing the histogram's bar height where the width of
 each bar is 1, return the area of the largest rectangle in the histogram.

 Example 1:
 Input: heights = [2,1,5,6,2,3]
 Output: 10
 Explanation: The above is a histogram where width of each bar is 1.
 The largest rectangle is shown in the red area, which has an area = 10 units.

 Example 2:
 Input: heights = [2,4]
 Output: 4

 Constraints:
 1) 1 <= heights.length <= 105
 2) 0 <= heights[i] <= 104
 * */
public class H084LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length)? -1 : heights[i];
            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty()? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
