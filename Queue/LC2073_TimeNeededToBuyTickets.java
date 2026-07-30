/*
 * LeetCode Problem #2073 - Time Needed to Buy Tickets
 *
 * Difficulty: Easy
 * Topic: Queue / Simulation
 *
 * Problem Link:
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 *
 * Approach:
 * Simulate the queue process.
 *
 * Each person buys one ticket per turn.
 * Count how many ticket purchases are needed until
 * the person at index k gets all required tickets.
 *
 * For every person:
 * - If index <= k, they contribute min(tickets[i], tickets[k]) turns.
 * - If index > k, they contribute min(tickets[i], tickets[k] - 1) turns.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;

        int target = tickets[k];


        for (int i = 0; i < tickets.length; i++) {

            if (i <= k) {

                time += Math.min(tickets[i], target);

            } else {

                time += Math.min(tickets[i], target - 1);
            }
        }


        return time;
    }
}
