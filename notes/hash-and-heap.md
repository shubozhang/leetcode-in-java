# Hash And Heap

* [LRU(Least Recently Used) Cache](https://leetcode.com/problems/lru-cache/)

### LRU

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

1) LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
2) int get(int key) Return the value of the key if the key exists, otherwise return -1.
3) void put(int key, int value) Update the value of the key if the key exists. Otherwise,
   add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
   evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

Examples:

```
// capacity = 3
[2, 1, 3] -> 4 -> [1, 3, 4]
[2, 1, 3] -> 2 -> [1, 3, 2]
[2, 1, 3] -> 1 -> [2, 3, 1]
```
