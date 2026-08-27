/*
 * LeetCode Problem #2029 - Stone Game IX
 *
 * Difficulty: Medium
 * Topic: Math, Game Theory
 *
 * Problem Link:
 * https://leetcode.com/problems/stone-game-ix/
 *
 * Approach:
 * Only the remainder of each stone modulo 3 matters.
 * Count the stones with remainders 0, 1, and 2.
 *
 * Stones with remainder 0 can be used in groups of three without
 * changing the modulo state. The winning condition depends on the
 * balance between the counts of remainder 1 and remainder 2 stones.
 *
 * Handle the cases based on whether the number of remainder 0 stones
 * is even or odd and determine whether Alice can force a win.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        return Math.abs(count[1] - count[2]) > 2;
    }
}
