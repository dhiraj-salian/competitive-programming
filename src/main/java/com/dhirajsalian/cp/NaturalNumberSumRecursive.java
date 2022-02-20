package com.dhirajsalian.cp;

/*
Given a natural number n, find the sum of all natural numbers from 1 to n.

Examples:

Input 1: n = 2
Output 1: 3

Input 2: n = 4
Output 2: 10

Input 3: n = 5
Output 3: 15

Source: geeksforgeeks.org
 */
public class NaturalNumberSumRecursive {

    static int sumNaturalNumberRecursive(int n) {
        if (n == 0) return 0;
        return n + sumNaturalNumberRecursive(n - 1);
    }

    public static void main(String[] args) {
        int[] inputs = {2, 4, 5};
        for (int j : inputs) {
            System.out.println(sumNaturalNumberRecursive(j));
        }
    }

}
