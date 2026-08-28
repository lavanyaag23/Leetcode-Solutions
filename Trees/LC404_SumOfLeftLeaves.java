/*
 * LeetCode Problem #404 - Sum of Left Leaves
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Tree, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Approach:
 * Use Depth First Search (DFS) to traverse the binary tree.
 *
 * A node is a left leaf if it is the left child of its parent
 * and has no left or right child.
 *
 * Recursively calculate the sum of left leaves in the left and
 * right subtrees.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null &&
            root.left.left == null &&
            root.left.right == null) {

            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
