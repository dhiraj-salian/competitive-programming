package com.dhirajsalian.cp;

/*
Given an array A, find the maximum sub-array sum.

Examples:

Input 1: A = [ 2, 3, -8, 7, -1, 2, 3 ]
Output 1: 11

Input 2: A = [ 5, 8, 3 ]
Output 2: 16

Input 3: A = [ -6, -1, -8 ]
Output 3: -1

Source: geeksforgeeks.org
 */
public class MaximumSumSubArray {

    static int maxSubArraySum(int[] a) {
        int maxEnding=a[0], res = a[0];
        for (int i = 1; i < a.length; i++) {
            maxEnding = Math.max(a[i], a[i] + maxEnding);
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputs = {{2, 3, -8, 7, -1, 2, 3}, {5, 8, 3}, {-6, -1, -8}};
        for (int[] input : inputs) {
            System.out.println(maxSubArraySum(input));
        }
    }

}
