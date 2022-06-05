package com.leetcode.bfs;

import com.model.Node;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;


/**
 The Queue documentation does a fairly good job of explaining the difference.

 add(E e) has the capability of throwing an exception if an element can't be added into the queue.
 This happens in case the queue is full.

 offer(E e) will return a special value (in this case, a boolean) if the value can't be added into
 the queue. This is useful if you're dealing with a size-limited queue but do not want to throw
 an exception.
 * */
public class BFSTemplate {

    public static void find(Node node){
        // in initialization, ArrayDeque is faster than LinkedList
        Queue<Node> queue = new ArrayDeque<>();

        // this can be used to track visited node (HashSet) or distance
        HashMap<Node, Integer> distance = new HashMap<>();

        // add root to the queue and start distance to root is 0
        queue.offer(node);
        distance.put(node, 0);

        // loop queue and pop one element at one time
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();

            // pop all neighbors and add them into the queue
            for(Node neighbor: newNode.neighbors) {
                if (distance.containsKey(neighbor)){
                    continue;
                }

                distance.put(neighbor, distance.get(newNode) + 1);
                queue.offer(neighbor);
            }
        }
    }
}


