package com.leetcode.binarytree

import com.leetcode.binarytree.easy.T066BinaryTreePreorderTraversal
import com.model.TreeNode
import org.junit.Before
import spock.lang.Specification

class T066BinaryTreePreorderTraversalTest extends Specification{
    private TreeNode root;

    /**
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     *
     * Preorder (root -> left -> right): 1, 2, 4, 5, 3
    */
    @Before
    void setup() {
        root = new TreeNode(1)
        TreeNode node2 = new TreeNode(2)
        TreeNode node3 = new TreeNode(3)
        TreeNode node4 = new TreeNode(4)
        TreeNode node5 = new TreeNode(5)
        root.left = node2
        root.right = node3
        node2.left = node4
        node2.right = node5
    }

    def "binary tree preorder traversal in non-recursive way"(){
        when:
        List<Integer> resList = T066BinaryTreePreorderTraversal.preorderTraversalA(root)

        then:
        resList == [1, 2, 4, 5, 3]
    }
    def "binary tree preorder traversal in recursive way"(){
        when:
        List<Integer> resList = T066BinaryTreePreorderTraversal.preorderTraversalB(root)

        then:
        resList == [1, 2, 4, 5, 3]
    }
    def "binary tree preorder traversal in divide and conquer "(){
        when:
        List<Integer> resList = T066BinaryTreePreorderTraversal.preorderTraversalC(root)

        then:
        resList == [1, 2, 4, 5, 3]
    }
}
