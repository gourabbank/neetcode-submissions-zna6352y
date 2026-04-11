class MyHashSet {
    private int[] hashset;
    int size;
    public MyHashSet() {
        this.size=1000000;
        hashset=new int[size];
        hashset[0]=-1;
    }
    
    public void add(int key) {
        hashset[key]=key;
    }
    
    public void remove(int key) {
        hashset[key]=-1;
    }
    
    public boolean contains(int key) {
        return hashset[key]==key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */