/*
 * LeetCode Problem #1047 - Remove All Adjacent Duplicates In String
 *
 * Difficulty: Easy
 * Topic: Stack, String
 *
 * Problem Link:
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * Approach:
 * Use a stack to process the characters.
 * If the current character matches the top of the stack,
 * remove the top element. Otherwise, push the current
 * character onto the stack.
 *
 * Finally, build the resulting string from the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == ch) {

                stack.pop();

            } else {

                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
