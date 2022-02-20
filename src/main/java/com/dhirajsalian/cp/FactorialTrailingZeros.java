package com.dhirajsalian.cp;

/*
Given an integer N, find the number of trailing zeros in the factorial of N.

Examples:

Input 1: N = 5
Output 1: 1

Input 2: N = 10
Output 2: 2

Input 3: N = 100
Output 3: 24

Source: geeksforgeeks.org
 */
public class FactorialTrailingZeros {

    static int getFactorialTrailingZeros(int n) {
        int ans = 0;
        for (int fives = 5; fives <= n; fives *= 5) {
            ans += n / fives;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {5, 10, 100};
        for (int j : input) {
            System.out.println(getFactorialTrailingZeros(j));
        }
    }

}
