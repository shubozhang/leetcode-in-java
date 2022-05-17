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
| O(N)                   | O(NlogN)   | O(logN)       | O(N^2),  O(N^3)          | O(2^N)      | O(N!)       |
|------------------------|------------|---------------|--------------------------|-------------|-------------|
| 双指针算法 (high frequency) | merge sort | binary search | Dynamic Programming (DP) | combination | permutation |
| 打擂台算法 (high frequency) | quick sort |               |                          |
| 单调栈算法                  |            |               |                          |
| 单调队列算法                 |            |               |                          |




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



### Most Useful Methods
* `int[]`
  * size: `arr.length`
* `String`:
  * size: `str.length()`
  * char: `str.charAt(i)`
  * substring: `str.substring(i, j)` // does not include index `j`
  * char[]: `str.toCharArray()`
* HashMap:
  * add: `map.put(key, value)`
  * get (or check key): `map.get(key) -> return value or null`
  * getOrDefault: `map.getOrDefault(key, defaultValue) -> value`
  * delete: `map.remove(key)`
  * keySets: `map.keySet() -> set`
  * values: `map.values()`
  * containsKey: `map.containsKey()`
  * containsValue: `map.containsValue()`
  * iterate: `for(Map.Entry<key, value> entry: map.entrySet()`
* HashSet:
  * size: `set.size()`
  * add (or check element): `set.add(e) -> return false if e already exists in the set`
  * contains: `set.contains(e)`
  * delete: `set.remove(e)`
* Stack:
  * add: `stack.push(o)`
  * get and remove: `stack.pop()` // get and remove the top object from the stack
  * get: `stack.peek()` // look at the top object of the stack
  * isEmpty(): `stack.isEmpty()`
* Queue
  * add: `quque.offer(object)` // return false if fails to insert into the queue
  * remove head: `quque.poll()` // retrieve and removes the head of the queue
  * `quque.peek()`
  * `queue.isEmpty()`
  * `queue.contains(o)`