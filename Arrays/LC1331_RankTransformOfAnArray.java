/*
 * LeetCode Problem #1331 - Rank Transform of an Array
 *
 * Difficulty: Easy
 * Topic: Arrays, Sorting, HashMap
 *
 * Problem Link:
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
 * Approach:
 * Create a sorted copy of the array and assign ranks
 * to unique elements using a HashMap. Replace each
 * element in the original array with its corresponding rank.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] arrayRankTransform(int[] arr) {

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int num : sorted) {

            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}
