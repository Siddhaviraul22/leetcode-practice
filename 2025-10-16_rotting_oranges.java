// Problem: Rotting Oranges
// Link: https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Collect initial rotten oranges & count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j}); // Rotten orange
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh oranges at all
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Step 2: BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size(); // Process level by level
            boolean rottenThisRound = false;
            
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    // If valid fresh orange
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Make it rotten
                        queue.add(new int[]{nr, nc});
                        freshCount--;
                        rottenThisRound = true;
                    }
                }
            }
            
            if (rottenThisRound) minutes++; // Only count minute if something rotted
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}
