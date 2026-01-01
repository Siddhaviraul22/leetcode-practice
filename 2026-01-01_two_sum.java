// Problem: Two Sum
// Link: https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // value -> index

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[] { map.get(needed), i };
            }

            map.put(nums[i], i);
        }

        // problem guarantees exactly one solution
        return new int[0];
    }
}
