/*
 * LeetCode Problem #2545 - Sort the Students by Their Kth Score
 *
 * Difficulty: Medium
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/sort-the-students-by-their-kth-score/
 *
 * Approach:
 * Sort the rows of the matrix in descending order based on
 * the score at column k.
 *
 * Time Complexity: O(m log m)
 * Space Complexity: O(log m)
 */

import java.util.*;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {

        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));

        return score;
    }
}
