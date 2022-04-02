package com.lintcode.divideandconquer;

/**
 * Two drawbacks:
 * 1) merge sort is not in-place. It needs extra space to complete merge.
 * 2) merge sort can keep element's original order, but not quick-sort.
 * For instance, use quick-sort to sort points based on x.
 * input order: (1,1), (1,3). Output order may change to (1,3),(1,1).
 * If key is same, merge-sort always keep the input order.
 *
 * Usually, system uses quick-sort as a default sort algorithm
 *
 * MergeSort: nlogn  / O(n)
 * Quick: nlogn / O(1)
 */
public class T464MergeSort {

    public Comparable[] sort(Comparable[] input) {
        if (null == input || input.length == 0) {
            return input;
        }
        int len = input.length;
        Comparable[] helper = new Comparable[len];
        sort(input, helper, 0, len - 1);
        return input;
    }

    private void sort(Comparable[] input, Comparable[] helper, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            sort(input, helper, lo, mid);
            sort(input, helper, mid + 1, hi);
            merge(input,helper, lo, mid, hi);
        }
    }

    private void merge(Comparable[] input, Comparable[] helper, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            helper[i] = input[i];
        }

        int i = lo;
        int j = mid + 1;
        int k = lo;

        while (i <= mid && j <= hi) {
            if (helper[i].compareTo(helper[j]) <= 0) {
                input[k] = helper[i];
                i++;
                k++;
            } else {
                input[k] = helper[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            input[k] = helper[i];
            i++;
            k++;
        }
    }
}
