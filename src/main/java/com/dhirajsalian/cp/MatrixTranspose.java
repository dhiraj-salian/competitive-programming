package com.dhirajsalian.cp;

import com.dhirajsalian.cp.util.CustomUtil;

/*
Given a matrix m, convert it to transpose of itself.

Examples:

Input 1: M = [ 1 2 3 4
               5 6 7 8
               9 10 11 12
               13 14 15 16 ]
Output 1: M = [ 1 5 9 13
                2 6 10 14
                3 7 11 15
                4 8 12 16 ]

Input 2: M = [ 1 1
               2 2 ]
Output 2: M = [ 1 2
                1 2 ]

Source: geeksforgeeks.org
 */
public class MatrixTranspose {

    static void convertToTranspose(int[][] m) {
        for (int i = 0; i < m.length; i++)
            for (int j = i + 1; j < m[i].length; j++)
                CustomUtil.swap(m, i, j, j, i);
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                {{1, 1}, {2, 2}}
        };
        for (int[][] input : inputs) {
            convertToTranspose(input);
            CustomUtil.print(input);
            System.out.println();
        }
    }
}
