/*
 * LeetCode Problem #703 - Kth Largest Element in a Stream
 *
 * Difficulty: Easy
 * Topic: Heap / Priority Queue
 *
 * Problem Link:
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Approach:
 * Use a min-heap to keep track of the k largest elements.
 * Whenever a new value is added, insert it into the heap.
 * If the heap size becomes greater than k, remove the smallest element.
 * The root of the min-heap is therefore always the kth largest element.
 *
 * Time Complexity: O(log k) per add operation
 * Space Complexity: O(k)
 */

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
