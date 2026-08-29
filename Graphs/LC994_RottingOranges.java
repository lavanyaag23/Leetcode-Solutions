/*
 * LeetCode Problem #994 - Rotting Oranges
 *
 * Difficulty: Medium
 * Topic: Graphs
 *
 * Problem Link:
 * https://leetcode.com/problems/rotting-oranges/
 *
 * Approach:
 * Use Breadth-First Search (BFS) starting from all initially rotten oranges.
 * Each BFS level represents one minute. For every rotten orange, rot all
 * adjacent fresh oranges and add them to the queue.
 *
 * Count the number of fresh oranges initially. Whenever a fresh orange
 * becomes rotten, decrease the count. If all fresh oranges become rotten,
 * return the number of minutes. Otherwise, return -1.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                for (int[] direction : directions) {

                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];

                    if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
