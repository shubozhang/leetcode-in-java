package com.leetcode.datastructure;

import java.util.*;


/**
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]


 Constraints:

 1 <= nums.length <= 105
 k is in the range [1, the number of unique elements in the array].
 It is guaranteed that the answer is unique.


 Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


 1. The first step is to build a hash map element -> its frequency. In Java, we use the data structure HashMap.
 Python provides dictionary subclass Counter to initialize the hash map we need directly from the input array.
 This step takes \mathcal{O}(N)O(N) time where N is a number of elements in the list.

 2. The second step is to build a heap of size k using N elements. To add the first k elements takes a
 linear time \mathcal{O}(k)O(k) in the average case,
 and \mathcal{O}(\log 1 + \log 2 + ... + \log k) = \mathcal{O}(log k!) = \mathcal{O}(k \log k)O(log1+log2+...+logk)=O(logk!)=O(klogk)
 in the worst case. It's equivalent to heapify implementation in Python. After the first k elements we start to push and pop at each
 step, N - k steps in total. The time complexity of heap push/pop is \mathcal{O}(\log k)O(logk) and we do it N - k times that
 means \mathcal{O}((N - k)\log k)O((N−k)logk) time complexity. Adding both parts up, we get \mathcal{O}(N \log k)O(Nlogk)
 time complexity for the second step.

 3. The third and the last step is to convert the heap into an output array. That could be done in \mathcal{O}(k \log k)O(klogk) time.

 Complexity Analysis

 Time complexity : \mathcal{O}(N \log k)O(Nlogk) if k < Nk<N and \mathcal{O}(N)O(N) in the particular case of N = kN=k.
 That ensures time complexity to be better than \mathcal{O}(N \log N)O(NlogN).

 Space complexity : \mathcal{O}(N + k)O(N+k) to store the hash map with not more NN elements and a heap with kk elements.
 * */
public class M347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // <number, frequency>
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(map::get)
                /* (n1, n2) -> map.get(n1) - map.get(n2) */
        );

        for (int num: map.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

    // use bucket method
    public int[] topKFrequentB(int[] nums, int k) {
        // <number, frequency>
        Map<Integer, Integer> map = new HashMap<>();

        // count frequency for each num
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create buckets for all possible num + 1, since there is no frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // bucket[frequency] = num
        // num with same freq will be in the same bucket
        for (int key: map.keySet()) {
            buckets[map.get(key)].add(key);
        }

        // loop the freq in desc order
        List<Integer> flattened = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i].size() == 0) { continue;}
            if (flattened.size() >= k) { break;}

            flattened.addAll(buckets[i]);
        }

        // return the k top freq
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = flattened.get(i);
        }

        return res;
    }

}