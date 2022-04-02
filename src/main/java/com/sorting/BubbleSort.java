package com.sorting;

import java.util.Arrays;

/**
 *
 * @author shubo.zhang
 * @date 9/14/2016
 */
public class BubbleSort {

    public static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j + 1];
                    data[j  + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {3,2,5,1,6,8,9,0, 9};
        bubbleSort(data);
        System.out.println(Arrays.toString(data));
    }
}
