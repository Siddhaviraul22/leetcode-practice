// Problem: Jump Game II
// Link: https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currEnd) { 
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }
}
