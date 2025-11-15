// Problem: Non-overlapping Intervals
// Link: https://leetcode.com/problems/non-overlapping-intervals/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1;  // keep first interval
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If no overlap
            if (intervals[i][0] >= lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}