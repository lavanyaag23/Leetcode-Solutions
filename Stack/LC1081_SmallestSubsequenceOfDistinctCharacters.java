/*
 * LeetCode Problem #1081 - Smallest Subsequence of Distinct Characters
 *
 * Difficulty: Medium
 * Topic: Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Approach:
 * Use a monotonic stack to build the lexicographically smallest
 * subsequence. Keep track of the last occurrence of each character
 * and whether it is already included in the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Stack;

class Solution {

    public String smallestSubsequence(String s) {

        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if (visited[current - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > current
                    && lastIndex[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(current);
            visited[current - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
