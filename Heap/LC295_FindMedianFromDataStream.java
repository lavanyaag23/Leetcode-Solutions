/*
 * LeetCode Problem #295 - Find Median from Data Stream
 *
 * Difficulty: Hard
 * Topic: Heap, Priority Queue, Data Stream
 *
 * Problem Link:
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Approach:
 * Use two heaps to maintain the numbers around the median.
 *
 * The max heap stores the smaller half of the numbers, while the
 * min heap stores the larger half.
 *
 * Keep both heaps balanced so that their sizes differ by at most one.
 * The median can then be obtained directly from the heap tops.
 *
 * Time Complexity:
 * addNum() -> O(log n)
 * findMedian() -> O(1)
 *
 * Space Complexity: O(n)
 */

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
