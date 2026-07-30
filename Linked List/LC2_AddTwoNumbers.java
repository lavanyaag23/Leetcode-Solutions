/*
 * LeetCode Problem #2 - Add Two Numbers
 *
 * Difficulty: Medium
 * Topic: Linked List
 *
 * Problem Link:
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Approach:
 * Traverse both linked lists simultaneously and add the
 * corresponding digits along with the carry value.
 *
 * Create a new linked list containing the sum digits.
 *
 * A dummy node is used to simplify result list creation.
 *
 * Time Complexity: O(max(n, m))
 * Space Complexity: O(1)
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;


        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;


            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }


            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }


            carry = sum / 10;


            current.next = new ListNode(sum % 10);

            current = current.next;
        }


        return dummy.next;
    }
}
