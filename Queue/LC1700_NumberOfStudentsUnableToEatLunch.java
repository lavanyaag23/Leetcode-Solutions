/*
 * LeetCode Problem #1700 - Number of Students Unable to Eat Lunch
 *
 * Difficulty: Easy
 * Topic: Queue / Counting
 *
 * Problem Link:
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 *
 * Approach:
 * Count the number of students who prefer each type of sandwich.
 *
 * Traverse the sandwich stack:
 * - If students are available for the current sandwich type,
 *   one student takes it.
 * - Otherwise, remaining students cannot be served.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int countStudents(int[] students, int[] sandwiches) {

        int[] count = new int[2];


        for (int student : students) {

            count[student]++;
        }


        for (int sandwich : sandwiches) {

            if (count[sandwich] == 0) {

                break;
            }

            count[sandwich]--;
        }


        return count[0] + count[1];
    }
}
