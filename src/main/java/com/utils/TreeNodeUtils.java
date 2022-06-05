package com.utils;

import com.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtils {

    public static TreeNode generateBinaryTreeNode(int[] nums){
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr;
        int i = 1;
        while (i < nums.length) {
            curr = queue.poll();
            if (nums[i] != Integer.MAX_VALUE) {
                TreeNode left = new TreeNode(nums[i]);
                curr.left = left;
                queue.offer(left);
            }
            i++;

            if (i < nums.length && nums[i] != Integer.MAX_VALUE) {
                TreeNode right = new TreeNode(nums[i]);
                curr.right = right;
                queue.offer(right);
            }
            i++;
        }


        return root;
    }
}
