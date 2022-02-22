package com.dhirajsalian.cp;

/*
Given an array arr, find maximum value of arr[j] - arr[i] such that j > i.

Examples:

Input 1: arr = [ 2, 3, 10, 6, 4, 8, 1 ]
Output 1: 8

Input 2: arr =  [ 7, 9, 5, 6, 3, 2 ]
Output 2: 2

Input 3: arr = [ 10, 20, 30 ]
Output 3: 20

Input 4: arr = [ 30, 10, 8, 2 ]
Output 4: -2

Source: geeksforgeeks.org
 */
public class MaximumDifferenceInOrder {

    static int maxDiffInOrder(int[] arr) {
        int max = arr[arr.length - 1], maxDiff = Integer.MIN_VALUE;
        for (int i = arr.length - 2; i >= 0; i--) {
            maxDiff = Math.max(maxDiff, max - arr[i]);
            max = Math.max(arr[i], max);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[][] inputs = {{2, 3, 10, 6, 4, 8, 1}, {7, 9, 5, 6, 3, 2}, {10, 20, 30}, {30, 10, 8, 2}};
        for (int[] input : inputs) {
            System.out.println(maxDiffInOrder(input));
        }
    }

}
