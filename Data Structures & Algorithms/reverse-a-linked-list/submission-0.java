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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack=new Stack();
        ListNode dummy=new ListNode(0);
        while(head!=null)
        {
            stack.push(head);
            head=head.next;
        }
        ListNode newCurr=dummy;
        while(!stack.isEmpty())
        {
            newCurr.next=stack.pop();
            newCurr=newCurr.next;
        }
        newCurr.next=null;
        return dummy.next;
    }
}
