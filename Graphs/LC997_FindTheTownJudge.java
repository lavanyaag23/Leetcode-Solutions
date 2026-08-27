/*
 * LeetCode Problem #997 - Find the Town Judge
 *
 * Difficulty: Easy
 * Topic: Graphs, Degree Counting
 *
 * Problem Link:
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * Approach:
 * Use a degree array to track the trust relationship.
 *
 * If person a trusts person b:
 * - Decrease the score of a because a trusts someone.
 * - Increase the score of b because someone trusts b.
 *
 * The town judge must trust nobody and be trusted by everyone else.
 * Therefore, the judge must have a score of n - 1.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */

class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] degree = new int[n + 1];

        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];

            degree[a]--;
            degree[b]++;
        }

        for (int person = 1; person <= n; person++) {
            if (degree[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}
