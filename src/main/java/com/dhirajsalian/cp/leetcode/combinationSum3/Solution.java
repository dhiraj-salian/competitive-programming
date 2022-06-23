// Problem: https://leetcode.com/problems/combination-sum-iii/

package com.dhirajsalian.cp.leetcode.combinationSum3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum3(int k, int n, int start, List<Integer> currentSet, List<List<Integer>> result) {
        if (n == 0 && currentSet.size() == k) {
            result.add(new ArrayList<>(currentSet));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n >= i) {
                currentSet.add(i);
                combinationSum3(k, n - i, i + 1, currentSet, result);
                currentSet.remove((Integer) i);
            }
        }
    }
}
