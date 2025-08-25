// Problem: Product of array except self
// Link: https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[]res=new int[n];
        
        //prefix products
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }

        //multiply with suffix products
        int suffix=1;
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*suffix;
            suffix*=nums[i];
        }
        return res;
    }
}