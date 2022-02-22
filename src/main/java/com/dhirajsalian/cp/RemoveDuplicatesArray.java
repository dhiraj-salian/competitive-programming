package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomArrayUtil;

/*
Given a sorted array A, remove duplicates from A.

Examples:

Input 1: A = [ 10, 20, 20, 30, 30, 30, 30 ]
Output 1: A = [ 10, 20, 30, -, -, -, - ]

Input 2: A = [ 10, 10, 10 ]
Output 2: A = [ 10, -, - ]

Source: geeksforgeeks.org
 */
public class RemoveDuplicatesArray {

    static int removeDuplicates(int[] a) {
        int res = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[res - 1]) {
                a[res] = a[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inputs = {{10, 20, 20, 30, 30, 30, 30}, {10, 10, 10}};
        for (int[] input : inputs) {
            int n = removeDuplicates(input);
            CustomArrayUtil.print(input, n);
        }
    }
}
