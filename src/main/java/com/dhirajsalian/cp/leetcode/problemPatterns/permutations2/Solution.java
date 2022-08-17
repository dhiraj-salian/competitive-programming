// Problem: https://leetcode.com/problems/permutations-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums, 0, nums.length - 1, result);
        return result;
    }

    private void permuteUnique(int[] nums, int l, int r, List<List<Integer>> result) {
        if (l == r && !alreadyContains(result, nums)) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(nums, i, l);
            permuteUnique(nums, l + 1, r, result);
            swap(nums, l, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private boolean alreadyContains(List<List<Integer>> result, int[] nums) {
        for (List<Integer> res : result) {
            if (isSame(res, nums)) return true;
        }
        return false;
    }

    private boolean isSame(List<Integer> res, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (res.get(i) != nums[i]) return false;
        }
        return true;
    }
}
