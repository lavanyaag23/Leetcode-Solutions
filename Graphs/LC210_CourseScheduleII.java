/*
 * LeetCode Problem #210 - Course Schedule II
 *
 * Difficulty: Medium
 * Topic: Graphs, BFS, Topological Sort
 *
 * Problem Link:
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * Approach:
 * Treat courses as nodes and prerequisites as directed edges.
 * Use Kahn's Algorithm (BFS) for topological sorting.
 * Start with courses having indegree 0 and process them one by one.
 * If all courses are processed, the topological ordering is valid.
 * Otherwise, a cycle exists and no valid ordering is possible.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            order[index++] = current;

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}
