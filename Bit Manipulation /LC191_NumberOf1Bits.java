/*
 * LeetCode Problem #191 - Number of 1 Bits
 *
 * Difficulty: Easy
 * Topic: Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Approach:
 * Use Brian Kernighan's algorithm.
 *
 * The operation n & (n - 1) removes the rightmost set bit (1)
 * from n. Repeat this until n becomes 0 and count the operations.
 *
 * Time Complexity: O(k), where k is the number of set bits
 * Space Complexity: O(1)
 */

class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
