package com.basics;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
       /* System.out.println((short)(-Math.pow(2,15)));
        System.out.println(Math.pow(2,15));

        List<String> list = new ArrayList<>();
        System.out.println(list.size());

        int[] ints = {1, 2, 3};
        System.out.println(ints.length);

        String s = "ABC";
        System.out.println(s.length());

        String s1 = String.valueOf(s.charAt(0));*/

        BigDecimal bigDecimal = new BigDecimal("100");
        BigInteger b1 = new BigInteger("123456");
        BigInteger b2 = new BigInteger("5678");
        System.out.println(b1.add(b2));
        System.out.println(b1.multiply(b2));


    }


}
