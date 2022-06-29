// Problem: https://leetcode.com/problems/sudoku-solver/

package com.dhirajsalian.cp.leetcode.sudokuSolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public void solveSudoku(char[][] board) {
        List<Set<Integer>> rowSet = new ArrayList<>();
        List<Set<Integer>> colSet = new ArrayList<>();
        List<Set<Integer>> subBoxSet = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowSet.add(i, new HashSet<>());
            colSet.add(i, new HashSet<>());
            subBoxSet.add(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rowSet.get(i).add(getInt(board[i][j]));
                colSet.get(j).add(getInt(board[i][j]));
                subBoxSet.get(subBoxIndex(i, j)).add(getInt(board[i][j]));
            }
        }
        solveSudoku(board, 0, 0, rowSet, colSet, subBoxSet);
    }

    private boolean solveSudoku(char[][] board, int row, int col, List<Set<Integer>> rowSet,
                                List<Set<Integer>> colSet, List<Set<Integer>> subBoxSet) {
        if (row >= 9) {
            return true;
        }
        if (col >= 9) {
            return solveSudoku(board, row + 1, 0, rowSet, colSet, subBoxSet);
        }
        if (board[row][col] != '.') {
            return solveSudoku(board, row, col + 1, rowSet, colSet, subBoxSet);
        }
        for (int i = 1; i <= 9; i++) {
            if (!rowSet.get(row).contains(i) && !colSet.get(col).contains(i) && !subBoxSet.get(subBoxIndex(row, col)).contains(i)) {
                rowSet.get(row).add(i);
                colSet.get(col).add(i);
                subBoxSet.get(subBoxIndex(row, col)).add(i);
                board[row][col] = (char) (i + '0');
                if (solveSudoku(board, row, col + 1, rowSet, colSet, subBoxSet)) return true;
                rowSet.get(row).remove(i);
                colSet.get(col).remove(i);
                subBoxSet.get(subBoxIndex(row, col)).remove(i);
                board[row][col] = '.';
            }
        }
        return false;
    }

    private int getInt(char digit) {
        return digit - '0';
    }

    private int subBoxIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }
}
