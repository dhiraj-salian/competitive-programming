package com.dhirajsalian.cp;

/*
Given a prefix sum, and multiple queries of following types on the array, how to efficiently perform
these queries.

Examples:

Main Input: arr = [ 2, 8, 3, 9, 6, 5, 4 ]

Input 1: l = 0, r = 2
Output 1: 13

Input 2: l = 1, r = 3
Output 2: 20

Input 3: l = 2, r = 6
Output 3: 27

Source: geeksforgeeks.org
 */
public class PrefixSum {

    static int[] prefixSum;

    static int sum(int[] mainInput, int l, int r) {
        computePrefixSum(mainInput);
        return prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0);
    }

    static void computePrefixSum(int[] mainInput) {
        if (prefixSum == null) {
            prefixSum = new int[mainInput.length];
            prefixSum[0] = mainInput[0];
            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + mainInput[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] mainInput = {2, 8, 3, 9, 6, 5, 4};
        int[] inputL = {0, 1, 2};
        int[] inputR = {2, 3, 6};
        for (int i = 0; i < inputL.length; i++) {
            System.out.println(sum(mainInput, inputL[i], inputR[i]));
        }
    }
}
