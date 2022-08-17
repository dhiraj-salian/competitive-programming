// Problem: https://leetcode.com/problems/backspace-string-compare/

package com.dhirajsalian.cp.leetcode.problemPatterns.backspaceStringCompare;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>(), ts = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!ss.isEmpty()) ss.pop();
            } else ss.push(s.charAt(i));
        }
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == '#') {
                if (!ts.isEmpty()) ts.pop();
            } else ts.push(t.charAt(j));
        }
        if (ss.size() != ts.size())
            return false;
        while(!ss.isEmpty()) {
            if (ss.pop() != ts.pop()) return false;
        }
        return true;
    }
}
