// Problem: https://leetcode.com/problems/maximum-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.maximumBinaryTree;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (end < start) return null;
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        return new TreeNode(nums[max],
                constructMaximumBinaryTree(nums, start, max - 1),
                constructMaximumBinaryTree(nums, max + 1, end));
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
