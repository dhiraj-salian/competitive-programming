package com.dhirajsalian.cp;

/*
Given a set A, find how many subset of set A has sum s.

Examples:

Input 1: A = [ 10, 5, 2, 3, 6 ], s = 8
Output 1: 2

Input 2: A = [ 1, 2, 3 ], s = 4
Output 2: 1

Input 3: A = [ 10, 20, 15 ], s = 37
Output 3: 0

Source: geeksforgeeks.org
 */
public class SubsetSumRecursive {

    static int subsetSum(int[] a, int s) {
        return subsetSum(a, s, a.length - 1);
    }

    static int subsetSum(int[] a, int s, int index) {
        if (index == -1)
            return s == 0 ? 1 : 0;
        return subsetSum(a, s - a[index], index - 1) + subsetSum(a, s, index - 1);
    }

    public static void main(String[] args) {
        int[][] inputA = {{10, 5, 2, 3, 6}, {1, 2, 3}, {10, 20, 15}};
        int[] inputS = {8, 4, 37};
        for (int i = 0; i < inputS.length; i++) {
            System.out.println(subsetSum(inputA[i], inputS[i]));
        }
    }
}
