package com.lintcode.binarytree.easy;

import com.model.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *     A
 *    / \
 *   B   C
 *  / \
 * 4   5
 *
 * pre-order A B C
 * in-order B A C
 * post-order B C A
 *
 *
 * *    1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * */
public class T066BinaryTreePreorderTraversal {


    /*
    * Version A: Non-Recursion (Recommended)
    * */
    public List<Integer> preorderTraversalA(TreeNode root) {
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


    /*
    * Version B: Traversal
    * */
    public ArrayList<Integer> preorderTraversalB(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }

    /*
    * Version C: Divide and Conquer
    * This version can be used in multithreading scenario, but Version B can't.
    * */

    public ArrayList<Integer> preorderTraversalC(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = preorderTraversalC(root.left); // Can be calculated in Thread A
        ArrayList<Integer> right = preorderTraversalC(root.right); // Can be calculated in Thread B

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
