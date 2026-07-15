/*
 * LeetCode Problem #1475 - Final Prices With a Special Discount in a Shop
 *
 * Difficulty: Easy
 * Topic: Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * Approach:
 * Use a Monotonic Stack while traversing the array
 * from right to left.
 *
 * Remove all elements greater than the current price.
 * The top of the stack represents the first price
 * less than or equal to the current price, which
 * becomes the discount.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = prices[i];
            } else {
                answer[i] = prices[i] - stack.peek();
            }

            stack.push(prices[i]);
        }

        return answer;
    }
}
