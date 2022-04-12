package com.lintcode.binarytree.easy

import com.model.TreeNode
import org.junit.Before
import spock.lang.Specification

class T067BinaryTreeInorderTraversalTest extends Specification {
    private TreeNode root
    private List<Integer> expectedList

    /**
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     *
     * Inorder: (left -> root -> right): 4 -> 2 -> 5 -> 1 -> 3
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

        expectedList = [4, 2, 5, 1, 3]
    }

    def "binary tree inorder traversal in non-recursive way"(){
        when:
        List<Integer> resList = T067BinaryTreeInorderTraversal.inorderTraversalA(root)

        then:
        resList == expectedList
    }

    def "binary tree inorder traversal in divide-conquer way"(){
        when:
        List<Integer> resList = T067BinaryTreeInorderTraversal.inorderTraversalB(root)

        then:
        resList == expectedList
    }
}
