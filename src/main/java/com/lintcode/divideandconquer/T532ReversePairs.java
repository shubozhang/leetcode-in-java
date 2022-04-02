package com.lintcode.divideandconquer;

/**
 * Created by shubo.zhang on 9/20/2016.
 */
public class T532ReversePairs {


    public long getReversePairs(int[] A) {
        int len = A.length;
        int[] helper = new int[len];

        int sum = sort(A, helper,0, len -1);

        return sum;
    }

    private int sort(int[] A, int[] helper, int lo, int hi) {

        if (lo >= hi) {
            return 0;
        }

        int mid = lo + (hi - lo)/ 2;
        int sum = 0;
        sum = sum + sort(A, helper,lo, mid);
        sum = sum + sort(A, helper, mid + 1, hi);
        sum = sum + merge(A, helper, lo, mid, hi);
        return sum;
    }

    private int merge(int[] A, int[] helper, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            helper[i] = A[i];
        }

        int i = lo;
        int j = mid + 1;
        int k = lo;
        int sum  = 0;

        while (i <= mid && j <= hi) {
            if (helper[i] <= helper[j]) {
                A[k] = helper[i];
                k++;
                i++;
            } else {
                A[k] = helper[j];
                k++;
                j++;
                sum = sum + mid - i + 1;

            }
        }

        while (i <= mid) {
            A[k] = helper[i];
            k++;
            i++;
        }

        return sum;
    }
}
