package com.dhirajsalian.cp.leetcode.problemPatterns.substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        int singleWordLength = words[0].length();
        int combinationLength = singleWordLength * words.length;
        int start = 0, end = 0;
        Map<String, Integer> stringWordMap = new HashMap<>();
        while (end < s.length()) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < singleWordLength && end + i < s.length(); i++) str.append(s.charAt(end + i));
            if (str.length() != singleWordLength) break;
            if (stringWordMap.getOrDefault(str.toString(), 0) + 1 > wordMap.getOrDefault(str.toString(), 0)) {
                start++;
                end=start;
                stringWordMap.clear();
            } else {
                stringWordMap.put(str.toString(), stringWordMap.getOrDefault(str.toString(), 0) + 1);
                end += singleWordLength;
            }
            if (end - start == combinationLength) {
                if (stringWordMap.equals(wordMap)) result.add(start);
                str = new StringBuilder();
                for (int i = 0; i < singleWordLength; i++) str.append(s.charAt(start + i));
                stringWordMap.put(str.toString(), stringWordMap.getOrDefault(str.toString(), 0) - 1);
                if (stringWordMap.get(str.toString()) <= 0) stringWordMap.remove(str.toString());
                start++;
                end = start;
                stringWordMap.clear();
            }
        }
        return result;
    }
}