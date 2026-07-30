/*
 * LeetCode Problem #707 - Design Linked List
 *
 * Difficulty: Medium
 * Topic: Linked List
 *
 * Problem Link:
 * https://leetcode.com/problems/design-linked-list/
 *
 * Approach:
 * Implement a singly linked list using a custom Node class.
 *
 * A dummy head node is used to simplify insertion and
 * deletion operations.
 *
 * Supported operations:
 * - get(index)
 * - addAtHead(val)
 * - addAtTail(val)
 * - addAtIndex(index, val)
 * - deleteAtIndex(index)
 *
 * Time Complexity:
 * - get: O(n)
 * - addAtHead: O(1)
 * - addAtTail: O(n)
 * - addAtIndex: O(n)
 * - deleteAtIndex: O(n)
 *
 * Space Complexity: O(n)
 */

class MyLinkedList {

    private class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {

        head = new Node(0); // Dummy node
        size = 0;
    }


    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        Node current = head.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }


    public void addAtHead(int val) {

        Node newNode = new Node(val);

        newNode.next = head.next;
        head.next = newNode;

        size++;
    }


    public void addAtTail(int val) {

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(val);

        size++;
    }


    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node newNode = new Node(val);

        newNode.next = current.next;
        current.next = newNode;

        size++;
    }


    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        size--;
    }
}
