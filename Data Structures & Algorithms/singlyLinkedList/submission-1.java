class LinkedList {
    class ListNode{
        ListNode next=null;
        int val;
        public ListNode(int val)
        {
            this.val=val;
        }
        public ListNode(int val, ListNode next)
        {
            this.val=val;
            this.next=next;
        }
    }
    private ListNode head;
    private ListNode tail;
    public LinkedList() {
        this.head=new ListNode(-1);
        this.tail=new ListNode(-1);
        head.next=tail;
    }

    public int get(int index) {
        ListNode curr=head.next;
        int idx=0;
        while(curr!=null && curr!=tail)
        {
            if(idx==index) return curr.val;
            idx++;
            curr=curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        //ListNode curr=head;
        ListNode newHead=new ListNode(val,head.next);
        head.next=newHead;
    }

    public void insertTail(int val) {
        ListNode newTail=new ListNode(val,tail);
        ListNode curr=head;
        while(curr.next!=tail)
        {
            curr=curr.next;
        }
        curr.next=newTail;
    }

    public boolean remove(int index) {
        int idx=0;
        ListNode curr=head;
        while(curr.next!=null && curr.next!=tail && idx<index)
        {
            idx++;
            curr=curr.next;
        }
        if(curr.next==null || curr.next==tail) return false;
        curr.next=curr.next.next;
        return true;
        
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode curr=head.next;
        while(curr!=null && curr!=tail)
        {
            list.add(curr.val);
            curr=curr.next;
        }
        return list;
    }
}
