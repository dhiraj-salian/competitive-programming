// Problem: https://leetcode.com/problems/longest-word-in-dictionary/

package com.dhirajsalian.cp.leetcode.longestWordInDictonary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestWord(String[] words) {
        int longestWordLength = 0;
        String longestWord = "";
        Set<String> wordPrefixes = new HashSet<>();
        Arrays.sort(words);
        for(String word: words) {
            if(word.length()==1 || wordPrefixes.contains(word.substring(0,word.length()-1))) {
                wordPrefixes.add(word);
                if(word.length()>longestWordLength) {
                    longestWord = word;
                    longestWordLength = word.length();
                }
            }
        }
        return longestWord;
    }
}
