/*
 * LeetCode Problem #933 - Number of Recent Calls
 *
 * Difficulty: Easy
 * Topic: Queue
 *
 * Problem Link:
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * Approach:
 * Use a Queue to store the timestamps of recent requests.
 *
 * For every new request at time t:
 * 1. Add t to the queue.
 * 2. Remove all timestamps that are smaller than t - 3000.
 * 3. The remaining elements represent requests made within
 *    the time range [t - 3000, t].
 * 4. Return the size of the queue.
 *
 * Since requests are given in increasing order of time,
 * the queue naturally maintains timestamps in sorted order.
 *
 * Time Complexity: O(n) overall
 * Space Complexity: O(n)
 */

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {

        // Add the current request timestamp
        queue.offer(t);

        // Remove requests outside the 3000 ms window
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Return number of requests in the valid time range
        return queue.size();
    }
}
