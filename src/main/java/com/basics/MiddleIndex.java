package com.basics;

/**
 * @author szhang
 */
public class MiddleIndex {

    public int getMidIndex(int[] arr) {
        int midIndex = -1;

        if (null != arr && arr.length != 0) {
            int rightSum = 0;
            int leftSum = 0;

            for (int i = 0; i < arr.length; i++) {
                rightSum += arr[i];
            }

            for (int i = 0; i < arr.length; i++) {
                leftSum += arr[i];
                rightSum -= arr[i];

                if (leftSum == rightSum) {
                    return i;
                }
            }
        }

        return midIndex;
    }

    public static void main(String[] args) {
        int[] data = {-2,-1,-3,-4,-1,-1};

        MiddleIndex middleIndex = new MiddleIndex();
        System.out.println(middleIndex.getMidIndex(data));
    }
}
