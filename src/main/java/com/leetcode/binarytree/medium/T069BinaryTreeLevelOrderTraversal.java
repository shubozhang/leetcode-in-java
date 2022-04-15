package com.leetcode.binarytree.medium;


import com.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
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
public class T069BinaryTreeLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();

            // Size must be recorded before the for loop, because queue.size varies in for loop.
            int size = queue.size();
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
            result.add(level);
        }

        return result;
    }
}
