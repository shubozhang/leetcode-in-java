package com.leetcode.datastructure;

import com.model.DoubleLinkedNode;

import java.util.HashMap;

/**
 https://leetcode.com/problems/lru-cache/
 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

 Implement the LRUCache class:
 1) LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 2) int get(int key) Return the value of the key if the key exists, otherwise return -1.
 3) void put(int key, int value) Update the value of the key if the key exists. Otherwise,
 add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 evict the least recently used key.

 The functions get and put must each run in O(1) average time complexity.

 Example 1:
 Input:
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 Output: [null, null, null, 1, null, -1, null, -1, 3, 4]

 Explanation
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // cache is {1=1}
 lRUCache.put(2, 2); // cache is {1=1, 2=2}
 lRUCache.get(1);    // return 1
 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 lRUCache.get(2);    // returns -1 (not found)
 lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 lRUCache.get(1);    // return -1 (not found)
 lRUCache.get(3);    // return 3
 lRUCache.get(4);    // return 4

 Constraints:
 1) 1 <= capacity <= 3000
 2) 0 <= key <= 104
 3) 0 <= value <= 105
 4) At most 2 * 105 calls will be made to get and put.
 * */
public class M146LRUCache {

    private final int capacity;
    private HashMap<Integer, DoubleLinkedNode> keyToPrev = new HashMap<Integer, DoubleLinkedNode>();
    private DoubleLinkedNode head = new DoubleLinkedNode(-1, -1);
    private DoubleLinkedNode tail = new DoubleLinkedNode(-1, -1);

    public M146LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        //key找不到
        if( !keyToPrev.containsKey(key)) {
            return -1;
        }

        // remove current
        DoubleLinkedNode current = keyToPrev.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        //每次get，使用次数+1，最近使用，放于尾部
        //
        move_to_tail(current);

        return keyToPrev.get(key).value;
    }


    //数据放入缓存
    public void put(int key, int value) {
        // get 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail
        if (get(key) != -1) {
            keyToPrev.get(key).value = value;
            return;
        }

        //超出缓存上限
        if (keyToPrev.size() == capacity) {
            //删除头部数据
            keyToPrev.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        //新建节点
        DoubleLinkedNode insert = new DoubleLinkedNode(key, value);
        keyToPrev.put(key, insert);
        //放于尾部
        move_to_tail(insert);
    }

    //移动数据至尾部
    private void move_to_tail(DoubleLinkedNode current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }

}
