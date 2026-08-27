/*
 * LeetCode Problem #543 - Diameter of Binary Tree
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Tree, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Approach:
 * Use Depth First Search (DFS) to calculate the height of each subtree.
 *
 * For every node, the diameter passing through that node is the sum
 * of the heights of its left and right subtrees.
 *
 * Keep track of the maximum diameter found during the traversal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
