// Problem: Reorder Routes to Make All Paths Lead to the City Zero
// Link: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Build adjacency list: (neighbor, needsReversal)
        for (int[] edge : connections) {
            graph.get(edge[0]).add(new int[]{edge[1], 1}); // original direction: edge[0] -> edge[1]
            graph.get(edge[1]).add(new int[]{edge[0], 0}); // reverse edge, doesn't need change
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] next : graph.get(node)) {
            int neighbor = next[0];
            int needsReversal = next[1];

            if (!visited[neighbor]) {
                changes += needsReversal + dfs(neighbor, graph, visited);
            }
        }

        return changes;
    }
}

