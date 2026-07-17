/*
 * LeetCode Problem #15 - 3Sum
 *
 * Difficulty: Medium
 * Topic: Arrays
 *
 * Problem Link:
 * https://leetcode.com/problems/3sum/
 *
 * Approach:
 * Sort the array first. Then fix one element and use
 * the Two Pointer technique to find the remaining two
 * numbers whose sum equals the negative of the fixed
 * element. Skip duplicate values to avoid repeated
 * triplets.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) (excluding output list)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;

                }
            }
        }

        return result;
    }
}
