/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        int lengthCycle = 0;
        while(fast.next != null && fast !=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                lengthCycle = length(slow);
                break;
            }
        }


        if(lengthCycle == 0){
            return null;
        }

        ListNode first = head;
        ListNode second = slow;

        while(first!=second){
            first = first.next;
            second = second.next;
        }

        return first;
            

    }

    private int length(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while(temp!=slow);
                return length;
            }
        }
        return 0;
    }
}