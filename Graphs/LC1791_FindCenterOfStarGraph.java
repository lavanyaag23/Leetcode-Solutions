/*
 * LeetCode Problem #1791 - Find Center of Star Graph
 *
 * Difficulty: Easy
 * Topic: Graphs
 *
 * Problem Link:
 * https://leetcode.com/problems/find-center-of-star-graph/
 *
 * Approach:
 * The center of a star graph is connected to every other node.
 * Therefore, it must appear in both of the first two edges.
 * Compare the endpoints of the first two edges and return the common node.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int findCenter(int[][] edges) {

        if (edges[0][0] == edges[1][0] ||
            edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }

        return edges[0][1];
    }
}
