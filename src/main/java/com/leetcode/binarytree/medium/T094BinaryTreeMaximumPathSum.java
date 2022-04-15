package com.leetcode.binarytree.medium;

import com.model.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
  * The path may start and end at any node in the tree.
  * Example
  * Given the below binary tree:
  *   1
  *  / \
  * 2   3
  * return 6.
 * @author shubozhang
 */
public class T094BinaryTreeMaximumPathSum {

    public int maxPahtSum(TreeNode root) {
        ResultType resultType = helper(root);
        return resultType.maxPath;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }

        //Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        //Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0); // if path value < 0, we drop the single path. single path can contain 0 element.

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath,left.singlePath +  right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    private class ResultType {
        int singlePath;
        int maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }


}
