/*
 * LeetCode Problem #766 - Toeplitz Matrix
 *
 * Difficulty: Easy
 * Topic: Arrays, Matrix
 *
 * Problem Link:
 * https://leetcode.com/problems/toeplitz-matrix/
 *
 * Approach:
 * Compare every element with the element diagonally above-left.
 * If all elements in the same diagonal are equal, the matrix
 * is Toeplitz.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
