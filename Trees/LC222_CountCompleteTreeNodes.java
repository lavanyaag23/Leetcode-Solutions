/*
 * LeetCode Problem #222 - Count Complete Tree Nodes
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Approach:
 * Use recursive traversal to count every node in the binary tree.
 *
 * For each node, recursively count the nodes in its left and right
 * subtrees and add 1 for the current node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
