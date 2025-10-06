// Problem: Lowest Common Ancestor of a Binary Tree
// Link:https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively find p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides returned non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return non-null side
        return left != null ? left : right;
    }
}