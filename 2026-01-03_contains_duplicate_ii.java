// Problem: Contains Duplicate II
// Link: https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastIndex.containsKey(nums[i])) {
                if (i - lastIndex.get(nums[i]) <= k) {
                    return true;
                }
            }
            lastIndex.put(nums[i], i);
        }
        return false;
    }
}
