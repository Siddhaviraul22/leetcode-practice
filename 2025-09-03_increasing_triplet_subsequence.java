// Problem: Increasing Triplet Subsequence
// Link: https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num:nums){
            if (num<=first){
                first=num;  // new smallest
            }
            else if (num<=second){
                second=num;  //better middle 
            }
            else{
                return true;
            }
        }
        return false;
    }
}
