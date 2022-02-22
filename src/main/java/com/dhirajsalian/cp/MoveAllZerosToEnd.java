package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomArrayUtil;

/*
Given an array of integers A, move zeros to end.

Examples:

Input 1: A = [ 8, 5, 0, 10, 0, 20 ]
Output 1: A = [ 8, 5, 10, 20, 0, 0 ]

Input 2: A = [ 0, 0, 0, 10, 0 ]
Output 2: A = [ 10, 0, 0, 0, 0 ]

Input 3: A = [ 10, 20 ]
Output 3: A = [ 10, 20 ]

Source: geeksforgeeks.org
 */
public class MoveAllZerosToEnd {

    static void moveZerosToEnd(int[] a) {
        int zero = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                if (zero == -1)
                    zero = i;
            } else {
                if (zero > -1) {
                    CustomArrayUtil.swap(a, i, zero);
                    zero = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {{8, 5, 0, 10, 0, 20}, {0, 0, 0, 10, 0}, {10, 20}};
        for (int[] input : inputs) {
            moveZerosToEnd(input);
            CustomArrayUtil.print(input);
        }
    }
}
