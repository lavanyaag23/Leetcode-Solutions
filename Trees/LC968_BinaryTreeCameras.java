/*
 * LeetCode Problem #968 - Binary Tree Cameras
 *
 * Difficulty: Hard
 * Topic: Trees, Greedy, Dynamic Programming
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * Approach:
 * Use DFS with three states:
 * 0 -> Node needs a camera
 * 1 -> Node is covered
 * 2 -> Node has a camera
 *
 * Place a camera at a node whenever one of its children needs coverage.
 * After processing the tree, place an additional camera at the root if
 * the root still needs coverage.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {

    private int cameras = 0;

    public int minCameraCover(TreeNode root) {

        if (dfs(root) == 0) {
            cameras++;
        }

        return cameras;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            cameras++;
            return 2;
        }

        if (left == 2 || right == 2) {
            return 1;
        }

        return 0;
    }
}
