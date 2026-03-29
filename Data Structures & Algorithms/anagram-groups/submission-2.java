class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs)
        {
            char chars[]=s.toCharArray();
            Arrays.sort(chars);
            String st=new String(chars);
            if(!map.containsKey(st)) map.put(st,new ArrayList<>());
            map.get(st).add(s);
        }
        for(List<String> list:map.values())
        {
            sol.add(new ArrayList<>(list));
        }
        return sol;
    }
}
