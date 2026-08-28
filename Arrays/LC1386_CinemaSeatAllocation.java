/*
 * LeetCode Problem #1386 - Cinema Seat Allocation
 *
 * Difficulty: Medium
 * Topic: Arrays, Greedy, Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/cinema-seat-allocation/
 *
 * Approach:
 * Each row can accommodate two groups of four:
 * seats 2-5 and 6-9.
 * For rows without reserved seats, two groups can always be placed.
 * For rows with reservations, check whether the left, middle, or right
 * block of four seats is available and calculate the maximum groups.
 *
 * Time Complexity: O(m)
 * Space Complexity: O(m)
 */

import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            reserved
                .computeIfAbsent(seat[0], key -> new HashSet<>())
                .add(seat[1]);
        }

        int result = (n - reserved.size()) * 2;

        for (Set<Integer> seats : reserved.values()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int seat : seats) {
                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }
            }

            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result++;
            }
        }

        return result;
    }
}
