package com.leetcode.bfs;

import java.util.*;

/**
 In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

 A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal
 direction, then one square in an orthogonal direction.

 Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the
 answer exists.

 Example 1:
 Input: x = 2, y = 1
 Output: 1
 Explanation: [0, 0] → [2, 1]

 Example 2:
 Input: x = 5, y = 5
 Output: 4
 Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]

 Constraints:
 -300 <= x, y <= 300
 0 <= |x| + |y| <= 300
 * */
public class M1197MinKnightMoves {

    private Map<String, Integer> memo = new HashMap<>();

    private int dfs(int x, int y) {
        String key = x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        } else {
            Integer ret = Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2)),
                    dfs(Math.abs(x - 2), Math.abs(y - 1))) + 1;
            memo.put(key, ret);
            return ret;
        }
    }

    public int minKnightMovesA(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }

    // BFS has time limited exception
    public static final int[] X_OFFSET = {2, 1, -1, -2, -2, -1, 1, 2};
    public static final int[] Y_OFFSET = {1, 2, 2, 1, -1, -2, -2, -1};

    public int minKnightMovesB(int x, int y) {
        Point target = new Point(x, y);
        Queue<Point> queue = new ArrayDeque<>();

        Map<Point, Integer> map = new HashMap<>();

        queue.offer(new Point(0, 0));
        map.put(new Point(0, 0), 0);

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.equals(target)) {
                return map.get(curr);
            }
            int distance = map.get(curr);
            for (int i = 0; i < X_OFFSET.length; i++) {
                Point p = new Point(curr.x + X_OFFSET[i], curr.y + Y_OFFSET[i]);
                if (map.containsKey(p)) { continue;}
                queue.offer(p);
                map.put(p, distance + 1);
            }

        }

        return Integer.MAX_VALUE;

    }


    class Point{
        public final int x;
        public final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o){
            Point point = (Point) o;
            return (this.x == point.x && this.y == point.y);
        }
    }
}
