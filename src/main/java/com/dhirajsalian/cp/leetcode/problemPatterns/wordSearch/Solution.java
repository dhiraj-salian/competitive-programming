// Problem: https://leetcode.com/problems/word-search/

package com.dhirajsalian.cp.leetcode.problemPatterns.wordSearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        int iMax = board.length - 1;
        int jMax = board[0].length - 1;
        boolean[][] seen = new boolean[iMax + 1][jMax + 1];
        for (int i = 0; i <= iMax; i++) {
            for (int j = 0; j <= jMax; j++) {
                if (exist(board, word, i, j, new StringBuilder(""), iMax, jMax, seen)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j,
                          StringBuilder currentWord, int iMax, int jMax, boolean[][] seen) {
        currentWord.append(board[i][j]);
        seen[i][j] = true;
        if (!word.startsWith(currentWord.toString())) {
            currentWord.deleteCharAt(currentWord.length() - 1);
            seen[i][j] = false;
            return false;
        }
        if (word.equals(currentWord.toString())) {
            currentWord.deleteCharAt(currentWord.length() - 1);
            seen[i][j] = false;
            return true;
        }
        boolean result = false;
        if (isValidIndex(i + 1, j, iMax, jMax, seen))
            result |= exist(board, word, i + 1, j, currentWord, iMax, jMax, seen);
        if (isValidIndex(i - 1, j, iMax, jMax, seen))
            result |= exist(board, word, i - 1, j, currentWord, iMax, jMax, seen);
        if (isValidIndex(i, j + 1, iMax, jMax, seen))
            result |= exist(board, word, i, j + 1, currentWord, iMax, jMax, seen);
        if (isValidIndex(i, j - 1, iMax, jMax, seen))
            result |= exist(board, word, i, j - 1, currentWord, iMax, jMax, seen);
        currentWord.deleteCharAt(currentWord.length() - 1);
        seen[i][j] = false;
        return result;
    }

    private boolean isValidIndex(int i, int j, int iMax, int jMax, boolean[][] seen) {
        return i >= 0 && i <= iMax && j >= 0 && j <= jMax && !seen[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
    }
}


/*

{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}
"ABCCED"

 */