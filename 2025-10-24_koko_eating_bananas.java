// Problem: Koko Eating Bananas
// Link: https://leetcode.com/problems/koko-eating-bananas/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // same as ceil(pile / mid)
            }

            if (hours <= h) {
                right = mid; // can try slower
            } else {
                left = mid + 1; // too slow, need faster
            }
        }

        return left;
    }
}
