// Problem: 3Sum
// Link: https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;

                    // skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;  // need bigger sum
                } else {
                    right--; // need smaller sum
                }
            }
        }

        return res;
    }
}
