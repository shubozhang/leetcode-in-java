package com.basics;

import java.util.Arrays;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        String[] a = {"a", "jk", "abb", "mn","abc"};
        String[] b = {"bb", "kj", "bbc", "op","def"};

        System.out.println(getMinimumDifference(a, b));
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
