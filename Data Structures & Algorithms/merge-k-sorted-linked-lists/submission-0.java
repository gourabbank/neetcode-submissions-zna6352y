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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(ListNode head:lists)
        {
            ListNode curr=head;
            while(curr!=null)
            {
                pq.add(curr.val);
                curr=curr.next;
            }
        }
        ListNode head=new ListNode(0);
        ListNode tail=head;
        while(!pq.isEmpty())
        {
            tail.next=new ListNode(pq.poll());
            tail=tail.next;
        }
        return head.next;
    }
}
