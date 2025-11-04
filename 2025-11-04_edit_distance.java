// Problem: Edit Distance
// Link: https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases: if one string is empty
        for (int i = 0; i <= m; i++) dp[i][0] = i;  // delete all
        for (int j = 0; j <= n; j++) dp[0][j] = j;  // insert all

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // same character, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // take min of insert, delete, replace
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],               // delete
                        Math.min(dp[i][j - 1],     // insert
                                 dp[i - 1][j - 1]) // replace
                    );
                }
            }
        }

        return dp[m][n];
    }
}
