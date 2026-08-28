/*
 * LeetCode Problem #105 - Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, Recursion, HashMap
 *
 * Problem Link:
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Approach:
 * The first element of preorder is the root.
 * Use a HashMap to store the position of each value in the inorder array.
 * Elements before the root form the left subtree, while elements after
 * the root form the right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int mid = inorderMap.get(rootValue);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}
