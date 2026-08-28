/*
 * LeetCode Problem #733 - Flood Fill
 *
 * Difficulty: Easy
 * Topic: Arrays, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/flood-fill/
 *
 * Approach:
 * Start DFS from the given pixel and change its color.
 * Visit the four adjacent pixels that have the original color.
 * Continue until all connected pixels with the original color are changed.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col,
                     int originalColor, int newColor) {

        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length ||
            image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row + 1, col, originalColor, newColor);
        dfs(image, row - 1, col, originalColor, newColor);
        dfs(image, row, col + 1, originalColor, newColor);
        dfs(image, row, col - 1, originalColor, newColor);
    }
}
