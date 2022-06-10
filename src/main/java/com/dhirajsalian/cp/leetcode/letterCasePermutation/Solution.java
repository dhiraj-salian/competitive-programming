// Problem: https://leetcode.com/problems/letter-case-permutation/

package com.dhirajsalian.cp.leetcode.letterCasePermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> letterCasePermutation(String s) {
        Set<String> result = new HashSet<>();
        letterCasePermutation(new StringBuilder(s), 0, result);
        return new ArrayList<>(result);
    }

    private void letterCasePermutation(StringBuilder s, int index, Set<String> set) {
        if (index == s.length()) {
            set.add(s.toString());
            return;
        }
        char current = s.charAt(index);
        letterCasePermutation(s, index + 1, set);
        if (!Character.isDigit(current) && Character.isUpperCase(current)) {
            s.setCharAt(index, Character.toLowerCase(current));
            letterCasePermutation(s, index + 1, set);
            s.setCharAt(index, current);
        }
        if (!Character.isDigit(current) && Character.isLowerCase(current)) {
            s.setCharAt(index, Character.toUpperCase(current));
            letterCasePermutation(s, index + 1, set);
            s.setCharAt(index, current);
        }
    }
}
