// Problem:  https://leetcode.com/problems/maximum-width-of-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.maximumWidthOfBinaryTree;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return widthOfBinaryTree(root, 0, 1, new HashMap<>(), new HashMap<>());
    }

    public int widthOfBinaryTree(TreeNode root, int level, int index, Map<Integer, Integer> levelMinIndex,
                                 Map<Integer, Integer> levelMaxIndex) {
        if (root == null) return 0;
        levelMinIndex.put(level, Math.min(levelMinIndex.getOrDefault(level, index), index));
        levelMaxIndex.put(level, Math.max(levelMaxIndex.getOrDefault(level, index), index));
        int maxLevelWidthBelowCurrentNode = Math.max(
                widthOfBinaryTree(root.left, level + 1, 2 * index + 1, levelMinIndex, levelMaxIndex),
                widthOfBinaryTree(root.right, level + 1, 2 * index + 2, levelMinIndex, levelMaxIndex));
        return Math.max(maxLevelWidthBelowCurrentNode, levelMaxIndex.get(level) - levelMinIndex.get(level) + 1);
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