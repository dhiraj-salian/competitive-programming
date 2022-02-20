package com.dhirajsalian.cp;

/*
Find the sum of digits of a number n, using recursion.

Examples:

Input 1: n = 253
Output 1: 10

Input 2: n = 9987
Output 2: 33

Input 3: n = 10
Output 3: 1

Source: geeksforgeeks.org
 */
public class SumOfDigitsRecursive {

    static int digitSumRecursive(int n) {
        if (n == 0) return 0;
        return n % 10 + digitSumRecursive(n / 10);
    }

    public static void main(String[] args) {
        int[] inputs = {253, 9987, 10};
        for (int j : inputs) {
            System.out.println(digitSumRecursive(j));
        }
    }
}
