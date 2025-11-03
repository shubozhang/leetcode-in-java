package com.leetcode.datastructure;

import java.util.*;


/**
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



 Example 1:

 Input: nums = [108,108,108,222,222,33], k = 2
 Output: [108,222]
 Example 2:

 Input: nums = [55], k = 1
 Output: [55]


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

    // Method 2: use bucket
    public int[] topKFrequentB(int[] nums, int k) {
        // 1. Count frequency for each number
        // <number, frequency>
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    
        // 2. Create buckets: index = frequency, value = list of numbers with that frequency
        // The maximum possible frequency is nums.length
        // Size is nums.length + 1 to account for 0-indexing up to frequency N
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    
        // 3. Populate buckets
        // bucket[frequency] = num(s)
        for (int key: map.keySet()) {
            int frequency = map.get(key);
            buckets[frequency].add(key);
        }
    
        // 4. Collect the top K elements
        // Iterate from the highest possible frequency (buckets.length - 1) down to 1
        List<Integer> result = new ArrayList<>();
        
        // We stop as soon as result.size() reaches k
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            // Check if the current bucket (frequency) has any elements
            if (buckets[i].size() > 0) {
                // Add numbers from the current bucket until k is reached
                for (int num : buckets[i]) {
                    result.add(num);
                    if (result.size() == k) {
                        break; // Found all K elements, stop immediately
                    }
                }
            }
        }
    
        // 5. Convert the List<Integer> result to the final int[] array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = result.get(i);
        }
    
        return res;
    }

}
