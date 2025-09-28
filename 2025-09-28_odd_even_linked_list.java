// Problem: Odd Even Linked List
// Link:https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;           // Tracks odd-indexed nodes
        ListNode even = head.next;     // Tracks even-indexed nodes
        ListNode evenHead = even;      // Save head of even list to attach later

        while (even != null && even.next != null) {
            odd.next = even.next;      // Link current odd to next odd
            odd = odd.next;            // Move odd pointer
            
            even.next = odd.next;      // Link current even to next even
            even = even.next;          // Move even pointer
        }

        odd.next = evenHead;  // Attach even list at the end of odd list
        return head;
    }
}