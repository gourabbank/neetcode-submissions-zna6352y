class TimeMap {

    Set<Integer> set;
    Map<String, Map<Integer,List<String>>> map;

    public TimeMap() {
        this.set=new HashSet<>();
        this.map=new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        {
            map.put(key,new HashMap<>());
        }
        if(!map.get(key).containsKey(timestamp))
        {
            map.get(key).put(timestamp,new ArrayList<>());
        }
        map.get(key).get(timestamp).add(value);
    }
    
    public String get(String key, int timestamp) {
        int time=0;
        if(!map.containsKey(key)) return "";
        for(int t:map.get(key).keySet())
        {
            if(t<=timestamp) time=Math.max(t,time);
        }
        if(time==0) return "";
        return map.get(key).get(time).getLast();

    }
}
