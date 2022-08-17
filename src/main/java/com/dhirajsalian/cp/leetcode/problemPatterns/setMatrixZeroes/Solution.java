// Problem: https://leetcode.com/problems/set-matrix-zeroes/

package com.dhirajsalian.cp.leetcode.problemPatterns.setMatrixZeroes;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zerothRow = false, zerothColumn = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) zerothRow = true;
                    if (j == 0) zerothColumn = true;
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (zerothRow) updateRow(matrix, 0);
        if (zerothColumn) updateColumn(matrix, 0);
    }

    void updateColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    void updateRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
}
