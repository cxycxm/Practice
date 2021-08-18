package com.leetcode.tree;

import sun.reflect.generics.tree.Tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode init(){
        TreeNode left = new TreeNode(null, null, 10);
        TreeNode right = new TreeNode(null, null, 8);
        TreeNode tree1 = new TreeNode(left, right, 6);
        return tree1;
    }
}
