package com.leetcode.binarytree;


import com.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Description
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).)

 The first data is the root node, followed by the value of the left and right son nodes, and "#" indicates that there
 is no child node.
 The number of nodes does not exceed 20.

 Example 1:
 Input:
 tree = {1,2,3}
 Output:
 [[1],[2,3]]
 Explanation:
 1
 / \
 2   3
 it will be serialized {1,2,3}

 Example 2:
 Input:
 tree = {1,#,2,3}
 Output:
 [[1],[2],[3]]
 Explanation:
 1
 \
 2
 /
 3
 it will be serialized {1,#,2,3}

 Challenge
 Challenge 1: Using only 1 queue to implement it.
 Challenge 2: Use BFS algorithm to do it.


 * Breadth First Search (BFS): three methods
 * 1) 2 Queues
 * 2) 1 Queue + Dummy Node
 * 3) 1 Queue (best)
 *
 * Recursive is a depth first search(DFS) concept, so BFS will never use recursive to implement.
 *
 * Every node enters and exits queue once, so time complexity is O(N)
 * @author shubozhang
 */
public class TM069BinaryTreeLevelOrderTraversal {

    // dummy node
    public List<List<Integer>> levelOrderA(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // add null to the end as an indicator
        queue.offer(null);

        ArrayList<Integer> level = new ArrayList<>();
        TreeNode curr;
        while(!queue.isEmpty()) {
            curr = queue.poll();
            // check if level is end
            if (curr == null) {
                if (level.size() == 0){
                    break;
                }
                res.add(level);
                level = new ArrayList<>();
                // add null to the end as an indicator
                queue.offer(null);
                continue;
            }

            level .add(curr.val);
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null){
                queue.offer(curr.right);
            }

        }

        return res;
    }


    // linkedList
    public List<List<Integer>> levelOrderB(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // add root to level 1
        queue.offer(root);

        // loop queue until it is empty
        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();

            // Size must be recorded before the for loop, because queue.size varies in for loop.
            int size = queue.size();

            // loop all nodes in this level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    // double linkedList


}
