package com.leetcode.binarytree.medium

import com.leetcode.binarytree.TM069BinaryTreeLevelOrderTraversal
import spock.lang.Specification

class TM069BinaryTreeLevelOrderTraversalTest extends Specification {

    def "binary tree level order traversal"(){
        expect:
        new TM069BinaryTreeLevelOrderTraversal().levelOrderA()
    }
}
