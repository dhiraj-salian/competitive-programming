// Problem: https://leetcode.com/problems/subsets-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.subsets2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        subsets(nums, nums.length, currentSet, result);
        return new ArrayList<>(result);
    }

    void subsets(int[] nums, int length, List<Integer> currentSet, List<List<Integer>> result) {
        if (length <= 0) {
            if (!contains(result, currentSet)) result.add(currentSet);
            return;
        }
        List<Integer> dupCurrentSet = new ArrayList<>(currentSet);
        dupCurrentSet.add(0, nums[length - 1]);
        subsets(nums, length - 1, currentSet, result);
        subsets(nums, length - 1, dupCurrentSet, result);
    }

    boolean contains(List<List<Integer>> set, List<Integer> subsetToBeChecked) {
        for (List<Integer> subset : set) {
            if (isSame(subset, subsetToBeChecked)) return true;
        }
        return false;
    }

    boolean isSame(List<Integer> subsetA, List<Integer> subsetB) {
        if (subsetA.size() != subsetB.size()) return false;
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < subsetA.size(); i++) {
            mapA.put(subsetA.get(i), mapA.getOrDefault(subsetA.get(i), 0) + 1);
            mapB.put(subsetB.get(i), mapB.getOrDefault(subsetB.get(i), 0) + 1);
        }
        return mapA.equals(mapB);
    }
}
