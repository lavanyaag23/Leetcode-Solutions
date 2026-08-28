/*
 * LeetCode Problem #841 - Keys and Rooms
 *
 * Difficulty: Medium
 * Topic: Graphs, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * Approach:
 * Treat each room as a graph node and each key as a directed edge.
 * Start from room 0 and use DFS to visit every room that can be reached.
 * Finally, check whether all rooms have been visited.
 *
 * Time Complexity: O(n + k)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        dfs(0, rooms, visited);

        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {

        visited[room] = true;

        for (int key : rooms.get(room)) {

            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
