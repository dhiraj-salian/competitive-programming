//Problem: https://leetcode.com/problems/minimum-window-substring/

package com.dhirajsalian.cp.leetcode.minimumWindowSubstring;

class Solution {
    public String minWindow(String s, String t) {
        int[] tChars = new int[256], sChars = new int[256];
        for (int i = 0; i < t.length(); i++) tChars[t.charAt(i)]++;
        int start = 0, end = 0;
        String res = "";
        StringBuilder str = new StringBuilder();
        int minCount = s.length() + 1;
        while (end < s.length()) {
            sChars[s.charAt(end)]++;
            str.append(s.charAt(end));
            while (start <= end && isIncluded(sChars, tChars)) {
                if (end - start + 1 < minCount) {
                    minCount = end - start + 1;
                    res = str.toString();
                }
                sChars[s.charAt(start)]--;
                str.deleteCharAt(0);
                start++;
            }
            end++;
        }
        return res;
    }

    private boolean isIncluded(int[] sChars, int[] tChars) {
        for (int i = 0; i < 256; i++) {
            if (tChars[i] > sChars[i]) return false;
        }
        return true;
    }
}
