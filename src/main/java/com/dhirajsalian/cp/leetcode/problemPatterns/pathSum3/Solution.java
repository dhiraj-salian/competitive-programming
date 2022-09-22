// Problem: https://leetcode.com/problems/path-sum-iii/

package com.dhirajsalian.cp.leetcode.problemPatterns.pathSum3;

import java.util.HashMap;
import java.util.Map;

class Solution {

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sumCount = new HashMap<>();
        sumCount.put(0L, 1);
        pathSum(root, sumCount, 0, targetSum);
        return count;
    }

    private void pathSum(TreeNode root, Map<Long, Integer> sumCount, long currentSum, int targetSum) {
        if (root == null) return;
        currentSum += root.val;
        count += sumCount.getOrDefault(currentSum - targetSum, 0);
        sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);
        pathSum(root.left, sumCount, currentSum, targetSum);
        pathSum(root.right, sumCount, currentSum, targetSum);
        sumCount.put(currentSum, sumCount.get(currentSum) - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
