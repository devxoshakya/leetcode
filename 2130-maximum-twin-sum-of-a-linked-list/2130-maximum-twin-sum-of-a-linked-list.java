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
    int maxSum = 0;
    public int pairSum(ListNode head) {
        curr = head;
        abort = false;
        find(head);
        return maxSum;
    }

    private void find(ListNode node){
        if(node == null) return;
        find(node.next);

        if(!abort && (curr == node || curr == node.next)){
            abort = true;
        }

        if(abort) return;

        maxSum = Math.max(maxSum, node.val + curr.val);
        curr = curr.next;
    }
}