// Problem: https://leetcode.com/problems/word-break/

package com.dhirajsalian.cp.leetcode.wordBreak;

import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] wordBreaks = new boolean[s.length() + 1];
        wordBreaks[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (s.substring(0, i).endsWith(word))
                    wordBreaks[i] |= wordBreaks[i - word.length()];
            }
        }
        return wordBreaks[s.length() + 1];
    }

}
