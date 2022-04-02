package com.leetcode.string.easy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:

 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class L006ZigZagConversion {

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(convertA("PAYPALISHIRING", 3)));
    }

    private static String convertA(String s, int rows) {
        StringBuilder str = new StringBuilder("");

        for (int i = 0; i < s.length(); ) {
            str = str.append(s.charAt(i));
            i = i + rows + 1;
        }

        for (int i = 1; i < s.length(); i++) {
            str = str.append(s.charAt(i));
            i = i + rows - 1;
        }

        for (int i = 2; i < s.length(); i++) {
            str = str.append(s.charAt(i));
            i = i + rows + 1;
        }
        return str.toString();
    }


}
