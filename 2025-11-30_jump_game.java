// Problem: Jump Game
// Link: https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;   // stuck, can't move further
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}