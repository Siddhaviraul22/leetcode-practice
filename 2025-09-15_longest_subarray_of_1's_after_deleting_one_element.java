// Problem: Longest Subarray of 1's After Deleting One Element
// Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int zeros=0;
        int maxLen=0;

        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeros++;
            }
            //shrink window if more than 1 zero
            while(zeros>1){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }

            //we must delete one element, so length=(right-left)
            maxLen=Math.max(maxLen, right-left);

        }
        return maxLen;
    }
}