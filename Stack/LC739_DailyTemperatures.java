/*
 * LeetCode Problem #739 - Daily Temperatures
 *
 * Difficulty: Medium
 * Topic: Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Approach:
 * Use a monotonic decreasing stack storing indices.
 * For each temperature, resolve previous colder days by
 * calculating the distance between the current index and
 * the index at the top of the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }
}
