/*
 * LeetCode Problem #69 - Sqrt(x)
 *
 * Difficulty: Easy
 * Topic: Math, Binary Search
 *
 * Problem Link:
 * https://leetcode.com/problems/sqrtx/
 *
 * Approach:
 * Use Binary Search to find the integer square root.
 * Search within the range [1, x] and compare mid with x / mid
 * to avoid integer overflow. The answer is the largest integer
 * whose square is less than or equal to x.
 *
 * Time Complexity: O(log x)
 * Space Complexity: O(1)
 */

class Solution {

    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x;
        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {

                answer = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }
}
