class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs)
        {
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }
        for(String key:map.keySet())
        {
            sol.add(new ArrayList(map.get(key)));
        }
        return sol;
    }
}
