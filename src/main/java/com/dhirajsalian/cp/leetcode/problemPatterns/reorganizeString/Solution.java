// Problem: https://leetcode.com/problems/reorganize-string/

package com.dhirajsalian.cp.leetcode.problemPatterns.reorganizeString;

class Solution {
    public String reorganizeString(String s) {
        int[] frequency = new int[26];
        int maxFrequency = 0;
        char maxFrequencyChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            if (frequency[s.charAt(i) - 'a'] > maxFrequency) {
                maxFrequency = frequency[s.charAt(i) - 'a'];
                maxFrequencyChar = s.charAt(i);
            }
        }
        if (2 * maxFrequency - s.length() > 1) return "";
        char[] ans = new char[s.length()];
        int index = 0;
        for (int i = 0; i < maxFrequency; i++) {
            ans[index] = maxFrequencyChar;
            index += 2;
            frequency[maxFrequency - 'a']--;
        }
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i] >= 0) {
                if (index > ans.length) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                frequency[s.charAt(i) - 'a']--;
            }
        }
        return String.valueOf(ans);
    }
}
