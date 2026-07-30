/*
 * LeetCode Problem #3014 - Minimum Number of Pushes to Type Word I
 *
 * Difficulty: Easy
 * Topic: Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
 *
 * Approach:
 * The first 8 letters require 1 push each,
 * the next 8 letters require 2 pushes each,
 * then 3 pushes, and finally 4 pushes.
 *
 * Since every character can be optimally assigned,
 * sort is unnecessary. The answer depends only on
 * the length of the word.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {

    public int minimumPushes(String word) {

        int n = word.length();

        int pushes = 0;

        for (int i = 0; i < n; i++) {

            pushes += (i / 8) + 1;
        }

        return pushes;
    }
}
