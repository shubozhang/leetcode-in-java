package com.lintcode.binarytree.easy;

import com.model.TreeNode;

import java.util.ArrayList;

/**
 * Created by Shubo on 9/3/2016.
 */
public class T068BinaryTreePostorderTraversal {


    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);

        return result;
    }
}
