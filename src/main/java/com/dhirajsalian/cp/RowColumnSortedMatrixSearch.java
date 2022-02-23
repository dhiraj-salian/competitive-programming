package com.dhirajsalian.cp;

/*
Given a row-sorted and column-sorted matrix, find the element k in the given matrix.

Examples:

Input 1 : M = [ 10 20 30 40     , k = 29
                15 25 35 45
                27 29 37 48
                32 33 39 50 ]
Output 1: 2 1

Input 2: M = [ 10 20        , k = 15
               12 30 ]
Output 2:  Not Found

Source: geeksforgeeks.org
 */
public class RowColumnSortedMatrixSearch {

    static void search(int[][] m, int k) {
        int rp = 0, cp = m[0].length - 1;
        while (rp >= 0 && rp < m.length && cp >= 0 && cp < m[0].length) {
            if (m[rp][cp] == k) {
                System.out.printf("(%s,%s)\n", rp, cp);
                return;
            } else if (m[rp][cp] < k) {
                rp++;
            } else {
                cp--;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}},
                {{10, 20}, {12, 30}}
        };
        int[] inputK = {29, 15};
        for (int i = 0; i < inputK.length; i++) {
            search(inputs[i], inputK[i]);
        }
    }
}
