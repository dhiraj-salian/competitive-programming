// Problem: https://leetcode.com/problems/generate-parentheses/

package com.dhirajsalian.cp.leetcode.problemPatterns.generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, "", result, 0, 0);
        return result;
    }

    private void generateParenthesis(int n, String current, List<String> result, int open, int close) {
        if (n == open && n == close) {
            result.add(current);
            return;
        }
        if (open > n || close > n) return;
        generateParenthesis(n, current + "(", result, open + 1, close);
        if (close < open) {
            generateParenthesis(n, current + ")", result, open, close + 1);
        }
    }
}
