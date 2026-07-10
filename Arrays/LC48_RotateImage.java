/*
 * LeetCode Problem #48 - Rotate Image
 *
 * Difficulty: Medium
 * Topic: Arrays, Matrix
 *
 * Problem Link:
 * https://leetcode.com/problems/rotate-image/
 *
 * Approach:
 * Rotate the matrix by:
 * 1. Transposing the matrix.
 * 2. Reversing each row.
 *
 * This performs an in-place 90-degree clockwise rotation.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
