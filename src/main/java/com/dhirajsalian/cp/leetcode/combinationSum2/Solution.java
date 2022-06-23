// Problem: https://leetcode.com/problems/combination-sum-ii/

package com.dhirajsalian.cp.leetcode.combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum2(int[] candidates, int target, int start, List<Integer> currentSet, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentSet));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            else if (target < candidates[i]) return;
            else {
                currentSet.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, currentSet, result);
                currentSet.remove((Integer) candidates[i]);
            }
        }
    }
}
