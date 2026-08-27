/*
 * LeetCode Problem #701 - Insert into a Binary Search Tree
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Search Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Approach:
 * Use the Binary Search Tree property to find the correct position.
 *
 * If the value is smaller than the current node, insert it into
 * the left subtree. Otherwise, insert it into the right subtree.
 *
 * When a null position is found, create a new node and return it.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(h)
 */

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
