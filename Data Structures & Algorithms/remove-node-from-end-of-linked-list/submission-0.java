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
        int total=0;
        ListNode node=head;
        while(node!=null)
        {
            node=node.next;
            total++;
        }
        if(n==total) return head.next;
        node=head;
        int i=0;
        while(i!=total-n-1)
        {
            node=node.next;
            i++;
        }
        node.next=node.next.next;
        return head;
    }
}
