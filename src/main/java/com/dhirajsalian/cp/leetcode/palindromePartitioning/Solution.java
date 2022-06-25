// Problem: https://leetcode.com/problems/palindrome-partitioning/

package com.dhirajsalian.cp.leetcode.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String currStr = s.substring(start, i + 1);
            if (isPalindrome(currStr)) {
                current.add(currStr);
                partition(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
