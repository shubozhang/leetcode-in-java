package com.lintcode.divideandconquer;

/**
 *
 * @author Shubo
 * @date 9/20/2016
 */
public class T080Median {

    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here

        int len = nums.length;

        sort (nums, 0, len -1);

        int median = len % 2 ==0 ? len / 2 -1 : len / 2;

        return nums[median];
    }

    private void sort(int[] nums, int lo, int hi) {

        int pivot = nums[lo + (hi - lo) / 2];

        int i = lo;
        int j = hi;

        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }

            while (nums[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        if (lo < j) {
            sort(nums, lo, j);
        }

        if (i < hi) {
            sort(nums, i, hi);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
