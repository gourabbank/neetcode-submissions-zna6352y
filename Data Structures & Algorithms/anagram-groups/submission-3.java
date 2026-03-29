class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs)
        {
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(!map.containsKey(key))
            {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> sol=new ArrayList<>();
        for(List<String> list:map.values())
        {
            sol.add(new ArrayList<>(list));
        }
        return sol;
    }
}
