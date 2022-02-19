package com.dhirajsalian.cp;

/*
Given a number N, print all the divisors of the given number in increasing order.

Examples:

Input 1: N = 15
Output 1: 1 3 5 15

Input 2: N = 100
Output 2: 1 2 4 5 10 20 25 50 100

Input 3: N = 7
Output 3: 1 7

 */
public class Divisors {

    static void printAllDivisors(int n) {
        int i = 1;
        for (; i * i < n; i++)
            if (n % i == 0)
                System.out.print(i + " ");
        for (; i >= 1; i--)
            if (n % i == 0)
                System.out.print(n / i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {15, 100, 7};
        for (int j : input) {
            printAllDivisors(j);
        }
    }
}
