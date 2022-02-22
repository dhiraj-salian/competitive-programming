package com.dhirajsalian.cp;

/*
Given a binary array A, find the maximum length of consecutive 1s.

Examples:

Input 1: A = [ 0, 1, 1, 0, 1, 0 ]
Output 1: 2

Input 2: A = [ 1, 1, 1, 1 ]
Output 2: 4

Input 3: A = [ 0, 0, 0 ]
Output 3: 0

Input 4: A = [ 1, 0, 1, 1, 1, 1, 0, 1, 1 ]
Output 4: 4

Source: geeksforgeeks.org
 */
public class MaximumConsecutiveOnes {

    static int maxConsecutiveOnes(int[] b) {
        int count = 0, maxCount = 0;
        for (int j : b) {
            if (j == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[][] inputs = {{0, 1, 1, 0, 1, 0}, {1, 1, 1, 1}, {0, 0, 0}, {1, 0, 1, 1, 1, 1, 0, 1, 1}};
        for (int[] input : inputs) {
            System.out.println(maxConsecutiveOnes(input));
        }
    }
}
