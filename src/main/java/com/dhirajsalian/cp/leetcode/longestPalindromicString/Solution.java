// Problem: https://leetcode.com/problems/longest-palindromic-substring/

package com.dhirajsalian.cp.leetcode.longestPalindromicString;

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int end, maxLength = 0, resStart = -1, resEnd = -1;
        for (int length = 1; length <= s.length(); length++) {
            for (int start = 0; start < s.length(); start++) {
                end = start + length - 1;
                if (end < s.length()) {
                    if (start == end) isPalindrome[start][end] = true;
                    else if (start + 1 == end) isPalindrome[start][end] = s.charAt(start) == s.charAt(end);
                    else
                        isPalindrome[start][end] = s.charAt(start) == s.charAt(end) && isPalindrome[start + 1][end - 1];
                    if (isPalindrome[start][end] && length > maxLength) {
                        maxLength = length;
                        resStart = start;
                        resEnd = end;
                    }
                }
            }
        }
        return s.substring(resStart, resEnd + 1);
    }
}
