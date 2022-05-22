package com.leetcode.string;

import java.util.Stack;



/**
 https://leetcode.com/problems/add-strings/

 Given two non-negative integers, num1 and num2 represented as string, return the sum of
 num1 and num2 as a string.

 You must solve the problem without using any built-in library for handling large integers
 (such as BigInteger). You must also not convert the inputs to integers directly.



 Example 1:

 Input: num1 = "11", num2 = "123"
 Output: "134"
 Example 2:

 Input: num1 = "456", num2 = "77"
 Output: "533"
 Example 3:

 Input: num1 = "0", num2 = "0"
 Output: "0"


 Constraints:

 1 <= num1.length, num2.length <= 104
 num1 and num2 consist of only digits.
 num1 and num2 don't have any leading zeros except for the zero itself.


 same question: 67. Add Binary
 * */
public class E415AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;
        }

        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public String addStringsB(String num1, String num2) {
        if (num1.length() >= num2.length()) {
            return add(num1, num2);
        }

        return add(num2, num1);
    }

    private String add(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0;
        int carry = 0;
        Stack<String> stack = new Stack<>();
        while (i < len2) {
            int n1 = Integer.parseInt(String.valueOf(s1.charAt(len1 - 1 - i)));
            int n2 = Integer.parseInt(String.valueOf(s2.charAt(len2 - 1 - i)));
            int sum = n1 + n2 + carry;
            int num = sum % 10;
            carry = sum / 10;
            stack.push(String.valueOf(num));
            i++;
        }

        int diff = len1 - len2;
        if (diff > 0) {
            int j = 0;
            while (j < diff) {
                int n = Integer.parseInt(String.valueOf(s1.charAt(len1 - len2 - 1 - j)));
                int sum = n + carry;
                int num = sum % 10;
                carry = sum / 10;
                stack.push(String.valueOf(num));
                j++;
            }
        }

        if (carry > 0) {
            stack.push(String.valueOf(carry));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
