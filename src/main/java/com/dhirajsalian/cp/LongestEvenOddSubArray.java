package com.dhirajsalian.cp;

/*
Given an array A of integers, find the longest even odd sub-array.

Examples:

Input 1: A = [ 10, 12, 14, 7, 8 ]
Output 1: 3

Input 2: A = [ 7, 10, 13, 14 ]
Output 2: 4

Input 3: A = [ 10, 12, 8, 4 ]
Output 3: 1

Source: geeksforgeeks.org
 */
public class LongestEvenOddSubArray {

    static int longestEvenOddSubArray(int[] a) {
        int count = 1, maxCount = 0;
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i] - a[i - 1]) % 2 == 1) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 12, 14, 7, 8}, {7, 10, 13, 14}, {10, 12, 8, 4}};
        for (int[] input : inputs) {
            System.out.println(longestEvenOddSubArray(input));
        }
    }
}
