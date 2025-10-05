// Problem: Longest ZigZag Path in a Binary Tree
// Link:https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

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
    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxLen;
    }

    // returns int[]{startLeft, startRight}
    // startLeft: longest zigzag length starting here with first move to left
    // startRight: longest zigzag length starting here with first move to right
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{-1, -1}; // -1 so leaf => 0 after +1

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int startLeft = left[1] + 1;   // we go left, then next should go right (left[1])
        int startRight = right[0] + 1; // we go right, then next should go left (right[0])

        maxLen = Math.max(maxLen, Math.max(startLeft, startRight));
        return new int[]{startLeft, startRight};
    }
}