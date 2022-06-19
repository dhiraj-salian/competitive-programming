// Problem: https://leetcode.com/problems/permutations/

package com.dhirajsalian.cp.leetcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length - 1, result);
        return result;
    }

    private void permute(int[] nums, int l, int r, List<List<Integer>> result) {
        if (l == r) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(nums, i, l);
            permute(nums, l+1, r, result);
            swap(nums, l, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
