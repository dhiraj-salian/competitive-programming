// Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

package com.dhirajsalian.cp.leetcode.problemPatterns.constructBinaryTreeFromPreorderAndInorderTraversal;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int root = preorder[preStart];
        int inRootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) if (inorder[i] == root) inRootIndex = i;
        return new TreeNode(root,
                buildTree(preorder, inorder, preStart + 1, preStart + inRootIndex - inStart, inStart, inRootIndex - 1),
                buildTree(preorder, inorder, preStart + inRootIndex - inStart + 1, preEnd, inRootIndex + 1, inEnd));
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
