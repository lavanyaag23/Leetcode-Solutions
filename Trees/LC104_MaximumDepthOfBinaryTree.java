/*
 * LeetCode Problem #104 - Maximum Depth of Binary Tree
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Approach:
 * Use recursion to find the depth of the left and right subtrees.
 * The maximum of the two depths, plus 1 for the current node,
 * gives the maximum depth of the tree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
