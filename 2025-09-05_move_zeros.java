// Problem: Move Zeros
// Link: https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos=0;

        //first pass move all non zero numbers to the front
        for(int num:nums){
            if(num!=0){
                nums[insertPos++]=num;
            }
        }

        //secondpass fill remaining postitions with zeros
        while(insertPos<nums.length){
            nums[insertPos++]=0;
        }
    }
}