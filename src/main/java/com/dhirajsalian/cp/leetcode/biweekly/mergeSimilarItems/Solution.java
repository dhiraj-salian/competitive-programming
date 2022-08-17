// Problem: https://leetcode.com/contest/biweekly-contest-84/problems/merge-similar-items/

package com.dhirajsalian.cp.leetcode.biweekly.mergeSimilarItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] weightSums = new int[1001];
        for (int i = 0; i < items1.length; i++) {
            weightSums[items1[i][0]] += items1[i][1];
        }
        for (int i = 0; i < items2.length; i++) {
            weightSums[items2[i][0]] += items2[i][1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (weightSums[i] > 0) {
                ans.add(Arrays.asList(i, weightSums[i]));
            }
        }
        return ans;
    }
}
