package com.lintcode;

import java.util.Arrays;

public class T009FizzBuzz {
    public static void main(String[] args) {
        Arrays.stream(fb(15)).forEach(System.out::println);
        Arrays.stream(fb2(15)).forEach(System.out:: println);

    }

    private static String[] fb(int num) {
        String[] res = new String[num];
        for (int i = 1; i <= num; i++) {
            StringBuilder sb = new StringBuilder("");
            if (i % 3 == 0 && i % 5 == 0){
                sb.append("fizz buzz");
            } else if (i % 5 == 0){
                sb.append("buzz");
            } else if (i % 3 == 0){
                sb.append("fizz");
            } else {
                sb.append(String.valueOf(i));
            }
            res[i-1] = sb.toString();
        }
        return res;
    }

    private static String[] fb2(int num){
        String[] res = new String[num];

        for (int i = 1; i <= num; i++) {
                    String str = i % 15 == 0 ? "fizz buzz" : i % 5 == 0
                            ? "buzz": i % 3 == 0 ? "fizz": String.valueOf(i);
                    res[i-1] = str;
        }
        return res;
    }
}
