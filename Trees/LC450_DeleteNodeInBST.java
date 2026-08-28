/*
 * LeetCode Problem #450 - Delete Node in a BST
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Search Tree, Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Approach:
 * Search for the node using the BST property.
 * If the node has no left child, return its right child.
 * If it has no right child, return its left child.
 * If it has two children, replace its value with the smallest value
 * from the right subtree and then delete that successor node.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(h)
 */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
