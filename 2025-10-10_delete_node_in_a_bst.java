// Problem: Delete Node in a BST
// Link: https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=study-plan-v2&envId=leetcode-75

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null; // Base case
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);  // Search in left subtree
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Search in right subtree
        } 
        else {
            // Case 1 & 2: Node with 0 or 1 child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Node with 2 children
            TreeNode minNode = findMin(root.right); // Find inorder successor
            root.val = minNode.val;  // Replace value
            root.right = deleteNode(root.right, minNode.val); // Delete successor
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}