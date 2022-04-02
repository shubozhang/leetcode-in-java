package com.sorting;

import java.util.Arrays;

/**
 *
 * @author shubo.zhang
 * @date 9/13/2016
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] data = {3,2,5,1,6,8,9,0, 9};
        System.out.println(Arrays.toString(selectSort(data)));
    }

    public static int[] selectSort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int pos = i;

            for (int j = i + 1; j < data.length; j++) {
                if (min > data[j]) {
                    min = data[j];
                    pos = j;
                }
            }
            int temp = data[i];
            data[i] = min;
            data[pos] = temp;
        }

       return data;
    }
}
