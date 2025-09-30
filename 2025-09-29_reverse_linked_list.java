// Problem: Odd Even Linked List
// Link:https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-755


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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // store next
            curr.next = prev;              // reverse pointer
            prev = curr;                   // move prev forward
            curr = nextNode;              // move curr forward
        }

        return prev; // new head of reversed list
    }
}