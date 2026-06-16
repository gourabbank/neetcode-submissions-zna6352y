class TimeMap {
    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        this.map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new TreeMap<>());
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        String val="";
        if(!map.containsKey(key)) return val;
        for(Integer t:map.get(key).descendingKeySet())
        {
            if(t>timestamp) continue;
            else return map.get(key).get(t);
        }
        return val;
    }
}
