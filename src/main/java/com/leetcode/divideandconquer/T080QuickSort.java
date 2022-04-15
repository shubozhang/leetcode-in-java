package com.leetcode.divideandconquer;


public class T080QuickSort {

    public Comparable[] quickSort(Comparable[] input) {
        if (null == input || input.length ==0) {
            return input;
        }

        int len = input.length;
        sort(input,0,len -1);
        return input;
    }

    private void sort(Comparable[] input, int lo, int hi) {
        int i = lo;
        int j = hi;

        // Choose a pivot element
        Comparable pivot = input[lo + (hi - lo) / 2];

        // partition: divide into two lists
        while (i <= j) {
            while (input[i].compareTo(pivot) < 0) {
                i++;
            }

            while (input[j].compareTo(pivot) > 0) {
                j--;
            }

            /*
            *  If we have found a values in the left list which is larger then
            *  the pivot element and if we have found a value in the right list
            *  which is smaller then the pivot element then we exchange the
            *  values.
            *  As we are done we can increase i and j
            * */
            if (i <= j) {
                swap(input, i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (lo < j) {
            sort(input, lo, j);
        }
        if (i < hi) {
            sort(input, i, hi);
        }
    }

    private void swap(Comparable[] input, int i, int j) {
        Comparable tem = input[i];
        input[i] = input[j];
        input[j] = tem;
    }
}
