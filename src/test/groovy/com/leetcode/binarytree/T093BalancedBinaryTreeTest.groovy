package com.leetcode.binarytree

import com.leetcode.binarytree.easy.T093BalancedBinaryTree
import com.model.TreeNode
import org.junit.Before
import spock.lang.Specification

import static groovy.test.GroovyTestCase.assertEquals

class T093BalancedBinaryTreeTest extends Specification {
    private TreeNode root1
    private TreeNode root2

/**
 * A)   3            B)    3
 *     / \                  \
 *    9  20                 20
 *      /  \                / \
 *     15   7              15  7
 * The binary tree A is a height-balanced binary tree, but B is not.
 * */
    @Before
    void setup() {
        root1 = new TreeNode(3)
        TreeNode node2 = new TreeNode(9)
        TreeNode node3 = new TreeNode(20)
        TreeNode node4 = new TreeNode(15)
        TreeNode node5 = new TreeNode(7)
        root1.left = node2
        root1.right = node3
        node3.left = node4
        node3.right = node5

        root2 = new TreeNode(3)
        TreeNode node23 = new TreeNode(20)
        TreeNode node24 = new TreeNode(15)
        TreeNode node25 = new TreeNode(7)
        root2.right = node23
        node23.left = node24
        node23.right = node25
    }

    def "balanced binary tree"() {
        when:
        boolean res1 = T093BalancedBinaryTree.isBalanced(root1)
        boolean res2 = T093BalancedBinaryTree.isBalanced(root2)

        then:
        assertEquals(true, res1)
        assertEquals(false, res2)

    }
}
