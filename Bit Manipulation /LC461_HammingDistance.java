/*
 * LeetCode Problem #461 - Hamming Distance
 *
 * Difficulty: Easy
 * Topic: Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/hamming-distance/
 *
 * Approach:
 * Use XOR to compare the corresponding bits of x and y.
 * Different bits produce 1 in the XOR result.
 *
 * Count the number of set bits in the XOR result using
 * Brian Kernighan's algorithm.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int hammingDistance(int x, int y) {

        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }

        return count;
    }
}
