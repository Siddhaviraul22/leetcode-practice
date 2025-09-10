// Problem: Max number of K-sum pairs
// Link: https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxOperations(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int target = k - num;
            
            if (map.getOrDefault(target, 0) > 0) {
                // Found a pair
                operations++;
                map.put(target, map.get(target) - 1);
            } else {
                // Save num for future pairing
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }
}