// Problem: Summary Ranges
// Link: https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // end of array OR break in consecutive sequence
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                int end = nums[i - 1];

                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }

                // start new range if not end of array
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return result;
    }
}