// Problem: https://leetcode.com/problems/spiral-matrix/

package com.dhirajsalian.cp.leetcode.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while (true) {
            addRow(ans, matrix, rowStart++, colStart, colEnd, false);
            if (rowStart > rowEnd) break;
            addColumn(ans, matrix, colEnd--, rowStart, rowEnd, false);
            if (colStart > colEnd) break;
            addRow(ans, matrix, rowEnd--, colStart, colEnd, true);
            if (rowStart > rowEnd) break;
            addColumn(ans, matrix, colStart++, rowStart, rowEnd, true);
            if (colStart > colEnd) break;
        }
        return ans;
    }

    void addColumn(List<Integer> list, int[][] matrix, int col, int rowStart, int rowEnd, boolean reverse) {
        if (reverse)
            for (int i = rowEnd; i >= rowStart; i--)
                list.add(matrix[i][col]);
        else
            for (int i = rowStart; i <= rowEnd; i++)
                list.add(matrix[i][col]);
    }

    void addRow(List<Integer> list, int[][] matrix, int row, int colStart, int colEnd, boolean reverse) {
        if (reverse)
            for (int i = colEnd; i >= colStart; i--)
                list.add(matrix[row][i]);
        else
            for (int i = colStart; i <= colEnd; i++)
                list.add(matrix[row][i]);
    }
}
