class LRUCache {
    class Node{
        int key;
        int val;
        Node prev,next;
        Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        this.map=new HashMap<>();
    }

    public void addFront(Node node)
    {
        head.next.prev=node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
    }
    public void remove(Node node)
    {
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        remove(node);
        addFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            node.val=value;
            remove(node);
            addFront(node);
            map.put(key,node);
        }
        else
        {
            Node node=new Node(key,value);
            map.put(key,node);
            addFront(node);
            if(map.size()>capacity)
            {
                Node lru=tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }
}
