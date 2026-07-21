/*
 * LeetCode Problem #142 - Linked List Cycle II
 *
 * Difficulty: Medium
 * Topic: Linked List
 *
 * Problem Link:
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Approach:
 * Use Floyd's Cycle Detection Algorithm (Tortoise and Hare).
 *
 * First, use two pointers:
 * - slow moves one step at a time.
 * - fast moves two steps at a time.
 *
 * If there is a cycle, slow and fast will eventually meet.
 *
 * After they meet, reset one pointer to the head of the list.
 * Move both pointers one step at a time. The point where they
 * meet again is the starting node of the cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Step 2: Find the starting point of the cycle
                ListNode entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }

                return entry;
            }
        }

        // No cycle found
        return null;
    }
}
