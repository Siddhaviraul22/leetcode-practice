// Problem: Minimum Number of Arrows to Burst Balloons
// Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        long lastEnd = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow’s position,
            // we need a new arrow
            if (points[i][0] > lastEnd) {
                arrows++;
                lastEnd = points[i][1];
            }
        }
        
        return arrows;
    }
}