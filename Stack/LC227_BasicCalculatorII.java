/*
 * LeetCode Problem #227 - Basic Calculator II
 *
 * Difficulty: Medium
 * Topic: Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Approach:
 * Use a stack to store numbers.
 *
 * Traverse the expression and calculate based on
 * the previous operator.
 *
 * For:
 * '+'  -> push number
 * '-'  -> push negative number
 * '*'  -> multiply with stack top
 * '/'  -> divide stack top by number
 *
 * Finally, sum all values in the stack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') 
                    || i == s.length() - 1) {

                if (operator == '+') {

                    stack.push(number);

                } else if (operator == '-') {

                    stack.push(-number);

                } else if (operator == '*') {

                    stack.push(stack.pop() * number);

                } else if (operator == '/') {

                    stack.push(stack.pop() / number);
                }

                operator = ch;
                number = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
