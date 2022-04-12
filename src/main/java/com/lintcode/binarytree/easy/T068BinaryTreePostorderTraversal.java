package com.lintcode.binarytree.easy;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * pre-order (root -> left -> right): 1 -> 2 -> 4 -> 5 -> 3
 * in-order (left -> root -> right): 4 -> 2 -> 5 -> 1 -> 3
 * post-order (left -> right -> root): 4 -> 5 -> 2 -> 3 -> 1
 *
 * @author shubozhang
 */
public class T068BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);

        return result;
    }
}
