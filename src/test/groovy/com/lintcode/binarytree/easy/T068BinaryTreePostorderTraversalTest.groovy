package com.lintcode.binarytree.easy

import com.model.TreeNode
import org.junit.Before
import spock.lang.Specification

class T068BinaryTreePostorderTraversalTest extends Specification {
    private TreeNode root

    /**
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     *
     * Postorder: (left -> right -> root): 4 -> 5 -> 2 -> 3 -> 1
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

    def "binary tree postorder traversal in divide-conquer way"(){
        when:
        List<Integer> resList = T068BinaryTreePostorderTraversal.postorderTraversal(root)

        then:
        resList == [4, 5, 2, 3, 1]
    }
}

