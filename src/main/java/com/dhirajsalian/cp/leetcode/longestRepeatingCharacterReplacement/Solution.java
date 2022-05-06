// Problem: https://leetcode.com/problems/longest-repeating-character-replacement/

package com.dhirajsalian.cp.leetcode.longestRepeatingCharacterReplacement;

class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, maxCount = 0, res = 0;
        int[] charsCount = new int[26];
        while (end < s.length()) {
            charsCount[index(s.charAt(end))]++;
            maxCount = Math.max(maxCount, charsCount[index(s.charAt(end))]);
            while (end - start + 1 - maxCount > k) {
                charsCount[index(s.charAt(start))]--;
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }

    int index(int charCode) {
        return charCode - 'A';
    }
}
