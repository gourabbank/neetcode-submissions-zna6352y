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
        int size=list.size();
        if(size-n-1<0) return head.next;
        if(size-n+1>=size)
        {
            list.get(size-n-1).next=null;
            return head;
        }
        list.get(size-n-1).next=list.get(size-n+1);
        return head;
    }
}
