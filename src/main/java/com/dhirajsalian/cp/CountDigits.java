package com.dhirajsalian.cp;

/*
Given an Integer X, count number of digits in the given number.

Examples:

Input 1: X = 9235
Output 1: 4

Input 2: X = 38
Output 2: 2

Input 3: X = 7
Output 3: 1
 */
public class CountDigits {

    static int countDigits(int x) {
        return (int) Math.floor(Math.log10(x) + 1);
    }

    public static void main(String[] args) {
        int[] input = {9235, 38, 7};
        for (int j : input) {
            System.out.println(countDigits(j));
        }
    }
}
