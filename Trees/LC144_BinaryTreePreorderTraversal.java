/*
 * LeetCode Problem #144 - Binary Tree Preorder Traversal
 *
 * Difficulty: Easy
 * Topic: Trees, Binary Tree, DFS, Stack
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Approach:
 * Use Depth First Search (DFS) recursively.
 *
 * In preorder traversal, visit the nodes in the following order:
 * Root -> Left -> Right
 *
 * Add the current node's value first, then recursively traverse
 * the left and right subtrees.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        result.add(node.val);

        preorder(node.left, result);
        preorder(node.right, result);
    }
}
