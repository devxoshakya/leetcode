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
        ListNode back = head;
        ListNode front = head;

        int i = 1;
        while(i <= n){
            front = front.next;
            i++;
        }

        if(front == null) return head.next;

        while(front != null && front.next != null){
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;

        return head;
    }
}