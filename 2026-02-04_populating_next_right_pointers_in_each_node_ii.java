// Problem: Populating Next Right Pointers in Each Node II
// Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node current = root;

        while (current != null) {
            Node dummy = new Node(0);   // dummy head for next level
            Node tail = dummy;          // tail to build next level
            Node temp = current;

            while (temp != null) {
                if (temp.left != null) {
                    tail.next = temp.left;
                    tail = tail.next;
                }
                if (temp.right != null) {
                    tail.next = temp.right;
                    tail = tail.next;
                }
                temp = temp.next;
            }

            current = dummy.next; // move to next level
        }

        return root;
    }
}
