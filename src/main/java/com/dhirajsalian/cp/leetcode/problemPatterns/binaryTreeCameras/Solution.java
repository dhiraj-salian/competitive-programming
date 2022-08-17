// Problems: https://leetcode.com/problems/binary-tree-cameras/

package com.dhirajsalian.cp.leetcode.problemPatterns.binaryTreeCameras;

class Solution {
    int cameraCount = 0;

    public int minCameraCover(TreeNode root) {
        int rs = solve(root);
        if (rs == 0)
            return cameraCount + 1;
        return cameraCount;
    }

    private int solve(TreeNode root) {
        if (root == null) return 2;

        int l = solve(root.left);
        int r = solve(root.right);

        if (l == 0 || r == 0) {
            cameraCount++;
            return 1;
        } else if (l == 1 || r == 1) {
            return 2;
        } else
            return 0;
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