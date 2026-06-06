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
        if (head.next == null || head == null)
            return null;

        ListNode end = head;
        ListNode nth = head;

        int i = 1;
        while (i <= n) {
            end = end.next;
            i++;
        }

        if (end == null)
            return head.next;

        while (end.next != null) {
            end = end.next;
            nth = nth.next;
        }

        if (nth.next != null) {
            nth.next = nth.next.next;
        }

        return head;

    }
}