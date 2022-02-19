package com.dhirajsalian.cp;

/*
Given a number n, check whether it is a power of 2.

Examples:

Input 1: n = 4
Output 1: yes

Input 2: n = 6
Output 2: no
 */
public class PowerOf2 {

    static boolean isPowerOf2(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int[] input = {4, 6};
        for (int j : input) {
            System.out.println(isPowerOf2(j) ? "yes" : "no");
        }
    }
}
