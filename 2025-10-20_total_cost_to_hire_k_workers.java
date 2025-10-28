// Problem: Total Cost to Hire K Workers
// Link: https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;
        int left = 0, right = n - 1;

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        // fill initial heaps
        while (leftHeap.size() < candidates && left <= right) {
            leftHeap.offer(costs[left++]);
        }
        while (rightHeap.size() < candidates && right >= left) {
            rightHeap.offer(costs[right--]);
        }

        // hire k workers
        for (int i = 0; i < k; i++) {
            int leftMin = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int rightMin = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();

            // choose cheaper one
            if (leftMin <= rightMin) {
                total += leftHeap.poll();
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                total += rightHeap.poll();
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }
        return total;
    }
}
