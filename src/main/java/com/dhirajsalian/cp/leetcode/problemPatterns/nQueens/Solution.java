// Problem: https://leetcode.com/problems/n-queens/

package com.dhirajsalian.cp.leetcode.problemPatterns.nQueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(String.join("", Collections.nCopies(n, ".")));
        }
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, n, board, result, 0, 0);
        return result;
    }

    void solveNQueens(int n, int currentN, List<String> currentBoard, List<List<String>> result, int row, int column) {
        if (currentN == 0) {
            result.add(new ArrayList<>(currentBoard));
            return;
        }
        if (row >= n) return;
        if (column >= n) {
            solveNQueens(n, currentN, currentBoard, result, row + 1, column);
            return;
        }
        if (isValid(currentBoard, n, row, column)) {
            currentBoard.set(row, currentBoard.get(row).substring(0, column) + "Q" + currentBoard.get(row).substring(column + 1));
            solveNQueens(n, currentN - 1, currentBoard, result, row + 1, 0);
            currentBoard.set(row, currentBoard.get(row).substring(0, column) + "." + currentBoard.get(row).substring(column + 1));
        }
        solveNQueens(n, currentN, currentBoard, result, row, column + 1);
    }


    boolean isValid(List<String> currentBoard, int n, int row, int column) {
        for (int i = 0; i < n; i++) {
            if (currentBoard.get(row).charAt(i) == 'Q') return false;
            if (currentBoard.get(i).charAt(column) == 'Q') return false;
            if (row - i >= 0 && column - i >= 0) {
                if (currentBoard.get(row - i).charAt(column - i) == 'Q') return false;
            }
            if (row + i < n && column + i < n) {
                if (currentBoard.get(row + i).charAt(column + i) == 'Q') return false;
            }
            if (row - i >= 0 && column + i < n) {
                if (currentBoard.get(row - i).charAt(column + i) == 'Q') return false;
            }
            if (row + i < n && column - i >= 0) {
                if (currentBoard.get(row + i).charAt(column - i) == 'Q') return false;
            }
        }
        return true;
    }
}
