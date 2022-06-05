package com.utils

import com.model.TreeNode
import spock.lang.Specification

class TreeNodeUtilsTest extends Specification {

    /**
     *       1
     *      / \
     *    2     3
     *     \   /
     *      5 6
    */
    def "GenerateBinaryTreeNode"() {
        given:
        int[] nums = new int[] { 1 , 2 , 3 , Integer.MAX_VALUE , 5 , 6 , Integer.MAX_VALUE }

        when:
        TreeNode root = TreeNodeUtils.generateBinaryTreeNode(nums)

        then:
        assert (root.val == nums[0])
        assert (root.left.val == nums[1])
        assert (root.right.val == nums[2])

        assert (root.left.left == null)
        assert (root.left.right.val == 5)

        assert (root.right.left.val == 6)
        assert (root.right.right == null)
    }
}
