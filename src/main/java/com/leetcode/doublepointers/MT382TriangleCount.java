package com.leetcode.doublepointers;


import java.util.Arrays;

/**
 https://www.lintcode.com/problem/382/
 Description
 Given an array of integers, how many three numbers can be found in the array, so that we
 can build a triangle whose three edges length is the three numbers that we find?

 Example 1:
 Input: [3, 4, 6, 7]
 Output: 3
 Explanation:
 They are (3, 4, 6),
 (3, 6, 7),
 (4, 6, 7)

 Example 2:
 Input: [4, 4, 4, 4]
 Output: 4
 Explanation:
 Any three numbers can form a triangle.
 So the answer is C(3, 4) = 4


 题目理解
 我们先考虑“三条边能构成三角形”的充分必要条件。我们首先想到的是“三角形的任意两边之和大于第三边，
 三角形的任意两边之差小于第三边”。如果从这个角度理解，代码编写比较麻烦，因为“任意”二字就要求我们去检验各种组合。
 如果我们仔细分析一下这个条件，就不难证明它等效于“较短的两边之和大于最长边”。对于升序排列的三个数[a, b, c]，
 我们只需判断a + b > c是否成立，就知道它们是否能构成三角形。
 解题思路
 最直观的方法是暴力法，三重循环枚举，时间复杂度为 O(N^3).

 如果先将数组排好序，二重循环固定较短两边a和b，然后再利用二分查找找到最大的满足a + b > c的c，这样可以将时间复杂度优化至
 O(N^2 logN)

 这里我们采用双指针方法，可以继续降低时间复杂度。首先固定最大边的位置 i，然后在 [0, i-1]之间利用双指针找到满足条件的三边。
 时间复杂度为 O(N^2)

 算法流程
 首先对数组进行升序排列。
 从右向左遍历最大边，固定最大边的位置i
 建立双指针left和right，初始分别指向0和i-1
 如果S[left] + S[right] > S[i]，说明三者可以构成三角形。与此同时，最小边的索引为left+1, left+2,...,right-1时，
 都能与S[right]和S[i]构成三角形。所以满足条件的三角形找到了right-left个。然后right指针左移进入下一轮。
 如果S[left] + S[right] <= S[i]，说明不能构成三角形。left指针右移进入下一轮。
 复杂度分析
 时间复杂度为 O(N^2). 外层遍历最大边是n，内层循环移动双指针是n，所以总复杂度为 O(N^2)
 空间复杂度为O(1)，只需占用常量空间。

 * */
public class MT382TriangleCount {
    /**
     * @param nums: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;

        for (int i = 2; i < len; i++) {
            int left = 0;
            int right = i - 1;
            int target = nums[i];

            while (left < right && right < i) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    res += (right - left);
                    right--;
                } else if (sum <= target) {
                    left++;
                }
            }
        }
        return res;
    }
}
