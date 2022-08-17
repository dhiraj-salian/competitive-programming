package com.dhirajsalian.cp.leetcode.problemPatterns.removeAllAdjacentDuplicatesInString2;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> consecutiveCharCountStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (charStack.isEmpty() || charStack.peek() != s.charAt(i)) {
                charStack.push(s.charAt(i));
                consecutiveCharCountStack.push(1);
            } else if (charStack.peek() == s.charAt(i)) {
                int temp = consecutiveCharCountStack.pop();
                if (temp == k - 1) {
                    charStack.pop();
                } else {
                    consecutiveCharCountStack.push(temp + 1);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!charStack.isEmpty()) {
            char[] chars = new char[consecutiveCharCountStack.pop()];
            Arrays.fill(chars, charStack.pop());
            ans.insert(0, chars);
        }
        return ans.toString();
    }
}
