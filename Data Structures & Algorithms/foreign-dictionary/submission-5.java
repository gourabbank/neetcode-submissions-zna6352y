class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> graph=new HashMap<>();
        for(String s:words)
        {
            for(char ch:s.toCharArray())
            {
                graph.putIfAbsent(ch,new HashSet<>());
            }
        }
        for(int i=0;i<words.length-1;i++)
        {
            String word1=words[i];
            String word2=words[i+1];
            if(word1.length()>word2.length() && word1.startsWith(word2)) return "";
            int len=Math.min(word1.length(),word2.length());
            for(int j=0;j<len;j++)
            {
                char c1=word1.charAt(j);
                char c2=word2.charAt(j);
                if(c1!=c2)
                {
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }
        Map<Character,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:graph.keySet())
        {
            if(dfs(graph,map,sb,ch)) return "";
        }
        return sb.reverse().toString();
    }
    public boolean dfs(Map<Character,Set<Character>> graph, Map<Character,Integer> map, StringBuilder sb, char ch)
    {
        if(map.getOrDefault(ch,0)==1) return true;
        if(map.getOrDefault(ch,0)==2) return false;
        map.put(ch,1);
        for(char next:graph.get(ch))
        {
            if(dfs(graph,map,sb,next)) return true;
        }
        map.put(ch,2);
        sb.append(ch);
        return false;
    }
}
