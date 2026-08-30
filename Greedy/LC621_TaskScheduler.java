/*
 * LeetCode Problem #621 - Task Scheduler
 *
 * Difficulty: Medium
 * Topic: Greedy / Sorting
 *
 * Problem Link:
 * https://leetcode.com/problems/task-scheduler/
 *
 * Approach:
 * Count the frequency of each task. The most frequent task determines
 * the minimum number of intervals needed. Arrange the most frequent task
 * with n idle spaces between its occurrences and fill those spaces with
 * other tasks whenever possible.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        int result = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(result, tasks.length);
    }
}
