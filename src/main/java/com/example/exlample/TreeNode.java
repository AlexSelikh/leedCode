package com.example.exlample;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }

    public int sumOfLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = sumOfLeafNodes(root.left);
        int rightSum = sumOfLeafNodes(root.right);
        return leftSum + rightSum;
    }
}