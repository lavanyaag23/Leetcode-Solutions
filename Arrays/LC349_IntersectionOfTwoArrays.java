/*
 * LeetCode Problem #349 - Intersection of Two Arrays
 *
 * Difficulty: Easy
 * Topic: Arrays / HashSet
 *
 * Problem Link:
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Approach:
 * Store all elements of nums1 in a HashSet.
 *
 * Traverse nums2 and check whether each element exists
 * in the set. Use another HashSet to store the common
 * elements to avoid duplicates.
 *
 * Finally, convert the result set into an integer array.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> result = new HashSet<>();

        for (int num : nums2) {

            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] answer = new int[result.size()];

        int index = 0;

        for (int num : result) {
            answer[index++] = num;
        }

        return answer;
    }
}
