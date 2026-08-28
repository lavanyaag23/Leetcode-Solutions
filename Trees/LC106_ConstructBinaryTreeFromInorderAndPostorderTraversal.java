/*
 * LeetCode Problem #106 - Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Difficulty: Medium
 * Topic: Trees, Binary Tree, Recursion, HashMap
 *
 * Problem Link:
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Approach:
 * The last element of postorder is the root.
 * Use a HashMap to store the position of each value in the inorder array.
 * Elements before the root form the left subtree, while elements after
 * the root form the right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    private int postorderIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postorderIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        int mid = inorderMap.get(rootValue);

        root.right = build(postorder, mid + 1, right);
        root.left = build(postorder, left, mid - 1);

        return root;
    }
}
