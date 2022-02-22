package com.dhirajsalian.cp;

/*
Given an  unsorted array of non-negative integers and a sum, find if there is a sub-array with given sum.

Examples:

Input 1: arr = [ 1, 4, 20, 3, 10, 5 ], sum = 33
Output 1: yes

Input 2: arr = [ 1, 4, 0, 0, 3, 10, 5 ], sum = 7
Output 2: yes

Input 3: arr = [ 2, 4 ], sum = 3
Output 3: no

Source: geeksforgeeks.org
 */
public class SubArrayWithGivenSum {

    static boolean isSubArrayPresent(int[] arr, int sum) {
        int i = 0, start = 0;
        while (i < arr.length) {
            if (sum == 0) return true;
            while (sum > 0 && i < arr.length) {
                sum -= arr[i];
                i++;
            }
            while (sum < 0 && start < i) {
                sum += arr[start];
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 4, 20, 3, 10, 5}, {1, 4, 0, 0, 3, 10, 5}, {2, 4}};
        int[] inputSum = {33, 7, 3};
        for (int i = 0; i < inputSum.length; i++) {
            System.out.println(isSubArrayPresent(inputs[i], inputSum[i]) ? "yes" : "no");
        }
    }
}
