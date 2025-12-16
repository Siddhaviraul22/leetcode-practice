// Problem: Two Sum II - Input Array Is Sorted
// Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};  // 1-indexed
            }

            if (sum < target) {
                left++;    // need a bigger sum
            } else {
                right--;   // need a smaller sum
            }
        }

        return new int[]{-1, -1}; // won't happen because solution guaranteed
    }
}
