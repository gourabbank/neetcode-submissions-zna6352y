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
            int len = Math.min(word1.length(), word2.length());
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
        int[] visited=new int[26];
        StringBuilder sb=new StringBuilder();
        for(char ch:graph.keySet())
        {
            if(dfs(graph,visited,ch,sb)) return "";
        }
        return sb.reverse().toString();
    }
    public boolean dfs(Map<Character,Set<Character>> graph, int[] visited, char ch, StringBuilder sb)
    {
        if(visited[ch-'a']==1) return true;
        if(visited[ch-'a']==2) return false;
        visited[ch-'a']=1;
        for(char next:graph.get(ch))
        {
            if(dfs(graph,visited,next,sb)) return true;
        }
        visited[ch-'a']=2;
        sb.append(ch);
        return false;
    }
}
