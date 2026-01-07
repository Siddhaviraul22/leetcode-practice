// Problem: Merge Intervals
// Link: https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // 1. Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart <= end) {
                // overlap → extend the end
                end = Math.max(end, currEnd);
            } else {
                // no overlap → save previous interval
                result.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }

        // add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}