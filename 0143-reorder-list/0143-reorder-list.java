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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = midNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode headFirst = head;
        while(headFirst != null && headSecond != null){
            ListNode temp1 = headFirst.next;
            ListNode temp2 = headSecond.next;
            headFirst.next = headSecond;
            headSecond.next = temp1;
            headFirst = temp1;
            headSecond = temp2;
        }

        if(headFirst != null){
            headFirst.next = null;
        }

    }

    private ListNode midNode(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}