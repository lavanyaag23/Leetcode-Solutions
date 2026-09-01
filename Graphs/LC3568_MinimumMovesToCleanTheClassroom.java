/*
 * LeetCode Problem #3568 - Minimum Moves to Clean the Classroom
 *
 * Difficulty: Medium
 * Topic: Graphs, BFS, State Space Search
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/
 *
 * Approach:
 * Use BFS to explore all possible states of the classroom.
 * A state is represented by the current position, the number of
 * remaining energy units, and the collected trash.
 * BFS guarantees that the first time we reach a state where all
 * trash is cleaned, the number of moves is minimum.
 * Use a visited set to avoid processing the same state repeatedly.
 *
 * Time Complexity: O(m * n * k * 2^t)
 * Space Complexity: O(m * n * k * 2^t)
 */

import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;
        int trashCount = 0;

        Map<String, Integer> trashIndex = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (cell == 'X') {
                    trashIndex.put(i + "," + j, trashCount++);
                }
            }
        }

        int allTrash = (1 << trashCount) - 1;

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{startRow, startCol, energy, 0});

        visited.add(startRow + "," + startCol + "," + energy + ",0");

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int currentEnergy = current[2];
                int mask = current[3];

                if (mask == allTrash) {
                    return moves;
                }

                for (int[] direction : directions) {

                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }

                    char cell = classroom[newRow].charAt(newCol);

                    if (cell == '#') {
                        continue;
                    }

                    if (currentEnergy == 0 && cell != 'R') {
                        continue;
                    }

                    int newEnergy = currentEnergy - 1;

                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    String position = newRow + "," + newCol;

                    if (trashIndex.containsKey(position)) {
                        newMask |= 1 << trashIndex.get(position);
                    }

                    String state = newRow + "," + newCol + "," +
                                   newEnergy + "," + newMask;

                    if (!visited.contains(state)) {
                        visited.add(state);
                        queue.offer(new int[]{
                            newRow,
                            newCol,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
