/*
 * LeetCode Problem #1260 - Shift 2D Grid
 *
 * Difficulty: Easy
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/shift-2d-grid/
 *
 * Approach:
 * Treat the 2D grid as a 1D array of size m * n.
 * For each element at index i, after shifting k positions,
 * its new position is (i + k) % (m * n).
 *
 * Convert the shifted 1D positions back into 2D coordinates
 * using row = index / n and column = index % n.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k = k % total;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                result.get(i).add(0);
            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int currentIndex = i * n + j;
                int newIndex = (currentIndex + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                result.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return result;
    }
}
