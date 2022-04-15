package com.leetcode.binarytree.easy;

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
public class T066BinaryTreePreorderTraversal {

     // Version A: Non-Recursion (Recommended)
    public static List<Integer> preorderTraversalA(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preorder = new ArrayList<>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return preorder;

    }


    // Version B: Traversal
    public static List<Integer> preorderTraversalB(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private static void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }


    // Version C: Divide and Conquer
    // This version can be used in multithreading scenario, but Version B can't.
    public static List<Integer> preorderTraversalC(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        // Can be calculated in Thread A
        List<Integer> left = preorderTraversalC(root.left);
        // Can be calculated in Thread B
        List<Integer> right = preorderTraversalC(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
