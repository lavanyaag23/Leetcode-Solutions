/*
 * LeetCode Problem #239 - Sliding Window Maximum
 *
 * Difficulty: Hard
 * Topic: Arrays / Sliding Window / Monotonic Queue
 *
 * Problem Link:
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Approach:
 * Use a Deque to maintain indices of elements in decreasing order
 * of their values.
 *
 * The front of the deque always contains the index of the maximum
 * element in the current window.
 *
 * Remove indices that are outside the current window.
 * Remove smaller elements from the back because they cannot become
 * the maximum while the current larger element is present.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove elements outside the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Start storing answers when the first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
