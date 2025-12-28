// Problem: Isomorphic Strings
// Link: https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If mapping exists, it must be consistent
            if (mapST[c1] != 0 || mapTS[c2] != 0) {
                if (mapST[c1] != c2 || mapTS[c2] != c1) {
                    return false;
                }
            } else {
                // Create new mapping
                mapST[c1] = c2;
                mapTS[c2] = c1;
            }
        }
        return true;
    }
}
