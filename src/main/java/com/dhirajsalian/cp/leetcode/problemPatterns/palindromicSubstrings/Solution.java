// Problem: https://leetcode.com/problems/palindromic-substrings/

package com.dhirajsalian.cp.leetcode.problemPatterns.palindromicSubstrings;

class Solution {

    public int countSubstrings(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int[][] palindromeSS = new int[s.length()][s.length()];
        boolean isCurrentPalindrome, isCharsEqual;
        for (int length = 1; length <= s.length(); length++) {
            for (int start = 0; start + length <= s.length(); start++) {
                int end = start + length - 1;
                if (start == end) {
                    isPalindrome[start][end] = true;
                    palindromeSS[start][end] = 1;
                } else {
                    isCharsEqual = s.charAt(start) == s.charAt(end);
                    if (end - start == 1) {
                        isPalindrome[start][end] = isCharsEqual;
                        palindromeSS[start][end] = isCharsEqual ? 3 : 2;
                    } else {
                        isCurrentPalindrome = isCharsEqual && isPalindrome[start + 1][end - 1];
                        isPalindrome[start][end] = isCurrentPalindrome;
                        palindromeSS[start][end] = palindromeSS[start + 1][end]
                                + palindromeSS[start][end - 1] - palindromeSS[start + 1][end - 1]
                                + (isCurrentPalindrome ? 1 : 0);
                    }
                }
            }
        }
        return palindromeSS[0][s.length() - 1];
    }
}
