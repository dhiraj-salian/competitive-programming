// Problem: https://leetcode.com/problems/path-sum-ii/

package com.dhirajsalian.cp.leetcode.problemPatterns.pathSum2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        pathSum(root, 0, targetSum, currentPath, allPaths);
        return allPaths;
    }

    private void pathSum(TreeNode root, int sum, int targetSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null) return;
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            currentPath.add(root.val);
            allPaths.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        currentPath.add(root.val);
        pathSum(root.left, sum, targetSum, currentPath, allPaths);
        pathSum(root.right, sum, targetSum, currentPath, allPaths);
        currentPath.remove(currentPath.size() - 1);
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
