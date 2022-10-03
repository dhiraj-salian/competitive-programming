// Problem: https://leetcode.com/problems/word-search-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.wordSearch2;

import java.util.ArrayList;
import java.util.List;


class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
    String word;

    void insert(String word) {
        TrieNode temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null) {
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        temp.isWordEnd = true;
        temp.word = word;
    }
}


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWord(board, root, i, j, m, n, res);
            }
        }

        return res;
    }

    private void findWord(char[][] board, TrieNode root, int r, int c, int m, int n, List<String> result) {
        if (r < 0 || r >= m || c < 0 || c >= n) return;

        if (board[r][c] == '$') return;

        if (root.children[board[r][c] - 'a'] == null) return;

        TrieNode current = root.children[board[r][c] - 'a'];

        if (current.isWordEnd) {
            result.add(current.word);
            current.isWordEnd = false;
            return;
        }

        char temp = board[r][c];
        board[r][c] = '$';

        findWord(board, current, r + 1, c, m, n, result);
        findWord(board, current, r - 1, c, m, n, result);
        findWord(board, current, r, c + 1, m, n, result);
        findWord(board, current, r, c - 1, m, n, result);

        board[r][c] = temp;

    }
}