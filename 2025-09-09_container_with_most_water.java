// Problem: Container with most water
// Link: https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int maxArea=0;

        while(left<right){
            int width=right-left;
            int minHeight = Math.min(height[left],height[right]);
            int area=width*minHeight;
            maxArea=Math.max(maxArea,area);

            //move the shorter line
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}