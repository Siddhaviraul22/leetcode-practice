// Problem: Remove Duplicates from Sorted Array II
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; // next position to write

        for (int num : nums) {
            if (k < 2 || num > nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
}
