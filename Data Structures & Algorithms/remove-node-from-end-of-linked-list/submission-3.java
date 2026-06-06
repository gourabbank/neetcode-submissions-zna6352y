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
        List<ListNode> list=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null)
        {
            list.add(curr);
            curr=curr.next;
        }
        int loc=list.size()-n;
        if(loc-1<0)
        {
            return head.next;
        }
        ListNode prev=list.get(loc-1);
        prev.next=list.get(loc).next;
        return head;
    }
}
