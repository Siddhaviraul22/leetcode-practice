// Problem: Minimum Flips to Make a OR b Equal to c
// Link: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        for (int i = 0; i < 31; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 1) {
                // At least one of a or b must be 1
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            } else { 
                // bitC == 0 → both a and b must be 0
                if (bitA == 1) flips++;
                if (bitB == 1) flips++;
            }
        }
        
        return flips;
    }
}
