// Problem: Maximum Average Subarray I
// Link: https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;

        //calculate teh sum of the first k elements
        long windowSum=0;
        for(int i=0;i<k;i++){
            windowSum+=nums[i];
        }

        long maxSum=windowSum;

        //slide the window
        for(int i=k;i<n;i++){
            windowSum+=nums[i]-nums[i-k];
            maxSum=Math.max(maxSum, windowSum);
        }
        return(double)maxSum/k;
    }
}