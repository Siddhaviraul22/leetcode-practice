// Problem: Find The Highest Altitude
// Link: https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int largestAltitude(int[] gain) {
        int altitude=0;
        int maxAltitude=0;

        for(int g:gain){
            altitude+=g;
            maxAltitude=Math.max(maxAltitude,altitude);
        }
        return maxAltitude;
    }
}