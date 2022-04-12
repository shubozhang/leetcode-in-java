package com.lintcode.binarytree.easy;

import com.model.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class T067BinaryTreeInorderTraversal {

    // Version A: Non-Recursion (Recommended)
    // Search left tree, save current nod, and then search right tree.
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public static List<Integer> inorderTraversalA(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    public static List<Integer> inorderTraversalB(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.left.val);
        result.add(node.val);
        result.add(node.right.val);
    }

    public static List<Integer> inorderTraversalC(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<Integer> left = inorderTraversalB(root.left);
        List<Integer> right = inorderTraversalB(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }
}
