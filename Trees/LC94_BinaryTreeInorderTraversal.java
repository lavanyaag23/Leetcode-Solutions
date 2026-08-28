/*
 * LeetCode Problem #94 - Binary Tree Inorder Traversal
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Tree, DFS
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Approach:
 * Use recursive Depth First Search (DFS).
 *
 * Inorder traversal visits nodes in the following order:
 * Left -> Root -> Right
 *
 * Recursively traverse the left subtree, add the current node,
 * and then traverse the right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        inorder(node.left, result);

        result.add(node.val);

        inorder(node.right, result);
    }
}
