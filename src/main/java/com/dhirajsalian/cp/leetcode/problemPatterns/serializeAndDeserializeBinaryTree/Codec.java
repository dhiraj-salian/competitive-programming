// Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

package com.dhirajsalian.cp.leetcode.problemPatterns.serializeAndDeserializeBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    int start;

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        return res.toString();
    }

    private void serialize(TreeNode root, StringBuilder result) {
        if (root == null) {
            if (result.length() != 0) result.append(",");
            result.append("N");
            return;
        }
        if (result.length() != 0) result.append(",");
        result.append(root.val);
        serialize(root.left, result);
        serialize(root.right, result);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        start = -1;
        String[] nodes = data.split(",");
        return deserialize(nodes);
    }

    private TreeNode deserialize(String[] nodes) {
        start++;
        if (nodes[start].equals("N")) return null;
        TreeNode curr = new TreeNode(Integer.parseInt(nodes[start]));
        curr.left = deserialize(nodes);
        curr.right = deserialize(nodes);
        return curr;
    }
}
