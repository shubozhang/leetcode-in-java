package com.sorting;

/**
 * @author szhang
 */
public class QuickSort {

    public static void sort(int[] array, int left, int right) {
        if(left >= right) {return;}
        int partitionIndex = partition(array, left, right);
        sort(array, left, partitionIndex - 1);
        sort(array, partitionIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
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
