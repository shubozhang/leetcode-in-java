# 算法


## 算法总结
| 算法/数据结构    | 大公司考察频率 | 其他公司考察频率 | 难度  | 建议刷题数 | 性价比 |
|------------|---------|----------|-----|-------|-----|
| 字符串 / 模拟法  | 高       | 高        | 低   | 20~50 | 中   |
| 排序算法       | 中       | 高        | 中   | 2~5   | 高   |
| 二分法        | 高       | 高        | 中   | 10~20 | 高   |
| 二叉树/链表     | 高       | 高        | 低   | 30~50 | 高   |
| 递归 / DFS   | 高       | 高        | 高   | 20~40 | 中   |
| BFS / 拓扑排序 | 高       | 高        | 中   | 5-10  | 超高  |
| 堆(优先队列)    | 低       | 低        | 中   | 5~10  | 中   |
| 哈希表        | 高       | 高        | 中   | 10~30 | 高   |
| 双指针        | 高       | 高        | 中   | 10~20 | 高   |
| 动态规划       | 中       | 低        | 高   | 40~60 | 低   |
| 字典树 / 并查集  | 中       | 低        | 低   | 2~5   | 高   |


## Complexcity
1. 时间复杂度 - 核心考察点 
2. 空间复杂度 - 次要考察点 
3. 编程复杂度 - 能看得懂 
4. 思维复杂度 - 能想得出

* Time Complexcity
  * Polynomial(P probelm): `O(n), O(n^2), O(n^3) O(n + m), O(√n), O(1) O(logn), O(nlogn)`
  * Nondeterministic Polynomial(NP probelm): `O(2^n), O(n^n), O(n!)`

* 只考虑最高项 
  * O(2^N+N^2) = O(2^N) 
  * O(N^3+1000N^2) = O(N^3)

* 不考虑常数项和系数 
  * O(100N+1000) = O(N) 
  * O(logN) = O(log(N^2)) = O(log4(N))


时间复杂度为 O(N) 的算法有哪些? 
双指针算法、打擂台算法 单调栈算法、单调队列算法 等等



## Double pointers

![Alt text](images/double-pointers.png?raw=true "Double Pointers")

三种双指针算法 
相向双指针(判断回文串) 
背向双指针(最长回文串) 
同向双指针


相向双指针的分类 
* Reverse 型
  * 翻转字符串 
  * 判断回文串
  
* Two Sum 型 
  * 两数之和
  * 三数之和 

* Partition 型
  * 快速排序 
  * 颜色排序

Example:  Valid Palindrome
https://www.lintcode.com/problem/valid-palindrome/

Valid Palindrome II
https://www.lintcode.com/problem/valid-palindrome-ii/

Two Sum
https://www.lintcode.com/problem/two-sum/


哈希表的实现方法 
时间复杂度 O(n) 
空间复杂度 O(n)


排序 + 双指针 
时间复杂度 O(nlogn) 
空间复杂度 O(1) 
注意空间复杂度一般指额外空间复杂度 即不包含输入和输出

面试追问 Follow Up
Follow Up 1:
- 如果输入数据已经排序，哪个算法更好? 
- Follow Up 2:
- 如果需要返回所找的两个数在数组中的下标，哪个算法更好?
 
 