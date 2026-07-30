/*
 * LeetCode Problem #150 - Evaluate Reverse Polish Notation
 *
 * Difficulty: Medium
 * Topic: Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Approach:
 * Use a stack to store operands.
 *
 * Traverse each token:
 * - If token is a number, push it into the stack.
 * - If token is an operator, pop the top two numbers,
 *   perform the operation, and push the result back.
 *
 * The final value remaining in the stack is the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a + b);

            } else if (token.equals("-")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a - b);

            } else if (token.equals("*")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a * b);

            } else if (token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a / b);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
