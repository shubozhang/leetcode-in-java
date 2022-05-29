package com.leetcode.datastructure;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 return the minimum number of conference rooms required.

 Example 1:

 Input: intervals = [[0,30],[5,10],[15,20]]
 Output: 2
 Example 2:

 Input: intervals = [[7,10],[2,4]]
 Output: 1


 Constraints:

 1 <= intervals.length <= 104
 0 <= starti < endi <= 106
 * */
public class M253MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Queue<Integer> heap = new PriorityQueue<>();
        // Add the first meeting
        heap.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
            }


            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            heap.add(intervals[i][1]);
        }



        // The size of the heap tells us the minimum rooms required for all the meetings.
        return heap.size();
    }
}