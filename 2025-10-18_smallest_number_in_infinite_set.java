// Problem: Smallest Number in Infinite Set
// Link: https://leetcode.com/problems/smallest-number-in-infinite-set/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.PriorityQueue;
import java.util.HashSet;

class SmallestInfiniteSet {

    private int curr;
    private PriorityQueue<Integer> heap;
    private HashSet<Integer> inHeap;

    public SmallestInfiniteSet() {
        curr = 1;
        heap = new PriorityQueue<>();
        inHeap = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!heap.isEmpty()) {
            int val = heap.poll();
            inHeap.remove(val);
            return val;
        }
        return curr++;
    }
    
    public void addBack(int num) {
        if (num < curr && !inHeap.contains(num)) {
            heap.offer(num);
            inHeap.add(num);
        }
    }
}
