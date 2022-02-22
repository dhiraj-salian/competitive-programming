package com.dhirajsalian.cp;

/*
Given an array of integers and a number k, find the maximum sum of consecutive k elements.

Examples:

Input 1: arr = [ 1, 8, 30, -5, 20, 7 ], k = 3
Output 1: 45

Input 2: arr = [ 5, -10, 6, 90, 3 ]
Output 2: 96

Source: geeksforgeeks.org
 */
public class WindowSlidingTechnique {

    static int maxSum(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int maxSum = sum;
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] inputK = {3, 2};
        int[][] inputArr = {{1, 8, 30, -5, 20, 7}, {5, -10, 6, 90, 3}};
        for (int i = 0; i < inputK.length; i++) {
            System.out.println(maxSum(inputArr[i], inputK[i]));
        }
    }
}
