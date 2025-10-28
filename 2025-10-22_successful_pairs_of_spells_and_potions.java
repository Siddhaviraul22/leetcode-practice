// Problem: Successful Pairs of Spells and Potions
// Link: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            // Minimum potion strength needed for success
            long minPotion = (success + spell - 1) / spell; // ceiling division

            // Binary search for the first potion >= minPotion
            int idx = lowerBound(potions, minPotion);

            // Number of successful potions = m - idx
            res[i] = m - idx;
        }
        return res;
    }

    // Custom lower bound (first index where value >= target)
    private int lowerBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}