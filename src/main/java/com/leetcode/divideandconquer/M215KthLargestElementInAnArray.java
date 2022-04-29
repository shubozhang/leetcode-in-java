package com.leetcode.divideandconquer;
/**
 https://leetcode.com/problems/kth-largest-element-in-an-array/
 Given an integer array nums and an integer k, return the kth largest element in the array.

 Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:
 Input: nums = [3,2,1,5,6,4], k = 2
 Output: 5

 Example 2:
 Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 Output: 4

 Constraints:
 1) 1 <= k <= nums.length <= 104
 2) -104 <= nums[i] <= 104
 * */
public class M215KthLargestElementInAnArray {

    public static int find(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        return quickSort(nums, 0, nums.length - 1, k);
    }

    private static int quickSort(int[] nums, int start, int end, int k) {
        if (start == end) { return nums[start];}

        int i = start, j = end;
        int pivot = nums[(j + i) / 2];

        // sorting in descending order
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // kth largest number in left block
        if (start + k - 1 <= j) {
            return quickSort(nums, start, j, k);
        }

        // kth largest number in right block
        if (start + k - 1 >= i) {
            return quickSort(nums, i, end, k - (i - start));
        }

        return nums[j + 1];
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}