/*
 * LeetCode Problem #2359 - Find Closest Node to Given Two Nodes
 *
 * Difficulty: Medium
 * Topic: Graphs, BFS, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
 *
 * Approach:
 * Since each node has at most one outgoing edge, calculate the distance
 * from each given starting node to every reachable node.
 * For every node reachable from both starting nodes, calculate the maximum
 * of the two distances. Return the node with the minimum such distance.
 * If there is a tie, return the smaller index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {

        int n = edges.length;

        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);

        int answer = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (dist1[i] != -1 && dist2[i] != -1) {

                int distance = Math.max(dist1[i], dist2[i]);

                if (distance < minDistance) {
                    minDistance = distance;
                    answer = i;
                }
            }
        }

        return answer;
    }

    private int[] getDistances(int[] edges, int start) {

        int n = edges.length;
        int[] distance = new int[n];

        Arrays.fill(distance, -1);

        int current = start;
        int steps = 0;

        while (current != -1 && distance[current] == -1) {

            distance[current] = steps++;
            current = edges[current];
        }

        return distance;
    }
}
