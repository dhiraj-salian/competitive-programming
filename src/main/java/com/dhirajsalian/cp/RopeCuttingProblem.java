package com.dhirajsalian.cp;

/*
Given a rope of length n, find the maximum number of pieces we can get such that every piece
has length either as a, b or c.

Examples:

Input 1: n = 5, a = 2, b = 5, c = 1
Output 1: 5

Input 2: n = 23, a = 12, b = 9, c = 11
Output 2: 2

Input 3: n = 5, a = 4, b = 2, c = 6
Output 3: -1

Input 4: n = 9, a = 2, b = 2, c = 2
Output 4: -1

Source: geeksforgeeks.org
 */
public class RopeCuttingProblem {

    static int getMaxPieces(int n, int a, int b, int c) {
        if (n == 0) return 0;
        if (n < 0) return -1;
        int pieces = Math.max(Math.max(getMaxPieces(n - a, a, b, c), getMaxPieces(n - b, a, b, c)),
                getMaxPieces(n - c, a, b, c));
        return pieces >= 0 ? 1 + pieces : -1;
    }

    public static void main(String[] args) {
        int[] inputN = {5, 23, 5, 9};
        int[] inputA = {2, 12, 4, 2};
        int[] inputB = {5, 9, 2, 2};
        int[] inputC = {1, 11, 6, 2};
        for (int i = 0; i < inputN.length; i++) {
            System.out.println(getMaxPieces(inputN[i], inputA[i], inputB[i], inputC[i]));
        }
    }

}
