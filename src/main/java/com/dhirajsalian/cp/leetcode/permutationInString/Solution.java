// Problem: https://leetcode.com/problems/permutation-in-string/

package com.dhirajsalian.cp.leetcode.permutationInString;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Alpha = new int[26], s2Alpha = new int[26];
        for (int i = 0; i < s1.length(); i++) s1Alpha[s1.charAt(i) - 'a']++;
        int start = 0, end = 0;
        while (end < s2.length()) {
            s2Alpha[s2.charAt(end) - 'a']++;
            while (start <= end && !isMovingTowardsSame(s1Alpha, s2Alpha)) {
                s2Alpha[s2.charAt(start) - 'a']--;
                start++;
            }
            if (isSame(s1Alpha, s2Alpha)) return true;
            end++;
        }
        return false;
    }

    private boolean isSame(int[] s1Alpha, int[] s2Alpha) {
        for (int i = 0; i < 26; i++) {
            if (s2Alpha[i] != s1Alpha[i]) return false;
        }
        return true;
    }

    private boolean isMovingTowardsSame(int[] s1Alpha, int[] s2Alpha) {
        for (int i = 0; i < 26; i++) {
            if (s2Alpha[i] > s1Alpha[i]) return false;
        }
        return true;
    }
}
