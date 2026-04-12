class MyHashMap {
    private static class Pair{
        int key;
        int value;
        Pair(int key, int value)
        {
            this.key=key;
            this.value=value;
        }
    }

    private LinkedList<Pair>[] bucket;
    private int size=1000;

    public MyHashMap() {
        bucket=new LinkedList[size];
    }
    
    private int hash(int key)
    {
        return key%size;
    }

    public void put(int key, int value) {
        int idx=hash(key);
        if(bucket[idx]==null)
        {
            bucket[idx]=new LinkedList<>();
        }
        for(Pair p:bucket[idx])
        {
            if(p.key==key)
            {
                p.value=value;
                return;
            }
        }
        bucket[idx].add(new Pair(key,value));
    }
    
    public int get(int key) {
        int idx=hash(key);
        if(bucket[idx]!=null)
        {
            for(Pair p:bucket[idx])
            {
                if(p.key==key)
                {
                    return p.value;
                }
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx=hash(key);
        if(bucket[idx]!=null)
        {
            bucket[idx].removeIf(p->p.key==key);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */