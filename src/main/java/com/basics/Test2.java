package com.basics;

import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(5 % 5);
        System.out.println(isPrime(5));
        String[] a = {"a", "jk", "abb", "mn","abc"};
        String[] b = {"bb", "kj", "bbc", "op","def"};

        System.out.println(getMinimumDifference(a, b));
    }

    private static boolean isPrime(int n) {
        // Corner cases
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    static int[] getMinimumDifference(String[] a, String[] b) {
        int len = a.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (a[i].length() != b[i].length()) {
                ans[i] = -1;
            } else {
                char[] c1 = a[i].toCharArray();
                char[] c2 = b[i].toCharArray();
                Arrays.sort(c1);
                Arrays.sort(c2);
                if (Arrays.equals(c1, c2)) {
                    ans[i] = 0;
                } else {
                    List list1 = Arrays.asList(c1);
                    List list2 = Arrays.asList(c2);
                    list1.removeAll(list2);
                    ans[i] = list1.size();
                }
            }
        }
        return ans;
    }
}
