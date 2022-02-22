package com.dhirajsalian.cp;

/*
Given an array of integers, find if it has an equilibrium point.

Examples:

Input 1: arr = [ 3, 4, 8, -9, 20, 6 ]
Output 1: yes

Input 2: arr = [ 4, 2, -2 ]
Output 2: yes

Input 3: arr = [ 4, 2, 2 ]
Output 3: no

Source: geeksforgeeks.org
 */
public class EquilibriumPoint {

    static boolean hasEquilibriumGFG(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        int l_sum = 0;
        for (int j : arr) {
            if (l_sum == sum - j) {
                return true;
            }
            l_sum += j;
            sum -= j;
        }
        return false;
    }

    static boolean hasEquilibrium(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }
        for (int i = 0; i < arr.length; i++) {
            if ((i == 0 ? 0 : prefixSum[i - 1]) == prefixSum[arr.length - 1] - prefixSum[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] inputs = {{3, 4, 8, -9, 20, 6}, {4, 2, -2}, {4, 2, 2}};
        for (int[] input : inputs) {
            System.out.println(hasEquilibriumGFG(input) ? "yes" : "no");
        }
    }
}
