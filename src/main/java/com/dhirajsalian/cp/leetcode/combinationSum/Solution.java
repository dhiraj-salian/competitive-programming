// Problem: https://leetcode.com/problems/combination-sum/

package com.dhirajsalian.cp.leetcode.combinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, candidates.length, new ArrayList<>(), result);
        return result;
    }

    public void combinationSum(int[] candidates, int target, int n, List<Integer> currentSet, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentSet));
            return;
        }
        if (target < 0 || n <= 0) {
            return;
        }
        combinationSum(candidates, target, n - 1, currentSet, result);
        currentSet.add(candidates[n - 1]);
        combinationSum(candidates, target - candidates[n - 1], n, currentSet, result);
        currentSet.remove((Integer) candidates[n - 1]);
    }
}
