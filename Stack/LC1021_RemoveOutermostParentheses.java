/*
 * LeetCode Problem #1021 - Remove Outermost Parentheses
 *
 * Difficulty: Easy
 * Topic: Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * Approach:
 * Traverse the string while maintaining the current
 * parentheses depth. Append '(' only if the depth is
 * greater than 0 before incrementing it, and append ')'
 * only if the depth is greater than 1 before decrementing it.
 * This effectively removes the outermost parentheses from
 * each primitive valid parentheses string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();

        int depth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                if (depth > 0) {
                    result.append(ch);
                }

                depth++;

            } else {

                depth--;

                if (depth > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
