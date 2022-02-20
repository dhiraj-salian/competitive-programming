package com.dhirajsalian.cp;

/*
Given a number N, check whether it is a prime number or not.

Examples:

Input 1: n = 13
Output 1: yes

Input 2: n = 14
Output 2: no

Input 3: n = 101
Output 3: yes

Source: geeksforgeeks.org
 */
public class PrimeNumber {

    static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {13, 14, 101};
        for (int j : input) {
            System.out.println(isPrime(j) ? "yes" : "no");
        }
    }
}
