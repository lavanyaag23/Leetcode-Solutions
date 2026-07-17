/*
 * LeetCode Problem #2696 - Minimum String Length After Removing Substrings
 *
 * Difficulty: Easy
 * Topic: Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
 *
 * Approach:
 * Use a stack to process the string character by character.
 * Whenever the current character forms "AB" or "CD" with
 * the top of the stack, remove the pair by popping the stack.
 * Otherwise, push the current character onto the stack.
 * The remaining stack size represents the minimum length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public int minLength(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty()) {

                char top = stack.peek();

                if ((top == 'A' && ch == 'B') ||
                    (top == 'C' && ch == 'D')) {

                    stack.pop();
                    continue;
                }
            }

            stack.push(ch);
        }

        return stack.size();
    }
}
