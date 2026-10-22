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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode front = head;
        ListNode rear = head;
        for(int i = 0; i < n; i++) {
            rear = rear.next;
        }
        if(rear == null) return head.next;
        ListNode prev = front;
        while(rear != null) {
            prev = front;
            front = front.next;
            rear = rear.next;
        }
        prev.next = front.next;
        return head;
    }
}
