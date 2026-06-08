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
    ListNode curr;
    boolean abort;
    public void reorderList(ListNode head) {
        curr = head;
        abort = false;
        reorder(curr);
    }

    private void reorder(ListNode node){
        if(node == null) return;
        reorder(node.next);
        if(!abort && (curr == node || curr.next == node)){
            node.next = null;
            abort = true;
        }
        if(abort) return;

        ListNode next = curr.next;
        curr.next = node;
        node.next = next;
        curr = next;
    }
}