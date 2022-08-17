// Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/

package com.dhirajsalian.cp.leetcode.problemPatterns.longestSubstringWithoutRepeatingCharacter;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int[] charCount = new int[256];
        int res = 0;
        while (end < s.length()) {
            charCount[s.charAt(end)]++;
            while (start <= end && isRepeating(charCount)) {
                charCount[s.charAt(start)]--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }

    boolean isRepeating(int[] charCount) {
        for (int i = 0; i < 256; i++)
            if (charCount[i] > 1)
                return true;
        return false;
    }
}
