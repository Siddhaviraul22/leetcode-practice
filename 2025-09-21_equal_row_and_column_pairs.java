// Problem: Equal row and column pairs
// Link:https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();

        // Store rows as string keys
        for (int i = 0; i < n; i++) {
            String key = Arrays.toString(grid[i]);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        // Build columns and check against rowMap
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String key = Arrays.toString(col);
            if (rowMap.containsKey(key)) {
                count += rowMap.get(key);
            }
        }

        return count;
    }
}-