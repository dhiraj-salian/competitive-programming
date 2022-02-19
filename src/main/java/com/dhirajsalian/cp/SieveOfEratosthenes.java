package com.dhirajsalian.cp;

import java.util.Arrays;

/*
Given a number N, find all the prime number less than N.

Examples:

Input 1: N = 10
Output 1: 2, 3, 5, 7

Input 2: N = 23
Output 2: 2, 3, 5, 7, 11, 13, 17, 19, 23
 */
public class SieveOfEratosthenes {

    static void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.printf("%s ", i);
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {10, 23};
        for (int j : input) {
            sieveOfEratosthenes(j);
        }
    }
}
