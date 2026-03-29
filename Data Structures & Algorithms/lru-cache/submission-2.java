class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        delete(node);
        addFront(node);
        map.remove(key);
        map.put(key,node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node=new Node(key,value);
            delete(map.get(key));
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
                delete(lru);
                map.remove(lru.key);
                Node node=new Node(key,value);
                map.put(key,node);
                addFront(node);
            }
        }
    }
    void delete(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    void addFront(Node node)
    {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
}
