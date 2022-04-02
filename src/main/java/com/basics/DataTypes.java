package com.basics;


public class DataTypes {

    public static void main(String[] args) {
        int size = 5;
        double[] nums = {-150d, 150_000d, 1_500_000_000d,
                213333333333333333333333333333333333d, -100_000_000_000_000d};

        for (int i = 0; i < size; i++) {
            double x = nums[i];
            try {
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) {
                    System.out.println("* byte");
                }
                if (x >= -Math.pow(2, 15) && x <= Math.pow(2, 15) - 1) {
                    System.out.println("* short");
                }
                if (x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1) {
                    System.out.println("* int");
                }
                if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1) {
                    System.out.println("* long");
                }

            } catch (Exception e) {
                System.out.println(x + " can't be fitted anywhere.");
            }

        }
    }
}
