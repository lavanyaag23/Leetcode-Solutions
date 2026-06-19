/*
 * LeetCode Problem #55 - Jump Game
 *
 * Difficulty: Medium
 * Topic: Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/jump-game/
 *
 * Approach:
 * Track the farthest reachable index while
 * traversing the array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for(int i = 0; i < nums.length; i++) {

            if(i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}

