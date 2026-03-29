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
        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        Stack<ListNode> st=new Stack<>();
        while(curr!=null)
        {
            st.push(curr);
            curr=curr.next;
        }
        curr=dummy;
        dummy.next=curr;
        while(!st.isEmpty())
        {
            curr.next=st.pop();
            curr=curr.next;
        }
        curr.next=null;
        return dummy.next;
    }
}
