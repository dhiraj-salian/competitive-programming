// Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

package com.dhirajsalian.cp.leetcode.letterCombinationOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        String[][] keys = new String[][]{{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
                {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        List<String> results = new ArrayList<>();
        letterCombinations(digits, results, new StringBuilder(), keys);
        return results;
    }

    private void letterCombinations(String digits, List<String> results, StringBuilder currResult, String[][] keys) {
        if (digits.length() == currResult.length()) {
            results.add(currResult.toString());
            return;
        }
        int currKey = digits.charAt(currResult.length()) - '0';
        for (String alpha : keys[currKey]) {
            currResult.append(alpha);
            letterCombinations(digits, results, currResult, keys);
            currResult.deleteCharAt(currResult.length() - 1);
        }
    }
}
