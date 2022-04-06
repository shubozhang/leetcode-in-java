package com.lintcode.binarytree.easy;

import com.model.TreeNode;

/**
 *
 * @author Shubo
 */
public class T097MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max( left, right) + 1;
    }
}
