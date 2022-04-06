package com.lintcode.binarytree.easy;

import com.model.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.

 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.

 * Example
 * Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
 *
 * A)   3            B)    3
 *     / \                  \
 *    9  20                 20
 *      /  \                / \
 *     15   7              15  7
 * The binary tree A is a height-balanced binary tree, but B is not.
 * @author shubozhang
 */
public class T093BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if ( left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}
