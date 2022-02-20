package com.dhirajsalian.cp;

import java.util.ArrayList;
import java.util.List;

/*
Given a number N, print prime factors of the given number.

Examples:

Input 1: N = 12
Output 1: 2 2 3

Input 2: N = 13
Output 2: 13

Input 3: N = 315
Output 3: 3 3 5 7

Source: geeksforgeeks.org
 */
public class PrimeFactors {

    static void printPrimeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        n = reduceAndGetPrimeFactors(n, 2, primeFactors);
        n = reduceAndGetPrimeFactors(n, 3, primeFactors);
        for (int i = 5; i * i <= n; i += 6) {
            n = reduceAndGetPrimeFactors(n, i, primeFactors);
            n = reduceAndGetPrimeFactors(n, (i + 2), primeFactors);
        }
        System.out.println(primeFactors);
    }

    private static int reduceAndGetPrimeFactors(int n, int x, List<Integer> primeFactors) {
        while (n % x == 0) {
            primeFactors.add(x);
            n /= x;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] input = {12, 13, 315};
        for (int j : input) {
            printPrimeFactors(j);
        }
    }
}
