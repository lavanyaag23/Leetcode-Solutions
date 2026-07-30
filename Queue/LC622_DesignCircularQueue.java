/*
 * LeetCode Problem #622 - Design Circular Queue
 *
 * Difficulty: Medium
 * Topic: Queue / Circular Queue
 *
 * Problem Link:
 * https://leetcode.com/problems/design-circular-queue/
 *
 * Approach:
 * Implement a circular queue using an array.
 *
 * Maintain:
 * - front pointer to track the first element
 * - rear pointer to track the next insertion position
 * - size to check empty/full conditions
 *
 * Circular behavior is achieved using modulo operation.
 *
 * Time Complexity:
 * All operations: O(1)
 *
 * Space Complexity: O(k)
 */

class MyCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;


    public MyCircularQueue(int k) {

        capacity = k;

        queue = new int[k];

        front = 0;
        rear = 0;
        size = 0;
    }


    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        queue[rear] = value;

        rear = (rear + 1) % capacity;

        size++;

        return true;
    }


    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;

        size--;

        return true;
    }


    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }


    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[(rear - 1 + capacity) % capacity];
    }


    public boolean isEmpty() {

        return size == 0;
    }


    public boolean isFull() {

        return size == capacity;
    }
}
