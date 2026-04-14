class LRUCache {
    class Node
    {
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    protected Node head;
    protected Node tail;
    Map<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.map=new HashMap<>();
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public void remove(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addFront(Node node)
    {
        head.next.prev=node;
        node.next=head.next;
        node.prev=head;
        head.next=node;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        map.remove(key);
        int val=node.val;
        remove(node);
        addFront(node);
        map.put(key,node);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            remove(node);
            node.val=value;
            map.remove(key);
            addFront(node);
            map.put(key,node);
        }
        else
        {
            if(map.size()<capacity)
            {
                Node node=new Node(key,value);
                map.put(key,node);
                addFront(node);
            }
            else
            {
                Node lru=tail.prev;
                remove(lru);
                map.remove(lru.key);
                Node node=new Node(key,value);
                map.put(key,node);
                addFront(node);
            }
        }
    }
}
