/*
 * LeetCode Problem #867 - Transpose Matrix
 *
 * Difficulty: Easy
 * Topic: Arrays, Matrix
 *
 * Problem Link:
 * https://leetcode.com/problems/transpose-matrix/
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)
 */
class Solution {
    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
