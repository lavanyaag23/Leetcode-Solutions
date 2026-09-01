/*
 * LeetCode Problem #207 - Course Schedule
 *
 * Difficulty: Medium
 * Topic: Graphs, BFS, Topological Sort
 *
 * Problem Link:
 * https://leetcode.com/problems/course-schedule/
 *
 * Approach:
 * Treat courses as nodes and prerequisites as directed edges.
 * Use Kahn's Algorithm (BFS) for topological sorting.
 * If all courses can be processed, there is no cycle and
 * all courses can be finished. Otherwise, a cycle exists.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        int completedCourses = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            completedCourses++;

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return completedCourses == numCourses;
    }
}
