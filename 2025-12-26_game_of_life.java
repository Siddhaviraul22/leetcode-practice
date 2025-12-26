// Problem: Game of Life
// Link: https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1},  {1, 0}, {1, 1}
        };

        // First pass: mark transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                for (int[] d : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (Math.abs(board[x][y]) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                // Rule application
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // live → dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // dead → live
                    }
                }
            }
        }

        // Second pass: finalize states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }
}
