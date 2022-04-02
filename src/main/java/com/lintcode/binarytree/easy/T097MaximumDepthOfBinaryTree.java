package com.lintcode.binarytree.easy;

import com.model.TreeNode;

/**
 * Created by Shubo on 9/3/2016.
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
