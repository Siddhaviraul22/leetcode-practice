// Problem: Delete the Middle Node of a Linked List
// Link:https:https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // If there's only one node, return null after deleting it
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow, fast, and prev pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast by 2 and slow by 1 to find the middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        prev.next = slow.next;

        return head;
    }
}