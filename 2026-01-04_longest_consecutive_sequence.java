// Problem: Longest Consecutive Sequence
// Link: https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // only start counting if num is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
