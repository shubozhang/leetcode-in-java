package com.leetcode.datastructure;


import java.util.PriorityQueue;

/**
 Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k
 closest points to the origin (0, 0).

 The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

 You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).



 Example 1:


 Input: points = [[1,3],[-2,2]], k = 1
 Output: [[-2,2]]
 Explanation:
 The distance between (1, 3) and the origin is sqrt(10).
 The distance between (-2, 2) and the origin is sqrt(8).
 Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 Example 2:

 Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 Output: [[3,3],[-2,4]]
 Explanation: The answer [[-2,4],[3,3]] would also be accepted.


 Constraints:

 1 <= k <= points.length <= 104
 -104 < xi, yi < 104
 * */
public class M973KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int len = points.length;

        for (int i = 0; i < len; i++) {
            pq.add(new Point(points[i][0], points[i][1]));
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }

        return res;
    }

    class Point implements Comparable<Point> {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point a) {
            return (this.x * this.x + this.y * this.y) - (a.x * a.x + a.y * a.y);
        }
    }


}
