//Problem: https://leetcode.com/problems/maximum-score-from-removing-substrings/

package com.dhirajsalian.cp.leetcode.maxScoreRemoveSubstring;

import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        int higherPoint = Math.max(x, y);
        int lowerPoint = Math.min(x, y);
        String higherStr = x == higherPoint ? "ab" : "ba";
        String lowerStr = x == higherPoint ? "ba" : "ab";
        Stack<Character> stack1 = new Stack<>(), stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack1.isEmpty()
                    && stack1.peek().equals(higherStr.charAt(0))
                    && s.charAt(i) == higherStr.charAt(1)) {
                result += higherPoint;
                stack1.pop();
            } else {
                stack1.add(s.charAt(i));
            }
        }
        while (!stack1.isEmpty()) {
            if (!stack2.isEmpty()
                    && stack1.peek().equals(lowerStr.charAt(0))
                    && stack2.peek().equals(lowerStr.charAt(1))) {
                stack1.pop();
                stack2.pop();
                result += lowerPoint;
            } else {
                stack2.push(stack1.pop());
            }
        }
        return result;
    }
}

