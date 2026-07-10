/*
 * LeetCode Problem #54 - Spiral Matrix
 *
 * Difficulty: Medium
 * Topic: Arrays, Matrix
 *
 * Problem Link:
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Approach:
 * Traverse the matrix layer by layer using four boundaries:
 * - top
 * - bottom
 * - left
 * - right
 *
 * After traversing one side, update the corresponding boundary
 * until all elements are visited.
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(1) (excluding output list)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
