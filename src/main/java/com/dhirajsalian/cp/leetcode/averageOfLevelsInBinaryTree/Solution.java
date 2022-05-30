// Problem: https://leetcode.com/problems/average-of-levels-in-binary-tree/

package com.dhirajsalian.cp.leetcode.averageOfLevelsInBinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        double count = 0;
        double sum = 0;
        List<Double> res = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                if (count == 0) break;
                res.add(sum / count);
                count = 0;
                sum = 0;
                q.add(null);
            } else {
                count++;
                sum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right);
            }
        }
        return res;
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