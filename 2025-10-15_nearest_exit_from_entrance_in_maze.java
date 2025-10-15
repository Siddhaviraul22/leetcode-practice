// Problem: Nearest Exit from Entrance in Maze
// Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // row, col, steps
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], steps = curr[2];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check bounds and empty cell
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.') {
                    // Check if it's an exit (boundary but not entrance)
                    if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                        return steps + 1;
                    }
                    maze[nr][nc] = '+';  // Mark visited
                    queue.offer(new int[]{nr, nc, steps + 1});
                }
            }
        }
        
        return -1; // No exit found
    }
}
