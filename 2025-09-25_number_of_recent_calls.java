// Problem: Number of Recent Calls
// Link:https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        // Drop everything older than (t - 3000)
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}