// Problem: https://leetcode.com/problems/decode-ways/

package com.dhirajsalian.cp.leetcode.problemPatterns.decodeWays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDecodings(String s) {
        Set<String> valids = new HashSet<>();
        for (int i = 1; i <= 26; i++) valids.add(String.format("%d", i));
        int[] decodings = new int[s.length() + 1];
        decodings[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i - 1 >= 0 && valids.contains(s.substring(i - 1, i)))
                decodings[i] += decodings[i - 1];
            if (i - 2 >= 0 && valids.contains(s.substring(i - 2, i)))
                decodings[i] += decodings[i - 2];
        }
        return decodings[s.length()];
    }
}
