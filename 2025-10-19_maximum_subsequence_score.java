// Problem: Maximum Subsequence Score
// Link: https://leetcode.com/problems/maximum-subsequence-score/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i]; // treat as min candidate
            pairs[i][1] = nums1[i];
        }

        // Sort pairs by nums2 descending
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // for nums1 values
        long sum = 0, maxScore = 0;

        for (int[] p : pairs) {
            int minCandidate = p[0];
            int num1Value = p[1];

            // Add current nums1 value
            minHeap.offer(num1Value);
            sum += num1Value;

            // If heap size exceeds k, remove the smallest
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // If we have exactly k elements, compute the score
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * minCandidate);
            }
        }

        return maxScore;
    }
}
