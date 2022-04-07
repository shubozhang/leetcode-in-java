package com.lintcode;

import java.util.*;

/**
* Description
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)
* */
public class T057ThreeSum {
    List<List<Integer>> results = new ArrayList<>();


    private List<List<Integer>> threeSum(int[] A) {
        if (A == null || A.length < 3) {
            return results;
        }

        Arrays.sort(A);
        // enumerate c, the maximum element
        int i;
        int n = A.length;
        for (i = 2; i < n; ++i) {
            // c is always the last in a bunch of duplicates
            if (i + 1 < n && A[i + 1] == A[i]) {
                continue;
            }

            // want to find all pairs of A[j]+A[k]=-A[i], such that
            // j < k < i
            twoSum(A, i - 1, -A[i]);
        }
        Collections.sort(results, new ListComparator<>());
        return results;

    }

    private void twoSum(int[] A, int right, int target) {
        int i, j;
        j = right;
        for (i = 0; i <= right; ++i) {
            // A[i] must be the first in its duplicates
            if (i > 0 && A[i] == A[i - 1]) { continue; }

            while (j > i && A[j] > target - A[i]) { --j; }

            if (i >= j) { break; }

            if (A[i] + A[j] == target) {
                List<Integer> t = new ArrayList<>();
                t.add(A[i]);
                t.add(A[j]);
                t.add(-target); // t.add(A[right+1])
                results.add(t);
            }
        }
    }


    // This is soring results using 1st number as 1st key, 2nd number as 2nd key...
    class ListComparator<T extends Comparable<T>> implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int c = a.get(i).compareTo(b.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(a.size(), b.size());
        }
    }

    public static void main(String[] args) {
        T057ThreeSum t057ThreeSum = new T057ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        t057ThreeSum.threeSum(nums).stream().forEach(e -> {
            e.forEach(System.out::print);
            System.out.println();
        });
    }
}
