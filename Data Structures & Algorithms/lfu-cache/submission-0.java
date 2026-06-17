class LFUCache {
    class Node{
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        public Node(int key, int value)
        {
            this.key=key;
            this.val=value;
            this.freq=1;
        }
    }
    class LFU{
        Node head, tail;
        int size;
        LFU(){
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        void addLast(Node node)
        {
            node.prev=tail.prev;
            tail.prev.next=node;
            node.next=tail;
            tail.prev=node;
            size++;
        }
        void remove(Node node)
        {
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        Node removeFirst()
        {
            if(size==0) return null;
            Node node=head.next;
            remove(node);
            return node;
        }
    }
    int capacity, minFreq;
    Map<Integer,Node> keyMap; //key,node
    Map<Integer,LFU> freqMap; //key, freq
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=0;
        this.keyMap=new HashMap<>();
        this.freqMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;
        Node node=keyMap.get(key);
        bump(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(keyMap.containsKey(key))
        {
            Node node=keyMap.get(key);
            node.val=value;
            bump(node);
            return;
        }
        if(keyMap.size()>=capacity)
        {
            LFU minList=freqMap.get(minFreq);
            Node evict=minList.removeFirst();
            keyMap.remove(evict.key);
        }
        Node node=new Node(key,value);
        keyMap.put(key,node);
        freqMap.putIfAbsent(1,new LFU());
        freqMap.get(1).addLast(node);
        minFreq=1;
    }
    public void bump(Node node)
    {
        int freq=node.freq;
        LFU list=freqMap.get(freq);
        list.remove(node);
        if(list.size==0)
        {
            freqMap.remove(freq);
            if(minFreq==freq) minFreq++;
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq,new LFU());
        freqMap.get(node.freq).addLast(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */