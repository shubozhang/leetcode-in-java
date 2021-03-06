# LeetCode in Java

## Introduction
### Complexity Analysis
1. 时间复杂度 - 核心考察点
2. 空间复杂度 - 次要考察点
3. 编程复杂度 - 能看得懂
4. 思维复杂度 - 能想得出

* Time Complexcity
  * Polynomial(P probelm): `O(n), O(n^2), O(n^3) O(n + m), O(√n), O(1) O(logn), O(nlogn)`
  * Nondeterministic Polynomial(NP probelm): `O(2^n), O(n^n), O(n!)`

* 只考虑最高项
  * `O(2^N+N^2) = O(2^N)`
  * `O(N^3+1000N^2) = O(N^3)`

* 不考虑常数项和系数
  * `O(100N+1000) = O(N)`
  * `O(logN) = O(log(N^2)) = O(log4(N))`

### Big O Complexity
Big O notation is used to describe the complexity of an algorithm when measuring its efficiency, which in this case
means how well the algorithm scales with the size of the dataset.

* Other notations:
  * Big Omega: lower bound
  * Big Theta: tight bound
  * Big O: upper bound

```
T(n) = O(f(n))
```

* O(1) - Constant Complexity
    ```
    int x = 0;
    int y = 1;
    int temp = x;
    x = y;
    y = temp;
    ```
  No loop or recursive calculation.

* O(n) - Linear Complexity
    ```
    for (int i = 1; i <= n; i++) {
        x++;
    }
    ```
  * `int i = 1` takes 1 time unit
  * `i <= n, i++, x++` each takes n time unit
  * total T(1+3n) &asymp;T(n)

* O(logN) - Logarithmic Complexity
    ```
    int i = 1;
    while(i < n) {
        i = i * 2;
    }
    ```

* O(nlogN) - Linearithmic Complexity
    ```
    for(int i = 0; i <= n: i++) {
        int x = 1;
        while(x < n) {
            x = x * 2;
        }
    }
    ```
  * It loops `n` times `T(logN)`, so total is `T(nlogN)`

* O(n²) - Quadratic Complexity

```
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        x++;
    }
}
```

* O(n3) - Cubic Complexity:
  Similar to O(n2), but consider that example with an added nested loop.

* O(2n) - Exponential Complexity:
  The algorithm takes twice as long for every new element added, so even small increases in n dramatically
* increase the running time.

#### Space Complexity
Space complexity represents the amount of memory one program uses in order to achieve its execution.

* O(1): space cost won't change when variables `x, y` vary
    ```
    int x = 0;
    int y = 0;
    x++;
    y++;
    ```
* O(n): space cost will increase along with variable `n`
    ```
    int[] newArray = new int[n];
    for (int i = 0; i < n; i++) {
        newArray[i] = i;
    }
    ```
* O(n²): 2D array

#### Sorting Algorithms

| Algorithm      | Best       | Worst       | Average     |
|----------------|------------|-------------|-------------|
| Selection Sort | Ω(n^2)     | θ(n^2)      | O(n^2)      |
| Bubble Sort    | Ω(n)       | θ(n^2)      | O(n^2)      |
| Insertion Sort | Ω(n)       | θ(n^2)      | O(n^2)      |
| Heap Sort      | Ω(nlog(n)) | θ(n log(n)) | O(n log(n)) |
| Quick Sort     | Ω(nlog(n)) | θ(n log(n)) | O(n^2)      |
| Merge Sort     | Ω(nlog(n)) | θ(n log(n)) | O(n log(n)) | 
| Bucket Sort    | Ω(n+k)     | θ(n+k)      | O(n^2)      |	               
| Radix Sort     | Ω(nk)      | θ(nk)       | O(nk)       |                 
| Count Sort     | Ω(n+k)     | θ(n+k)      | O(n+k)      |                





#### 常见算法 Big O
| O(N)                   | O(NlogN) | O(N^2) | O(2^N) |
|------------------------|----------|--------|--------|
| 双指针算法 (high frequency) |          |        | DP     |
| 打擂台算法 (high frequency) |          |        |        |
| 单调栈算法                  |          |        |        |
| 单调队列算法                 |          |        |        |




#### Problems Frequency
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



## Double pointers

![Alt text](../images/double-pointers.png?raw=true "Double Pointers")

### 相向双指针的分类 
* Reverse 型
  * 翻转字符串 
  * [Valid Palindrome](/com/leetcode/doublepointers/E125ValidatePalindrome.java)
  * [Valid Palindrome II](/src/main/java/com/leetcode/doublepointers/E680ValidPalindromeII.java)
  
* Two Sum 型 
  * [Two Sum](/com/leetcode/doublepointers/E001TwoSum.java)
  * [Three Sum](/com/leetcode/doublepointers/M015ThreeSum.java) 

* Partition 型
  * [Quick Sort](/com/sorting/QuickSort.java) 
  * [Sort Colors](/com/leetcode/doublepointers/M075SortColors.java)
  

  
* 哈希表的实现方法 
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





## Quick Sort And Merge Sort
### Quick Sort
[Quick Sort](../src/main/java/com/sorting/QuickSort.java)
* O(1) space cost (in place swap)
* Instable sorting: can't guarantee the origin order if two elements are equal.
* Time complexity (in average): O(NlogN)
* Worst scenario: O(N^2)

### Merge Sort
[Merge Sort](../src/main/java/com/sorting/MergeSort.java)
* Cost extra O(N) space
* Stable sorting: does not change the order if two elements are equal
* Time complexity: O(NlogN)





有没有其他方法一边增加数一边保持数组有序?

方法
分析
Binary Search + List/Array Insert
用BinarySearch可以通过O(logN)在有序数列中找到新数据插入位置 但是在List/Array(连续空间)中插入新元素会导致元素整体后移，需要O(N) 比如，[1,3,4,5,6,7] 中插入 2
Binary Search + Linked List Insert
Binary Search 是基于数组的算法，不是基于链表的算法 数组 Array - 连续型存储 - 支持 O(1) Index Access
链表 Linked List - 离散型存储 – 不支持 O(1) Index Access，只支持 O(n) Index Access 链表中插入一个元素虽然是 O(1) 的，但是找到插入位置需要花 O(n) 的时间 (不能用二分)
Heap (ProrityQueue)
堆是一个树状结构，堆内部的元素组织顺序不是有序的
堆可以实现 O(logN) 的插入
但是双指针Two Sum的方法是基于一个 Sorted Array进行的，不能在堆中完成
TreeMap (红黑树)
TreeMap是一个树状结构 (O(N) 时间中序遍历之后可以得到一个有序数组) 双指针Two Sum的方法是基于一个 Sorted Array进行的，不能在TreeMap中完成 TreeMap 可以实现 O(logN) add 和 O(N) find
不如 HashMap (O(1) add 和 O(N) 的 find) 的方法好






## Binary Search

When to use binary search (`O(log(n))`):
* sorted array
* find a better performance than `O(n)`

















## Binary Tree
* BFS in Binary Tree
* Binary Searh Tree
  * Insert / Remove / Find / Validate

* Traverse a tree by order:
  * Preorder: root -> left -> right
  * Inorder: left -> root -> right
  * Postorder: left -> right -> root

* Traverse a try by algorithms
  * Non-recursion
  * Traverse (recursion)
  * Divide Conquer (recursion)

1. Define recursive
2. Define exit
3. Convert it small chunk of problem

## Linked List

* L092 Reverse Linked List II

![Alt text](../images/L092.png?raw=true "Reverse Linked List II")



## Array

* Four Sum
  sort -> O(n^2) => O(n)
  3sum O(n^3) => O(n^2)
  4sum O(n^4) => O(n^3)


## Data Structure

Queue
Operations
● O(1) Push
● O(1) Pop
● O(1) Top
Core data structure for BFS!


Stack
Operations:
● O(1) Push
● O(1) Pop
● O(1) Top

// ascending / descending stack
O(n^2) => O(N)

DP: O(2^n) => O(n^2)
O(nlogn):
1. sorting and then binary search
2. use a O(logn) data structure: like heap / priority queue

Hash
Operations
● O(1) Insert
● O(1) Delete
● O(1) Find
Hash Function Collision
● Open Hashing (LinkedList)
● Closed Hashing (ArrayList)


Java
● HashTable ● HashSet
● HashMap
Which on is Thread Safe?



Heap
Operations
● O(log N) Add
● O(log N) Remove
● O(1) Min/Max



## BFS (Breadth First Search)


![Alt text](../images/BFS.png?raw=true "Breadth First Search")


BFS in Matrix

矩阵 vs 图
图 Graph
N个点，M条边
M最大是 O(N^2) 的级别 图上BFS时间复杂度 = O(N + M)
• 说是O(M)问题也不大，因为M一般都比N大
所以最坏情况可能是 O(N^2)
矩阵 Matrix
R行C列
R*C个点，R*C*2 条边(每个点上下左右4条边，每条边被2个点共享)。 矩阵中BFS时间复杂度 = O(R * C)



拓扑排序 Topological Sorting

拓扑排序 Topological Sorting 入度(In-degree):
有向图(Directed Graph)中指向当前节点的点的个数(或指向当前节点的边的条数)
算法描述:
1. 统计每个点的入度
2. 将每个入度为 0 的点放入队列(Queue)中作为起始节点
3. 不断从队列中拿出一个点，去掉这个点的所有连边(指向其他点的边)，其他点的相应的入度 - 1 4. 一旦发现新的入度为 0 的点，丢回队列中
   拓扑排序并不是传统的排序算法
   一个图可能存在多个拓扑序(Topological Order)，也可能不存在任何拓扑序

拓扑排序的四种不同问法
求任意一个拓扑序
问是否存在拓扑序
求是否存在且仅存在一个拓扑序
求字典序最小的拓扑排序




k数之和
https://www.lintcode.com/problem/k-sum/description
求方案总数 https://www.lintcode.com/problem/k-sum-ii/description
求具体方案 敬请期待在动态规划和深度优先搜索中对这两个问题的讲解


相关题
统计所有和 <= target 的配对数
http://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target/
http://www.jiuzhang.com/solutions/two-sum-less-than-or-equal-to-target/
统计所有和 >= target 的配对数
http://www.lintcode.com/en/problem/two-sum-greater-than-target/
http://www.jiuzhang.com/solutions/two-sum-greater-than-target/
两数之和本质不同的方案数 统计所有和 >= target 的配对数













## Binary Search

When to use binary search (`O(log(n))`):
* sorted array
* find a better performance than `O(n)`


## Binary Tree
* BFS in Binary Tree
* Binary Searh Tree
  * Insert / Remove / Find / Validate

* Traverse a tree by order:
  * Preorder: root -> left -> right
  * Inorder: left -> root -> right
  * Postorder: left -> right -> root

* Traverse a try by algorithms
  * Non-recursion
  * Traverse (recursion)
  * Divide Conquer (recursion)

1. Define recursive
2. Define exit
3. Convert it small chunk of problem

## Linked List

* L092 Reverse Linked List II

![Alt text](../images/L092.png?raw=true "Reverse Linked List II")



## Array

* Four Sum
  sort -> O(n^2) => O(n)
  3sum O(n^3) => O(n^2)
  4sum O(n^4) => O(n^3)


## Data Structure

Queue
Operations
● O(1) Push
● O(1) Pop
● O(1) Top
Core data structure for BFS!


Stack
Operations:
● O(1) Push
● O(1) Pop
● O(1) Top

// ascending / descending stack
O(n^2) => O(N)

DP: O(2^n) => O(n^2)
O(nlogn):
1. sorting and then binary search
2. use a O(logn) data structure: like heap / priority queue

Hash
Operations
● O(1) Insert
● O(1) Delete
● O(1) Find
Hash Function Collision
● Open Hashing (LinkedList)
● Closed Hashing (ArrayList)


Java
● HashTable ● HashSet
● HashMap
Which on is Thread Safe?



Heap
Operations
● O(log N) Add
● O(log N) Remove
● O(1) Min/Max

