/*
 * LeetCode Problem #743 - Network Delay Time
 *
 * Difficulty: Medium
 * Topic: Graphs, Dijkstra's Algorithm, Shortest Path
 *
 * Problem Link:
 * https://leetcode.com/problems/network-delay-time/
 *
 * Approach:
 * Use Dijkstra's algorithm to find the shortest time from the source
 * node k to every other node.
 *
 * The graph is represented using an adjacency list. A priority queue
 * always processes the node with the smallest known distance.
 *
 * After finding the shortest distance to every node, the answer is
 * the maximum shortest distance. If any node is unreachable, return -1.
 *
 * Time Complexity: O((n + E) log n)
 * Space Complexity: O(n + E)
 */

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];

            graph[from].add(new int[]{to, weight});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int time = current[1];

            if (time > distance[node]) {
                continue;
            }

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int weight = edge[1];

                int newTime = time + weight;

                if (newTime < distance[next]) {
                    distance[next] = newTime;
                    pq.offer(new int[]{next, newTime});
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, distance[i]);
        }

        return answer;
    }
}
