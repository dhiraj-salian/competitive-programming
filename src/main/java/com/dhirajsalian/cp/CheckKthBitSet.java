package com.dhirajsalian.cp;

/*
Given a number n and bit position k, check if kth bit set for the given number.

Examples:

Input 1: n = 5, k = 1
Output 1: Yes

Input 2: n = 8, k = 2
Output 2: No

Input 3: n = 0, k = 3
Output 3: No
 */
public class CheckKthBitSet {

    static boolean isKthBitSetLS(int n, int k) {
        return ((n >> (k - 1)) & 1) == 1;
    }

    static boolean isKthBitSetRS(int n, int k) {
        return (n & (1 << (k - 1))) != 0;
    }

    public static void main(String[] args) {
        int[] inputN = {5, 8, 0};
        int[] inputK = {1, 2, 3};
        for (int i = 0; i < inputN.length; i++) {
            System.out.println(isKthBitSetLS(inputN[i], inputK[i]) ? "Yes" : "No");
            System.out.println(isKthBitSetRS(inputN[i], inputK[i]) ? "Yes" : "No");
        }
    }
}
