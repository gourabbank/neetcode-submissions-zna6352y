class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public void remove(Node node)
    {
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }

    public void insert(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node curr=map.get(key);
        remove(curr);
        insert(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node curr=map.get(key);
            remove(curr);
            map.remove(key);
            map.put(key,curr);
            insert(curr);
        }
        else
        {
            if(map.size()<capacity)
            {
                Node curr=new Node(key,value);
                insert(curr);
                map.put(key,curr);
            }
            else
            {
                Node lru=tail.prev;
                remove(lru);
                Node node=new Node(key,value);
                map.remove(lru.key);
                map.put(key,node);
                insert(node);
            }
        }
    }
}
