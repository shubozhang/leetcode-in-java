package com.leetcode.doublepointers;


/**
 https://leetcode.com/problems/sort-colors/

 Given an array nums with n objects color RED, WHITE, or BLUE, sort them in-place so
 that objects of the same color are adjacent, with the colors in the order RED, WHITE, and BLUE.

 We will use the integers 0, 1, and 2 to represent the color RED, WHITE, and BLUE, respectively.

 You must solve this problem without using the library's sort function.

 Example 1:
 Input: nums = [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]

 Example 2:
 Input: nums = [2,0,1]
 Output: [0,1,2]

 Constraints:
 1) n == nums.length
 2) 1 <= n <= 300
 3) nums[i] is either 0, 1, or 2.

 Follow up: Could you come up with a one-pass algorithm using only constant extra space?

 Anslysis:
 1) Rainbow Sort (in place swap)
    k different numbers
    O(kn) time + O(1) space
 2) Counting Sort
    O(n) time O(k) space
 * */
public class M075SortColors {
    public static int[] sortA(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        final int RED = 0, WHITE = 1, BLUE = 2;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] != RED && nums[right] == RED) {
                int temp = nums[left];
                nums[left] = RED;
                nums[right] = temp;
                left++;
                right--;
            } else if (nums[left] == RED) {
                left++;
            } else if (nums[right] != RED) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        right = nums.length - 1;
        while (left < right) {
            if (nums[left] == BLUE  && nums[right] == WHITE) {
                nums[left] = WHITE;
                nums[right] = BLUE;

            } else if (nums[left] == WHITE) {
                left++;
            } else if (nums[right] == BLUE) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return nums;
    }


    /**
     * Nine chapter solution
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public static int[] sortB(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //直到mid > right停止遍历
        while (mid <= right){
            if (nums[mid] == 0){
                swap(nums, mid, left);
                mid ++;
                left ++;
            }
            else if (nums[mid] == 2){
                swap(nums, mid, right);
                right --;
            }
            else{
                mid ++;
            }
        }
        return nums;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}