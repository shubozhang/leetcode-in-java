# Breadth First Search(BFS)

## 应用场景

* 分层遍历
  * 一层一层的遍历一个图、树、矩阵
  * 简单图最短路径
    * 简单图的定义是，图中所有的边长都一样
* 连通块问题
  * 通过图中一个点找到其他所有连通的点
  * 找到所有方案问题的一种非递归实现方式
* 拓扑排序(实现容易度远超过 DFS)
  * 是否有拓扑序
  * 是否有唯一拓扑序
  * 求任意拓扑序
  * 求字典序的最小拓扑序

## 定义

* Graph VS Tree VS Binary Tree

![Alt text](../images/bfs/graph-tree-binarytree.png?raw=true "graph-tree-binarytree")

* 什么是简单图
  * 没有方向 (undirected)
  * 没有权重 (unweighted)
  * 两点之间最多只有一条边 (no multiple edges)
  * 一个点没有一条边直接连着自己 (no graph loops，这里的graph loop指的是自己直接指向自己的loop)

## 实现方法

* 单队列 (recommended)
* DummyNode
* 双队列

Example: [BinaryTree Level Order Traversal](/src/main/java/com/leetcode/binarytree/TM069BinaryTreeLevelOrderTraversal.java)

## [BFS Template](/src/main/java/com/leetcode/bfs/BFSTemplate.java)

N个点，M条边，图上BFS时间复杂度 = O(N + M)，说是O(M)问题也不大，因为M一般都比N大 M最大是 O(N^2) 的级别(任意两个点之间都有边)， 所以最坏情况可能是 O(N^2)

## Example: [Clone Graph](/src/main/java/com/leetcode/bfs/M133CloneGraph.java)


## Example: [Word Ladder](/src/main/java/com/leetcode/bfs/H127WordLadder.java)

## Example: [Number of Island](/src/main/java/com/leetcode/bfs/M200NumberOfIslands.java)

## Example: [Minimum Knight Moves](/src/main/java/com/leetcode/bfs/M1197MinKnightMoves.java)


## Topological Sorting
图 + 有依赖关系/有向 + 无环 => 拓扑排序

入度(In-degree):有向图(Directed Graph)中指向当前节点的点的个数(或指向当前节点的边的条数)

算法描述:
1. 统计每个点的入度
2. 将每个入度为 0 的点放入队列(Queue)中作为起始节点
3. 不断从队列中拿出一个点，去掉这个点的所有连边(指向其他点的边)，其他点的相应的入度 - 1 
4. 一旦发现新的入度为 0 的点，丢回队列中
   
拓扑排序并不是传统的排序算法, 一个图可能存在多个拓扑序(Topological Order)，也可能不存在任何拓扑序

拓扑排序的四种不同问法
* 求任意一个拓扑排序
* 问是否存在拓扑排序
* 求是否存在且仅存在一个拓扑排序
* 求字典序最小的拓扑排序

[Course Schedule II](/src/main/java/com/leetcode/bfs/M210CourseScheduleII.java)