// Problem: Trapping Rain Water
// Link: https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0; // can't trap water with less than 3 bars

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
