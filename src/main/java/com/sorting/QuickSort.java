package com.sorting;

/**
 https://leetcode.com/problems/sort-an-array/

 Given an array of integers nums, sort the array in ascending order.

 Example 1:
 Input: nums = [5,2,3,1]
 Output: [1,2,3,5]

 Example 2:
 Input: nums = [5,1,1,2,0,0]
 Output: [0,0,1,1,2,5]

 Constraints:
 1) 1 <= nums.length <= 5 * 104
 2) -5 * 104 <= nums[i] <= 5 * 104
 */
public class QuickSort {

    // version A
    public static void sortInts(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        sortA(A, 0, A.length - 1);
    }

    private static void sortA(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        // get value, not index
        int pivot = A[left + (right - left) / 2];

        // must be "<="
        while (left <= right) {
            // pick a number from left side which is greater or equal to pivot for swap
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // pick a number from right side which is less or equal to pivot for swap
            while (left <= right && A[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }

        sortA(A, start, right);
        sortA(A, left, end);
    }

    // version B
    public static void sortB(int[] array, int left, int right) {
        if(left >= right) {return;}
        int partitionIndex = partitionB(array, left, right);
        sortB(array, left, partitionIndex - 1);
        sortB(array, partitionIndex + 1, right);
    }

    private static int partitionB(int[] array, int left, int right) {
        int pivot = array[right];
        int leftIndex = left;
        int rightIndex = right - 1;
        while(true) {
            while(leftIndex < right & array[leftIndex] <= pivot) {
                leftIndex++;
            }
            while(rightIndex >= left && array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex > rightIndex){ break;}
            swap(array, leftIndex, rightIndex);
        }
        // swap pivot to the right position
        swap(array, leftIndex, right);
        return leftIndex;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
