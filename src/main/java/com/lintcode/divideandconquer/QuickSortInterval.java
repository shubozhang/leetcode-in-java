package com.lintcode.divideandconquer;

import com.model.Interval;
import java.util.List;

/**
 *
 * @author shubo.zhang
 * @date 9/23/2016
 */
public class QuickSortInterval {

    public  void quickSort(List<Interval> intervals) {
        int len = intervals.size();

        sort(intervals, 0, len - 1);
    }

    private void sort(List<Interval> intervals, int lo, int hi) {
        int pivot = intervals.get(lo + (hi - lo) / 2).start;
        int i = lo;
        int j = hi;
        int mid = lo + (hi - lo) / 2;


        while (i <= j) {

            while (intervals.get(i).start < pivot) {
                i++;
            }

            while (intervals.get(j).start > pivot) {
                j--;
            }

            if (i <= j) {
                swap(intervals, i, j);
                i++;
                j--;
            }
        }

        if (lo < j) {
            sort(intervals, lo, j);
        }

        if (i < hi) {
            sort(intervals, i, hi);
        }
    }

    private void swap(List<Interval> intervals, int i, int j) {
        Interval temp = new Interval(intervals.get(j).start, intervals.get(j).end);
        intervals.get(j).start = intervals.get(i).start;
        intervals.get(j).end = intervals.get(i).end;
        intervals.get(i).start = temp.start;
        intervals.get(i).end = temp.end;
    }
}
