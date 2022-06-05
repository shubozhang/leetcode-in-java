package com.model;

public class TreeNode {
    public Integer val;
    public TreeNode left, right;

    public TreeNode(){}
    public TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}
