package com.dhirajsalian.cp;

/*
Given an integer matrix M, print in snake pattern.

Examples:

Input 1: M = [ 1 2 3 4
               5 6 7 8
               9 10 11 12
               13 14 15 16 ]
Output 1: 1 2 3 4 8 7 6 5 9 10 11 12 16 15 14 13

Input 2: M = [ 1 2 3 4
               5 6 7 8
               9 10 11 12 ]
Output 2: 1 2 3 4 8 7 6 5 9 10 11 12

Source: geeksforgeeks.org
 */
public class MatrixInSnakePattern {

    static void printSnakePattern(int[][] m) {
        boolean reverse = false;
        for (int i = 0; i < m.length; i++) {
            if (!reverse) {
                for (int j = 0; j < m[i].length; j++) {
                    System.out.print(m[i][j] + " ");
                }
            } else {
                for (int j = m[i].length - 1; j >= 0; j--) {
                    System.out.print(m[i][j] + " ");
                }
            }
            reverse = !reverse;
        }
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}},
                {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}
        };
        for (int[][] input : inputs) {
            printSnakePattern(input);
            System.out.println();
        }
    }
}
