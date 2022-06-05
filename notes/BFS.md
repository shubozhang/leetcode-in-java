# Breadth First Search(BFS)

应用场景

* 分层遍历
  * 一层一层的遍历一个图、树、矩阵
  * 简单图最短路径
    * 简单图的定义是，图中所有的边长都一样
* 连通块问题
  * 通过图中一个点找到其他所有连通的点
  * 找到所有方案问题的一种非递归实现方式
* 拓扑排序
  * 实现容易度远超过 DFS

实现方法

* 单队列 (recommended)
* DummyNode
* 双队列

Example: TM069BinaryTreeLevelOrderTraversal

## [BFS Template](/src/main/java/com/leetcode/bfs/BFSTemplate.java)

N个点，M条边，图上BFS时间复杂度 = O(N + M)，说是O(M)问题也不大，因为M一般都比N大 M最大是 O(N^2) 的级别(任意两个点之间都有边)， 所以最坏情况可能是 O(N^2)
