// Problem: Count Good Nodes in Binary Tree
// Link:https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;
        
        int count = 0;
        if (node.val >= maxSoFar) count = 1; // current node is good
        
        // update max value along the path
        int newMax = Math.max(maxSoFar, node.val);
        
        // recurse for left and right children
        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);
        
        return count;
    }
}