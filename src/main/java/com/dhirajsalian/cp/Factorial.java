package com.dhirajsalian.cp;

/*
Given an integer N, find factorial of the number.

Examples:

Input 1: N = 4
Output 1: 24

Input 2: N = 6
Output 2: 720

Input 3: N = 0
Output 3: 1
 */
public class Factorial {

    static int factorial1(int n) {
        if (n == 0) return 1;
        return n * factorial1(n - 1);
    }

    static int factorial2(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 0};
        for (int j : input) {
            System.out.println(factorial2(j));
        }
    }
}
